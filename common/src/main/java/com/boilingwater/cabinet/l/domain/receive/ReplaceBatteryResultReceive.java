package com.boilingwater.cabinet.l.domain.receive;

/**
 * 换电结果
 *
 * @author Benana
 * @since 2024-01-30
 */
public class ReplaceBatteryResultReceive extends ReceiveDataField {

    /**
     * 结果
     * 01：仓位不符异常（电池信息，仓电压，在位状态三者不符）
     * 02：仓位不符恢复正常
     * 03：锁状态异常
     * 04：锁状态恢复正常
     * 05：CAN 通信异常
     * 06：CAN 通信恢复正常
     * 07：充不进去电异常
     * 08：充不进去电恢复正常
     * 09：电池bt 码错误异常
     * 0A：电池bt 码错误恢复正常
     * 0B：旧电池故障异常
     * 0C：旧电池故障恢复正常
     * 0D：仓被占用异常
     * 0E：仓被占用恢复正常
     */
    private String result;

    /**
     * 换电订单编号
     * 例如：HDG202306031622257362（ASCII 码）
     */
    private String orderNumber;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "ReplaceBatteryResultReceive{" +
                "result=" + result +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }
}
