package com.boilingwater.cabinet.l.domain.reply;

/**
 * 下发BT码
 *
 * @author Benana
 * @since 2024-01-30
 */
public class SendBtCodeReply extends ReplyDateField {

    /**
     * BT码
     */
    private String btCode;

    public String getBtCode() {
        return btCode;
    }

    public void setBtCode(String btCode) {
        this.btCode = btCode;
    }

    @Override
    public String toString() {
        return "SendBtCode{" +
                "btCode='" + btCode + '\'' +
                '}';
    }
}
