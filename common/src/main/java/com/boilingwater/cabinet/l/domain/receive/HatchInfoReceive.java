package com.boilingwater.cabinet.l.domain.receive;

import java.math.BigDecimal;

/**
 * 仓门信息
 *
 * @author Benana
 * @since 2024-01-30
 */
public class HatchInfoReceive extends ReceiveDataField {

    /**
     * 门状态（不存在时为FF）
     */
    private Integer hatchStatus;

    /**
     * 电池在位信息，00（不存在）,01（存在）（不存在时为FF，初值02 不处理）
     */
    private Integer batteryReignStatus;

    /**
     * 是否存在485通信，00（不存在）,01（存在）（不存在时为FF，初值02 不处理）
     */
    private Integer rs485;

    /**
     * 仓内电压，777.77V 对应：1E61
     */
    private BigDecimal voltage;

    /**
     * 温度正负数，00(正数) 01(负数)（不存在时为FF）
     */
    private Integer temperaturePlusOrMinus;

    /**
     * 温度，例如11，对应0B（不存在时为FF）
     */
    private BigDecimal temperature;

    /**
     * 01（禁用） 00（启用）
     */
    private Integer disableStatus;

    /**
     * 01（异常） 00（非异常）
     */
    private Integer errorStatus;

    public Integer getHatchStatus() {
        return hatchStatus;
    }

    public void setHatchStatus(Integer hatchStatus) {
        this.hatchStatus = hatchStatus;
    }

    public Integer getBatteryReignStatus() {
        return batteryReignStatus;
    }

    public void setBatteryReignStatus(Integer batteryReignStatus) {
        this.batteryReignStatus = batteryReignStatus;
    }

    public Integer getRs485() {
        return rs485;
    }

    public void setRs485(Integer rs485) {
        this.rs485 = rs485;
    }

    public BigDecimal getVoltage() {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public Integer getTemperaturePlusOrMinus() {
        return temperaturePlusOrMinus;
    }

    public void setTemperaturePlusOrMinus(Integer temperaturePlusOrMinus) {
        this.temperaturePlusOrMinus = temperaturePlusOrMinus;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public Integer getDisableStatus() {
        return disableStatus;
    }

    public void setDisableStatus(Integer disableStatus) {
        this.disableStatus = disableStatus;
    }

    public Integer getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Integer errorStatus) {
        this.errorStatus = errorStatus;
    }

    @Override
    public String toString() {
        return "HatchInfoReceive{" +
                "hatchStatus=" + hatchStatus +
                ", batteryReignStatus=" + batteryReignStatus +
                ", rs485=" + rs485 +
                ", voltage=" + voltage +
                ", temperaturePlusOrMinus=" + temperaturePlusOrMinus +
                ", temperature=" + temperature +
                ", disableStatus=" + disableStatus +
                ", errorStatus=" + errorStatus +
                '}';
    }
}
