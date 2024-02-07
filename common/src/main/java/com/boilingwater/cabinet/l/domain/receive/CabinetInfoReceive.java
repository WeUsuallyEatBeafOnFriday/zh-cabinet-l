package com.boilingwater.cabinet.l.domain.receive;

import java.math.BigDecimal;

/**
 * 电柜信息
 *
 * @author Benana
 * @since 2024-01-30
 */
public class CabinetInfoReceive extends ReceiveDataField {

    /**
     * 信号强度，分五级00-05（数值越大信号越好）
     */
    private Integer signalStrength;

    /**
     * 电柜温度正负数，00(正数) 01(负数)
     */
    private Integer temperaturePlusOrMinus;

    /**
     * 温度，主板NTC 的温度值
     */
    private BigDecimal temperature;

    /**
     * 湿度
     */
    private BigDecimal humidity;

    /**
     * 工作散热，扇热风扇的数量（0-6）
     */
    private Integer radiatorQuantity;

    /**
     * 电压，例：230.5V，即：0901（不存在时为FF）
     */
    private BigDecimal voltage;

    /**
     * 电流，例：35.05A，即：0DB1（不存在时为FF）
     */
    private BigDecimal electricity;

    /**
     * 用电量，6501.35KWh，即：0009EB97 （不存在时为FF）
     */
    private BigDecimal power;

    public Integer getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(Integer signalStrength) {
        this.signalStrength = signalStrength;
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

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public Integer getRadiatorQuantity() {
        return radiatorQuantity;
    }

    public void setRadiatorQuantity(Integer radiatorQuantity) {
        this.radiatorQuantity = radiatorQuantity;
    }

    public BigDecimal getVoltage() {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public BigDecimal getElectricity() {
        return electricity;
    }

    public void setElectricity(BigDecimal electricity) {
        this.electricity = electricity;
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "CabinetInfoReceive{" +
                        "signalStrength='" + signalStrength + '\'' +
                        ", temperaturePlusOrMinus=" + temperaturePlusOrMinus +
                        ", temperature=" + temperature +
                        ", humidity=" + humidity +
                        ", radiatorQuantity=" + radiatorQuantity +
                        ", voltage=" + voltage +
                        ", electricity=" + electricity +
                        ", power=" + power +
                        '}';
    }
}
