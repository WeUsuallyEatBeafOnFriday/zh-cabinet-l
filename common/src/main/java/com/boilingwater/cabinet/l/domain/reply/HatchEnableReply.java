package com.boilingwater.cabinet.l.domain.reply;

/**
 * 禁用/启用仓
 *
 * @author Benana
 * @since 2024-01-30
 */
public class HatchEnableReply extends ReplyDateField {

    /**
     * 00（启用），01（禁用）
     */
    private Integer enable;

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "HatchEnableReply{" +
                "enable=" + enable +
                '}';
    }
}
