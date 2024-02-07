package com.boilingwater.cabinet.l.service;

import com.alibaba.fastjson2.JSONObject;
import com.boilingwater.cabinet.l.constants.Cabinet9eCmdConstants;
import com.boilingwater.cabinet.l.domain.reply.CabinetConfigReply;
import com.boilingwater.cabinet.l.domain.reply.CabinetOtaUpdateReply;
import com.boilingwater.cabinet.l.domain.reply.CabinetV2ReplyBody;
import com.boilingwater.cabinet.l.domain.reply.ChargerChargingReply;
import com.boilingwater.cabinet.l.domain.reply.FanReply;
import com.boilingwater.cabinet.l.domain.reply.HatchEnableReply;
import com.boilingwater.cabinet.l.domain.reply.HatchOtaUpdateReply;
import com.boilingwater.cabinet.l.domain.reply.IpConfigReply;
import com.boilingwater.cabinet.l.domain.reply.ReplyDateField;
import com.boilingwater.cabinet.l.domain.reply.SendBtCodeReply;
import com.boilingwater.cabinet.l.domain.reply.SetErrorReply;
import com.boilingwater.cabinet.l.handler.CheckSuccessHandler;
import com.boilingwater.cabinet.l.properties.Cabinet9eAmqpProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;

/**
 * L系列电柜AMPQ Service
 *
 * @author Benana
 * @since 2024-01-30
 */
@Service("cabinet9eAmqpService")
public class Cabinet9eAmqpService {

    private static final Logger logger = LoggerFactory.getLogger(Cabinet9eAmqpService.class);

    /**
     * BT码长度
     */
    private static final int BT_CODE_LENGTH = 26;

    private final Cabinet9eAmqpProperties cabinet9eAmqpProperties;

    private final RabbitTemplate rabbitTemplate;

    private final CheckSuccessHandler checkSuccessHandler;

    @Autowired
    public Cabinet9eAmqpService(Cabinet9eAmqpProperties cabinet9eAmqpProperties,
                                RabbitTemplate rabbitTemplate,
                                CheckSuccessHandler checkSuccessHandler) {
        this.cabinet9eAmqpProperties = cabinet9eAmqpProperties;
        this.rabbitTemplate = rabbitTemplate;
        this.checkSuccessHandler = checkSuccessHandler;
    }

    /**
     * 发送指令并不等待回应
     *
     * @param msg   指令
     * @param await true 等待回应 false 不等待回应
     */
    private void send(CabinetV2ReplyBody<?> msg, boolean await) {
        if (await) {
            sendAndAwait(msg);
        } else {
            sendAndNotAwait(msg);
        }
    }

    /**
     * 发送指令并不等待回应
     *
     * @param msg 指令
     */
    private void sendAndNotAwait(CabinetV2ReplyBody<?> msg) {
        this.rabbitTemplate.convertAndSend(this.cabinet9eAmqpProperties.getExchange(),
                this.cabinet9eAmqpProperties.getSenderRoutingKey(),
                JSONObject.toJSONString(msg));
    }

    /**
     * 发送指令并等待回应
     *
     * @param msg 指令
     */
    private void sendAndAwait(CabinetV2ReplyBody<?> msg) {
        String correlationId = UUID.randomUUID().toString();
        this.checkSuccessHandler.preSet(new HashMap<>(), correlationId);
        this.rabbitTemplate.convertAndSend(this.cabinet9eAmqpProperties.getExchange(),
                this.cabinet9eAmqpProperties.getSenderRoutingKey(),
                JSONObject.toJSONString(msg),
                message -> {
                    message.getMessageProperties().setCorrelationId(correlationId);
                    return message;
                });
        this.checkSuccessHandler.doCheck(new HashMap<>(), correlationId);
    }

    /**
     * 下发BT码
     *
     * @param snNo     电柜编码
     * @param hatchNum 仓门号
     * @param btCode   设备BT码
     * @throws RuntimeException BT码不符合规则
     */
    public void cmdSendBtCode(String snNo, int hatchNum, String btCode) {
        if (ObjectUtils.isEmpty(btCode) || btCode.length() != BT_CODE_LENGTH) {
            throw new RuntimeException("BT码不符合规则");
        }

        // 模拟处理业务后得到消息
        CabinetV2ReplyBody<ReplyDateField> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_SEND_BT_CODE);
        cabinetV2ReplyBody.setMac(snNo);
        cabinetV2ReplyBody.setHatch(hatchNum);

