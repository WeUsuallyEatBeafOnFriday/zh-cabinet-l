package com.boilingwater.cabinet.l.domain.receive;

/**
 * 仓控版本号
 *
 * @author Benana
 * @since 2024-01-30
 */
public class HatchOtaVersionReceive extends ReceiveDataField {

    /**
     * 命名规则: DATA[0] DATA[1]:0X01,0X02
     * 版本v1.2
     */
    private Integer version0;

    /**
     * 命名规则: DATA[0] DATA[1]:0X01,0X02
     * 版本v1.2
     */
    private Integer version1;

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

    @Override
    public String toString() {
        return "HatchOtaVersionReceive{" +
                "version0=" + version0 +
                ", version1=" + version1 +
                '}';
    }
}
