package com.boilingwater.cabinet.l.domain.reply;

/**
 * 操作风扇
 *
 * @author Benana
 * @since 2024-01-30
 */
public class FanReply extends ReplyDateField {

    /**
     * 06 对应6 （00 就是关闭所有风扇）
     */
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FanReply{" +
                "number=" + number +
                '}';
    }
}