        SendBtCodeReply replyDateField = new SendBtCodeReply();
        replyDateField.setBtCode(btCode);
        cabinetV2ReplyBody.setDataField(replyDateField);
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 下发电柜配置
     *
     * @param snNo        电柜编号
     * @param volumeLevel 音量大小
     * @param power       功率
     * @param brandCode   品牌识别码（ASCII码）
     * @param phone       手机号（明文）
     */
    public void cmdCabinetConfig(String snNo, int volumeLevel, int power, String brandCode, String phone) {
        CabinetV2ReplyBody<CabinetConfigReply> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_CABINET_CONFIG);
        cabinetV2ReplyBody.setMac(snNo);

        CabinetConfigReply cabinetConfigReply = new CabinetConfigReply();
        cabinetConfigReply.setVolumeLevel(volumeLevel);
        cabinetConfigReply.setPower(power);
        cabinetConfigReply.setBrandCode(brandCode);
        cabinetConfigReply.setPhone(phone);
        cabinetV2ReplyBody.setDataField(cabinetConfigReply);
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 重启主机
     *
     * @param snNo 电柜编号
     */
    public void cmdRestart(String snNo) {
        CabinetV2ReplyBody<ReplyDateField> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_RESTART);
        cabinetV2ReplyBody.setMac(snNo);

        cabinetV2ReplyBody.setDataField(new ReplyDateField());
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 恢复出厂设置
     *
     * @param snNo 电柜编号
     */
    public void cmdFactoryReset(String snNo) {
        CabinetV2ReplyBody<ReplyDateField> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_FACTORY_RESET);
        cabinetV2ReplyBody.setMac(snNo);

