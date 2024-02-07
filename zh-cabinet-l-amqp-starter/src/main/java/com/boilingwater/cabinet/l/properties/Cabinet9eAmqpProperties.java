package com.boilingwater.cabinet.l.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * L系列电柜AMQP属性注入
 *
 * @author Benana
 * @since 2024-01-30
 */
@ConfigurationProperties(prefix = "cabinet.l.amqp")
public class Cabinet9eAmqpProperties {

    private String host;

    private Integer port;

    private String virtualHost;

    private String username;

    private String password;

    private String exchange;

    private String senderRoutingKey;

    private String receiverRoutingKey;

    private Boolean enableConsumer;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSenderRoutingKey() {
        return senderRoutingKey;
    }

    public void setSenderRoutingKey(String senderRoutingKey) {
        this.senderRoutingKey = senderRoutingKey;
    }

    public String getReceiverRoutingKey() {
        return receiverRoutingKey;
    }

    public void setReceiverRoutingKey(String receiverRoutingKey) {
        this.receiverRoutingKey = receiverRoutingKey;
    }

    public Boolean getEnableConsumer() {
        return enableConsumer;
    }

    public void setEnableConsumer(Boolean enableConsumer) {
        this.enableConsumer = enableConsumer;
    }

    @Override
    public String toString() {
        return "Cabinet9eAmqpProperties{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", virtualHost='" + virtualHost + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", exchange='" + exchange + '\'' +
                ", senderRoutingKey='" + senderRoutingKey + '\'' +
                ", receiverRoutingKey='" + receiverRoutingKey + '\'' +
                ", enableConsumer=" + enableConsumer +
                '}';
    }
}
