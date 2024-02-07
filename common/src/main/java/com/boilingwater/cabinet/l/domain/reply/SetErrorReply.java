package com.boilingwater.cabinet.l.domain.reply;

/**
 * 设置/取消异常仓
 *
 * @author Benana
 * @since 2024-01-30
 */
public class SetErrorReply extends ReplyDateField {

    /**
     * 设置异常，00（取消异常），01（设置异常）
     */
    private Integer error;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "SetErrorReply{" +
                "error=" + error +
                '}';
    }
}
