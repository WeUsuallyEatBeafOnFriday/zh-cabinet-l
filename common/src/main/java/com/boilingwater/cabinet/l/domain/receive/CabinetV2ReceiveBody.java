package com.boilingwater.cabinet.l.domain.receive;

import java.io.Serializable;

/**
 * L系列电柜接收消息包装
 *
 * @param <T> 具体指令内容
 * @author Benana
 * @since 2024-01-30
 */
public class CabinetV2ReceiveBody<T extends ReceiveDataField> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 通道ID
     */
    private String channelId;

    /**
     * 原数据
     */
    private String rawMsg;

    /**
     * 指令
     */
    private String command;

    /**
     * 设备唯一标识
     */
    private String mac;

    /**
     * 仓位
     */
    private Integer hatch;

    /**
     * 数据域长度
     */
    private Integer dataFieldLen;

    /**
     * 数据域原数据
     */
    private String dataFieldStr;

    /**
     * 数据域
     */
    private T dataField;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getRawMsg() {
        return rawMsg;
    }

    public void setRawMsg(String rawMsg) {
        this.rawMsg = rawMsg;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getHatch() {
        return hatch;
    }

    public void setHatch(Integer hatch) {
        this.hatch = hatch;
    }

    public Integer getDataFieldLen() {
        return dataFieldLen;
    }

    public void setDataFieldLen(Integer dataFieldLen) {
        this.dataFieldLen = dataFieldLen;
    }

    public String getDataFieldStr() {
        return dataFieldStr;
    }

    public void setDataFieldStr(String dataFieldStr) {
        this.dataFieldStr = dataFieldStr;
    }

    public T getDataField() {
        return dataField;
    }

    public void setDataField(T dataField) {
        this.dataField = dataField;
    }

    @Override
    public String toString() {
        return "CabinetV2ReceiveBody{" +
                        "channelId='" + channelId + '\'' +
                        ", rawMsg='" + rawMsg + '\'' +
                        ", command='" + command + '\'' +
                        ", mac='" + mac + '\'' +
                        ", hatch='" + hatch + '\'' +
                        ", dataFieldLen=" + dataFieldLen +
                        ", dataFieldStr='" + dataFieldStr + '\'' +
                        ", dataField=" + dataField +
                        '}';
    }
}
