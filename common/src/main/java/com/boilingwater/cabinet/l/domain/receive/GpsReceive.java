package com.boilingwater.cabinet.l.domain.receive;

import java.math.BigDecimal;

/**
 * 定位信息
 *
 * @author Benana
 * @since 2024-01-30
 */
public class GpsReceive extends ReceiveDataField {

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * GPS类型，00（GPS） 01（基站）
     */
    private Integer gpsType;

    /**
     * 速度
     */
    private BigDecimal speed;

    /**
     * 纬度，以度为单位的纬度值乘以10 的6 次方，精确到百万分之一度，如2.947616 对应015E2720
     */
    private BigDecimal latitude;

    /**
     * 经度，以度为单位的纬度值乘以10 的6 次方，精确到百万分之一度，如113.91602 对应06CA3874
     */
    private BigDecimal longitude;

    /**
     * 震动
     */
    private BigDecimal shake;

    /**
     * 序列号，序列号顺序值
     */
    private Integer serialNumber;

    /**
     * 高程正负数， 00(正数) 01(负数）
     */
    private Integer elevationPlusOrMinus;

    /**
     * 高程， 当前高程值
     */
    private BigDecimal elevation;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getGpsType() {
        return gpsType;
    }

    public void setGpsType(Integer gpsType) {
        this.gpsType = gpsType;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getShake() {
        return shake;
    }

    public void setShake(BigDecimal shake) {
        this.shake = shake;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getElevationPlusOrMinus() {
        return elevationPlusOrMinus;
    }

    public void setElevationPlusOrMinus(Integer elevationPlusOrMinus) {
        this.elevationPlusOrMinus = elevationPlusOrMinus;
    }

    public BigDecimal getElevation() {
        return elevation;
    }

    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    @Override
    public String toString() {
        return "GpsReceive{" +
                        "timestamp=" + timestamp +
                        ", gpsType=" + gpsType +
                        ", speed=" + speed +
                        ", latitude=" + latitude +
                        ", longitude=" + longitude +
                        ", shake=" + shake +
                        ", serialNumber=" + serialNumber +
                        ", elevationPlusOrMinus=" + elevationPlusOrMinus +
                        ", elevation=" + elevation +
                        '}';
    }
}
