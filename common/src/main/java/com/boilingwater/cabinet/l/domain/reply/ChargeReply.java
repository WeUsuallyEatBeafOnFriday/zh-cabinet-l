package com.boilingwater.cabinet.l.domain.reply;

import java.math.BigDecimal;

/**
 * 请求电量（无通讯电池请求）
 *
 * @author Benana
 * @since 2024-01-30
 */
public class ChargeReply extends ReplyDateField {

    /**
     * 电量
     */
    private BigDecimal electricQuantity;

    public BigDecimal getElectricQuantity() {
        return electricQuantity;
    }

    public void setElectricQuantity(BigDecimal electricQuantity) {
        this.electricQuantity = electricQuantity;
    }

    @Override
    public String toString() {
        return "ChargeReply{" +
                "electricQuantity=" + electricQuantity +
                '}';
    }
}
