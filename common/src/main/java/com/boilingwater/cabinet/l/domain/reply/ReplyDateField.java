package com.boilingwater.cabinet.l.domain.reply;

import java.io.Serializable;

/**
 * 指令继承类
 *
 * @author Benana
 * @since 2024-01-30
 */
public class ReplyDateField implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 按照顺序的dataField所有字段的16进制数据
     */
    private String hexDataField;

    public String getHexDataField() {
        return hexDataField;
    }

    public void setHexDataField(String hexDataField) {
        this.hexDataField = hexDataField;
    }

    @Override
    public String toString() {
        return "BaseDateField{" + "hexDataField='" + hexDataField + '\'' + '}';
    }
}
