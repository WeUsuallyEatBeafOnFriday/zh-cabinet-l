package com.boilingwater.cabinet.l.domain.reply;

/**
 * 设备注册
 *
 * @author Benana
 * @since 2024-01-30
 */
public class CabinetRegisterReply extends ReplyDateField {

    /**
     * 仓数量
     */
    private Integer hatchQuantity;

    /**
     * 柜号（明文）
     */
    private String cabinetCode;

    /**
     * 音量大小
     */
    private Integer volumeLevel;

    /**
     * 功率
     */
    private Integer power;

    /**
     * 品牌识别码（ASCII码）
     */
    private String brandCode;

    /**
     * 手机号（明文）
     */
    private String phone;

    public Integer getHatchQuantity() {
        return hatchQuantity;
    }

    public void setHatchQuantity(Integer hatchQuantity) {
        this.hatchQuantity = hatchQuantity;
    }

    public String getCabinetCode() {
        return cabinetCode;
    }

    public void setCabinetCode(String cabinetCode) {
        this.cabinetCode = cabinetCode;
    }

    public Integer getVolumeLevel() {
        return volumeLevel;
    }

    public void setVolumeLevel(Integer volumeLevel) {
        this.volumeLevel = volumeLevel;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CabinetRegisterReply{" +
                "hatchQuantity=" + hatchQuantity +
                ", cabinetCode='" + cabinetCode + '\'' +
                ", volumeLevel=" + volumeLevel +
                ", power=" + power +
                ", brandCode='" + brandCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
