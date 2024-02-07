package com.boilingwater.cabinet.l.domain.receive;

/**
 * 报警。
 *
 * @author Benana
 * @since 2024-01-30
 */
public class AlarmsReceive extends ReceiveDataField {

    /**
     * 00（灭火器报警单仓）
     * 01（灭火器报警单仓正常）
     * 02（烟雾报警总机）
     * 03（烟雾报警总计正常）
     * 04（温度报警单仓）
     * 05（温度报警单仓正常）
     * 06（温度报警总仓）
     * 07（温度报警总仓正常）
     * 0A（交流电断电）
     * 0B（交流电断电恢复正常）
     * 0C（涉水报警）
     * 0D（涉水报警解除）
     * 0E（某仓电池充不进去电）
     */
    private String alarmsType;

    public String getAlarmsType() {
        return alarmsType;
    }

    public void setAlarmsType(String alarmsType) {
        this.alarmsType = alarmsType;
    }

    @Override
    public String toString() {
        return "AlarmsReceive{" +
                "alarmsType=" + alarmsType +
                '}';
    }
}
