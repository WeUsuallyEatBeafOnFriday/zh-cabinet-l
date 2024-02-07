package com.boilingwater.cabinet.l.domain.receive;

/**
 * 应用端操作指令上报
 *
 * @author Benana
 * @since 2024-01-30
 */
public class OperationReportReceive extends ReceiveDataField {

    /**
     * 指令代码
     */
    private String command;

    /**
     * 指令内容
     */
    private String commandRawData;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommandRawData() {
        return commandRawData;
    }

    public void setCommandRawData(String commandRawData) {
        this.commandRawData = commandRawData;
    }

    @Override
    public String toString() {
        return "OperationReportReceive{" +
                "command='" + command + '\'' +
                ", commandRawData='" + commandRawData + '\'' +
                '}';
    }
}
