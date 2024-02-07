package com.boilingwater.cabinet.l.domain.receive;

import java.math.BigDecimal;

/**
 * 仓内电池信息
 *
 * @author Benana
 * @since 2024-01-30
 */
public class BatteryInfoReceive extends ReceiveDataField {

    /**
     * BT码
     * 数据为ASCII 码转换的文本数据
     * B T 2 060 060 10 732ZHKJ 58551964 对应的为42 54 32 303630 303630 3130373332 5A484B4A 3538353531393634
     * （不存在时为FF）
     */
    private String btCode;

    /**
     * 当前电压
     * 77.77V 对应：1E61
     */
    private BigDecimal voltage;

    /**
     * 当前电流
     * 15.15A 对应05EB
     */
    private BigDecimal electricity;

    /**
     * 当前电量
     * 77.7% 对应0309
     */
    private BigDecimal electricQuantity;

    public String getBtCode() {
        return btCode;
    }

    public void setBtCode(String btCode) {
        this.btCode = btCode;
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

    public BigDecimal getElectricQuantity() {
        return electricQuantity;
    }

    public void setElectricQuantity(BigDecimal electricQuantity) {
        this.electricQuantity = electricQuantity;
    }

    @Override
    public String toString() {
        return "BatteryInfoReceive{" +
                "btCode='" + btCode + '\'' +
                ", voltage=" + voltage +
                ", electricity=" + electricity +
                ", electricQuantity=" + electricQuantity +
                '}';
    }
}
