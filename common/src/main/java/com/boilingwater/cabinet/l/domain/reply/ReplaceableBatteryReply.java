package com.boilingwater.cabinet.l.domain.reply;

/**
 * 请求可换电池组数
 *
 * @author Benana
 * @since 2024-01-30
 */
public class ReplaceableBatteryReply extends ReplyDateField {

    /**
     * 可换电池组数，12 对应0C
     */
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ReplaceableBatteryReply{" +
                "quantity=" + quantity +
                '}';
    }
}
