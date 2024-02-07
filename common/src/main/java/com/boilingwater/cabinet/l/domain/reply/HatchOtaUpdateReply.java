package com.boilingwater.cabinet.l.domain.reply;

/**
 * 仓控板OTA升级
 *
 * @author Benana
 * @since 2024-01-30
 */
public class HatchOtaUpdateReply extends ReplyDateField {

    /**
     * 升级版本0
     * 命名规则: DATA[0] DATA[1]:0X01,0X02,
     * 版本："v"+version0+"."+version1
     */
    private Integer version0;

    /**
     * 升级版本1
     * 命名规则: DATA[0] DATA[1]:0X01,0X02,
     * 版本："v"+version0+"."+version1
     */
    private Integer version1;

    /**
     * 例：固件名为0001 对应为0001
     * 文件下载地址：http://ota.hn2016.com/cab2/ckb/0102.bin
     */
    private Integer otaName;

    public Integer getVersion0() {
        return version0;
    }

    public void setVersion0(Integer version0) {
        this.version0 = version0;
    }

    public Integer getVersion1() {
        return version1;
    }

    public void setVersion1(Integer version1) {
        this.version1 = version1;
    }

    public Integer getOtaName() {
        return otaName;
    }

    public void setOtaName(Integer otaName) {
        this.otaName = otaName;
    }

    @Override
    public String toString() {
        return "HatchOtaUpdateReply{" +
                        "version0=" + version0 +
                        ", version1=" + version1 +
                        ", otaName=" + otaName +
                        '}';
    }
}
