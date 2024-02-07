package com.boilingwater.cabinet.l.domain.reply;

/**
 * IP修改设置
 *
 * @author Benana
 * @since 2024-01-30
 */
public class IpConfigReply extends ReplyDateField {

    private String ipAddress;

    private Integer port;

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
        return "IpConfigReply{" + "ipAddress='" + ipAddress + '\'' + ", port=" + port + '}';
    }
}
