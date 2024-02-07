package com.boilingwater.cabinet.l.domain.receive;

import java.math.BigDecimal;

/**
 * 设备信息
 *
 * @author Benana
 * @since 2024-01-30
 */
public class HardwareInfoReceive extends ReceiveDataField {

    /**
     * 硬件版本，，例如11，对应0B
     */
    private Integer hardwareVersion;

    /**
     * 软件版本，例如11，对应0B
     */
    private Integer softwareVersion;

    /**
     * ICCID，明文
     */
    private String iccid;

    /**
     * 仓门数，例如12 仓对应0C
     */
    private Integer hatchQuantity;

    /**
     * 功率，单位:W（不存在时为FF）
     */
    private BigDecimal power;

    /**
     * IP地址，例：88.88.88.88 即58 58 58 58
     */
    private String ipAddress;

    /**
     * 端口号，例：16900 即42 04
     */
    private Integer port;

    public Integer getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(Integer hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public Integer getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(Integer softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public Integer getHatchQuantity() {
        return hatchQuantity;
    }

    public void setHatchQuantity(Integer hatchQuantity) {
        this.hatchQuantity = hatchQuantity;
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "HardwareInfoReceive{" +
                "hardwareVersion=" + hardwareVersion +
                ", softwareVersion=" + softwareVersion +
                ", iccid='" + iccid + '\'' +
                ", hatchQuantity=" + hatchQuantity +
                ", power=" + power +
                ", ipAddress='" + ipAddress + '\'' +
                ", port=" + port +
                '}';
    }
}
