package com.boilingwater.cabinet.l.domain.reply;

/**
 * 电柜OTA升级
 *
 * @author Benana
 * @since 2024-01-30
 */
public class CabinetOtaUpdateReply extends ReplyDateField {

    /**
     * 例：固件名为00000001 对应为00000001
     * 文件下载地址：http://ota.hn2016.com/000001.bin
     */
    private Integer otaName;

    public Integer getOtaName() {
        return otaName;
    }

    public void setOtaName(Integer otaName) {
        this.otaName = otaName;
    }

    @Override
    public String toString() {
        return "OtaUpdateReply{" +
                        "otaName=" + otaName +
                        '}';
    }
}
