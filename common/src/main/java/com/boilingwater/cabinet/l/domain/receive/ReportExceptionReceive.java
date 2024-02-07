package com.boilingwater.cabinet.l.domain.receive;

/**
 * 上报异常状态
 *
 * @author Benana
 * @since 2024-01-30
 */
public class ReportExceptionReceive extends ReceiveDataField {

    /**
     * 异常类型
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
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReportExceptionReceive{" +
                "type='" + type + '\'' +
                '}';
    }
}