        cabinetV2ReplyBody.setDataField(new ReplyDateField());
        send(cabinetV2ReplyBody, true);
    }

    /**
     * IP修改设置
     *
     * @param snNo      电柜编号
     * @param ipAddress IP地址
     * @param port      端口
     */
    public void cmdIpConfig(String snNo, String ipAddress, int port) {
        CabinetV2ReplyBody<IpConfigReply> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_IP_CONFIG);
        cabinetV2ReplyBody.setMac(snNo);

        IpConfigReply ipConfigReply = new IpConfigReply();
        ipConfigReply.setIpAddress(ipAddress);
        ipConfigReply.setPort(port);
        cabinetV2ReplyBody.setDataField(ipConfigReply);
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 开锁（仓门+开锁，开锁的同时开灯）
     *
     * @param snNo     电柜编号
     * @param hatchNum 仓门号
     */
    public void cmdUnlock(String snNo, int hatchNum) {
        CabinetV2ReplyBody<ReplyDateField> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_UNLOCK);
        cabinetV2ReplyBody.setHatch(hatchNum);
        cabinetV2ReplyBody.setMac(snNo);

        cabinetV2ReplyBody.setDataField(new ReplyDateField());
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 充电器充电
     *
     * @param snNo        电柜编号
     * @param hatchNum    仓门号
     * @param open        0（开启），1（关闭）
     * @param voltage     充电电压
     * @param electricity 充电电流
     */
    public void cmdChargerCharging(String snNo, int hatchNum, int open, BigDecimal voltage, BigDecimal electricity) {
        CabinetV2ReplyBody<ChargerChargingReply> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_CHARGER_CHARGING);
        cabinetV2ReplyBody.setHatch(hatchNum);
        cabinetV2ReplyBody.setMac(snNo);

        ChargerChargingReply chargerChargingReply = new ChargerChargingReply();
        chargerChargingReply.setOpen(open);
        chargerChargingReply.setVoltage(voltage);
        chargerChargingReply.setElectricity(electricity);
        cabinetV2ReplyBody.setDataField(chargerChargingReply);
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 禁用/启用仓
     *
     * @param snNo     电柜编号
     * @param hatchNum 仓门号
     * @param enable   0（启用），1（禁用）
     */
    public void cmdHatchEnable(String snNo, int hatchNum, int enable) {
        CabinetV2ReplyBody<HatchEnableReply> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_HATCH_ENABLE);
        cabinetV2ReplyBody.setHatch(hatchNum);
        cabinetV2ReplyBody.setMac(snNo);

        HatchEnableReply hatchEnableReply = new HatchEnableReply();
        hatchEnableReply.setEnable(enable);

        cabinetV2ReplyBody.setDataField(hatchEnableReply);
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 操作风扇
     *
     * @param snNo      电柜编号
     * @param fanNumber 风扇编号 0就是关闭所有风扇）
     */
    public void cmdFan(String snNo, int fanNumber) {
        CabinetV2ReplyBody<FanReply> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_FAN);
        cabinetV2ReplyBody.setMac(snNo);

        FanReply fanReply = new FanReply();
        fanReply.setNumber(fanNumber);

        cabinetV2ReplyBody.setDataField(fanReply);
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 电柜OTA升级
     *
     * @param snNo    电柜编号
     * @param otaName 例：固件名为00000001 对应为00000001 <a href="http://ota.hn2016.com/000001.bin">文件下载地址</a>
     */
    public void cmdCabinetOtaUpdate(String snNo, int otaName) {
        CabinetV2ReplyBody<CabinetOtaUpdateReply> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_CABINET_OTA_UPDATE);
        cabinetV2ReplyBody.setMac(snNo);

        CabinetOtaUpdateReply cabinetOtaUpdateReply = new CabinetOtaUpdateReply();
        cabinetOtaUpdateReply.setOtaName(otaName);

        cabinetV2ReplyBody.setDataField(cabinetOtaUpdateReply);
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 仓控板OTA升级
     *
     * @param snNo     电柜编号
     * @param version0 版本0
     * @param version1 版本1
     * @param otaName  ota名称
     */
    public void cmdHatchOtaUpdate(String snNo, int version0, int version1, int otaName) {
        CabinetV2ReplyBody<HatchOtaUpdateReply> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_HATCH_OTA_UPDATE);
        cabinetV2ReplyBody.setMac(snNo);

        HatchOtaUpdateReply hatchOtaUpdateReply = new HatchOtaUpdateReply();
        hatchOtaUpdateReply.setVersion0(version0);
        hatchOtaUpdateReply.setVersion1(version1);
        hatchOtaUpdateReply.setOtaName(otaName);
        cabinetV2ReplyBody.setDataField(hatchOtaUpdateReply);
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 强制清除某仓电池信息
     *
     * @param snNo     电柜编号
     * @param hatchNum 仓门号
     */
    public void cmdClearBattery(String snNo, int hatchNum) {
        CabinetV2ReplyBody<ReplyDateField> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_CLEAR_BATTERY);
        cabinetV2ReplyBody.setHatch(hatchNum);
        cabinetV2ReplyBody.setMac(snNo);

        cabinetV2ReplyBody.setDataField(new ReplyDateField());
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 重启某仓控板
     *
     * @param snNo     电柜编号
     * @param hatchNum 仓门号
     */
    public void cmdHatchRestart(String snNo, int hatchNum) {
        CabinetV2ReplyBody<ReplyDateField> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_HATCH_RESTART);
        cabinetV2ReplyBody.setHatch(hatchNum);
        cabinetV2ReplyBody.setMac(snNo);

        cabinetV2ReplyBody.setDataField(new ReplyDateField());
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 启动灭火器
     *
     * @param snNo     电柜编号
     * @param hatchNum 仓门号
     */
    public void cmdExtinguisher(String snNo, int hatchNum) {
        CabinetV2ReplyBody<ReplyDateField> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_EXTINGUISHER);
        cabinetV2ReplyBody.setHatch(hatchNum);
        cabinetV2ReplyBody.setMac(snNo);

        cabinetV2ReplyBody.setDataField(new ReplyDateField());
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 强制结束当前换电
     *
     * @param snNo 电柜编号
     */
    public void cmdForceEndReplaceBattery(String snNo) {
        CabinetV2ReplyBody<ReplyDateField> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_FORCE_END_REPLACE_BATTERY);
        cabinetV2ReplyBody.setHatch(0);
        cabinetV2ReplyBody.setMac(snNo);

        cabinetV2ReplyBody.setDataField(new ReplyDateField());
        send(cabinetV2ReplyBody, false);
    }

    /**
     * 设置/取消异常仓
     *
     * @param snNo     电柜编号
     * @param hatchNum 仓门号
     * @param error    0（取消异常），1（设置异常）
     */
    public void cmdSetError(String snNo, int hatchNum, int error) {
        CabinetV2ReplyBody<SetErrorReply> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_SET_ERROR);
        cabinetV2ReplyBody.setHatch(hatchNum);
        cabinetV2ReplyBody.setMac(snNo);

        SetErrorReply setErrorReply = new SetErrorReply();
        setErrorReply.setError(error);

        cabinetV2ReplyBody.setDataField(setErrorReply);
        send(cabinetV2ReplyBody, true);
    }

    /**
     * 强制结束当前退电
     *
     * @param snNo 电柜编号
     */
    public void cmdForceEndReturnBattery(String snNo) {
        CabinetV2ReplyBody<ReplyDateField> cabinetV2ReplyBody = new CabinetV2ReplyBody<>();
        cabinetV2ReplyBody.setCommand(Cabinet9eCmdConstants.CMD_FORCE_END_RETURN_BATTERY);
        cabinetV2ReplyBody.setHatch(0);
        cabinetV2ReplyBody.setMac(snNo);

        cabinetV2ReplyBody.setDataField(new ReplyDateField());
        send(cabinetV2ReplyBody, true);
    }

}
