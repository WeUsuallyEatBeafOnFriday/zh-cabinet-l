package com.boilingwater.cabinet.l.domain.receive;

/**
 * 升级结果（电柜，仓控板）
 *
 * @author Benana
 * @since 2024-01-30
 */
public class OtaUpdateResultReceive extends ReceiveDataField {

    /**
     * 升级结果
     * 00（电柜升级成功）
     * 01（电柜升级失败）
     * 02（仓控板下发升级文件成功）
     * 03（仓控板下发升级文件失败）
     */
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "UpdateReceive{" +
                "result=" + result +
                '}';
    }
}
