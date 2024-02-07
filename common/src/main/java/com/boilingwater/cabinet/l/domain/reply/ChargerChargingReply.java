package com.boilingwater.cabinet.l.domain.reply;

import java.math.BigDecimal;

/**
 * 充电器充电
 *
 * @author Benana
 * @since 2024-01-30
 */
public class ChargerChargingReply extends ReplyDateField {

    /**
     * 00（开启），01（关闭）
     */
    private Integer open;

    /**
     * 充电电压
     */
    private BigDecimal voltage;

    /**
     * 充电电流
     */
    private BigDecimal electricity;

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
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

    @Override
    public String toString() {
        return "ChargerChargingReply{" + "open=" + open + ", voltage=" + voltage + ", electricity=" + electricity + '}';
    }
}
