package com.boilingwater.cabinet.l.domain.reply;

/**
 * 下发换电
 *
 * @author Benana
 * @since 2024-01-30
 */
public class ReplaceBatteryReply extends ReplyDateField {

    /**
     * 回收仓，例如：1 号仓01,2 号仓02
     */
    private Integer recycleHatch;

    /**
     * 回收电池BT码
     */
    private String recycleBtCode;

    /**
     * 释放仓1 例如：1 号仓01,2 号仓02
     */
    private Integer releaseHatch;

    /**
     * 释放电池BT码
     */
    private String releaseBtCode;

    /**
     * 换电订单编号，例如：HDG202306031622257362（ASCII 码）
     */
    private String orderNumber;

    public Integer getRecycleHatch() {
        return recycleHatch;
    }

    public void setRecycleHatch(Integer recycleHatch) {
        this.recycleHatch = recycleHatch;
    }

    public String getRecycleBtCode() {
        return recycleBtCode;
    }

    public void setRecycleBtCode(String recycleBtCode) {
        this.recycleBtCode = recycleBtCode;
    }

    public Integer getReleaseHatch() {
        return releaseHatch;
    }

    public void setReleaseHatch(Integer releaseHatch) {
        this.releaseHatch = releaseHatch;
    }

    public String getReleaseBtCode() {
        return releaseBtCode;
    }

    public void setReleaseBtCode(String releaseBtCode) {
        this.releaseBtCode = releaseBtCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "ReplaceBatteryReply{" +
                "recycleHatch=" + recycleHatch +
                ", recycleBtCode='" + recycleBtCode + '\'' +
                ", releaseHatch=" + releaseHatch +
                ", releaseBtCode='" + releaseBtCode + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }
}
