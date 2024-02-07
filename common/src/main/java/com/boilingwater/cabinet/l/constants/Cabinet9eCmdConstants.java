package com.boilingwater.cabinet.l.constants;

/**
 * L系列电柜指令
 *
 * @author Benana
 * @since 2024-01-30
 */
public class Cabinet9eCmdConstants {

    /**
     * 通道验证
     */
    public static final String CMD_CHANNEL_VALIDITY = "validity";

    /**
     * 电柜信息
     */
    public static final String CMD_CABINET_INFO = "01";

    /**
     * 仓门信息
     */
    public static final String CMD_HATCH_INFO = "02";

    /**
     * 仓内电池信息
     */
    public static final String CMD_BATTERY_INFO = "03";

    /**
     * 请求电量
     */
    public static final String CMD_CHARGE = "04";

    /**
     * 下发BT码
     */
    public static final String CMD_SEND_BT_CODE = "05";

    /**
     * 下发换电
     */
    public static final String CMD_REPLACE_BATTERY = "06";

    /**
     * 设备信息
     */
    public static final String CMD_HARDWARE = "07";

    /**
     * 下发电柜配置
     */
    public static final String CMD_CABINET_CONFIG = "08";

    /**
     * 设备注册
     */
    public static final String CMD_REGISTER = "09";

    /**
     * 重启主机
     */
    public static final String CMD_RESTART = "0A";

    /**
     * 恢复出厂设置
     */
    public static final String CMD_FACTORY_RESET = "0B";

    /**
     * IP修改设置
     */
    public static final String CMD_IP_CONFIG = "0C";

    /**
     * 开锁（仓门+开锁，开锁的同时开灯）
     */
    public static final String CMD_UNLOCK = "0D";

    /**
     * 充电器充电
     */
    public static final String CMD_CHARGER_CHARGING = "0E";

    /**
     * 禁用/启用仓
     */
    public static final String CMD_HATCH_ENABLE = "0F";

    /**
     * GPS
     */
    public static final String CMD_GPS = "10";

    /**
     * 报警
     */
    public static final String CMD_ALARMS = "11";

    /**
     * 操作风扇
     */
    public static final String CMD_FAN = "12";

    /**
     * 电柜OTA升级
     */
    public static final String CMD_CABINET_OTA_UPDATE = "13";

    /**
     * 电柜OTA、仓控板升级结果
     */
    public static final String CMD_OTA_UPDATE_RESULT = "14";

    /**
     * 仓控板OTA升级
     */
    public static final String CMD_HATCH_OTA_UPDATE = "15";

    /**
     * 换电结果
     */
    public static final String CMD_REPLACE_BATTERY_RESULT = "16";

    /**
     * 请求可换电池组
     */
    public static final String CMD_REPLACEABLE_BATTERY = "17";

    /**
     * 仓控版本号
     */
    public static final String CMD_HATCH_OTA_VERSION = "18";

    /**
     * 强制清除某仓电池信息
     */
    public static final String CMD_CLEAR_BATTERY = "19";

    /**
     * 重启某仓控板
     */
    public static final String CMD_HATCH_RESTART = "1A";

    /**
     * 启动灭火器
     */
    public static final String CMD_EXTINGUISHER = "1B";

    /**
     * 开门（租电专用）
     */
    public static final String CMD_RENT_UNLOCK = "1C";

    /**
     * 强制结束当前换电
     */
    public static final String CMD_FORCE_END_REPLACE_BATTERY = "1D";

    /**
     * 上报异常状态
     */
    public static final String CMD_REPORT_EXCEPTION = "1E";

    /**
     * 设置/取消异常仓
     */
    public static final String CMD_SET_ERROR = "1F";

    /**
     * 退电池
     */
    public static final String CMD_RETURN_BATTERY = "20";

    /**
     * 退电池结果
     */
    public static final String CMD_RETURN_BATTERY_RESULT = "21";

    /**
     * 强制结束当前退电
     */
    public static final String CMD_FORCE_END_RETURN_BATTERY = "22";

    /**
     * 应用端操作指令上报
     */
    public static final String CMD_OPERATION_REPORT = "AA";

    /**
     * 异常上报（开发者调试和定位问题所用）
     */
    public static final String CMD_REPORT_EXCEPTION_DEBUG = "00";

}
