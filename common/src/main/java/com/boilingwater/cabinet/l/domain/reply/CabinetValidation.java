package com.boilingwater.cabinet.l.domain.reply;

/**
 * 设备验证
 *
 * @author Benana
 * @since 2024-01-30
 */
public class CabinetValidation extends ReplyDateField {

    private Boolean valid;

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "CabinetValidation{" + "valid=" + valid + '}';
    }
}
