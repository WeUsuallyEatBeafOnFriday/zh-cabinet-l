package com.boilingwater.cabinet.l.config;

import com.boilingwater.cabinet.l.handler.CheckSuccessHandler;
import com.boilingwater.cabinet.l.properties.Cabinet9eAmqpProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Objects;

/**
 * L系列电柜AMQP自动装配
 *
 * @author Benana
 * @since 2024-01-30
 */
@Configuration
@EnableConfigurationProperties(Cabinet9eAmqpProperties.class)
@ComponentScan(basePackages = "com.boilingwater.cabinet.l")
public class Cabinet9eAmqpAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(Cabinet9eAmqpAutoConfiguration.class);

    private final Cabinet9eAmqpProperties cabinet9eAmqpProperties;

    @Autowired
    public Cabinet9eAmqpAutoConfiguration(Cabinet9eAmqpProperties cabinet9eAmqpProperties) {
        this.cabinet9eAmqpProperties = cabinet9eAmqpProperties;
    }

    /**
     * RabbitMQ连接工厂注入
     *
     * @return 连接工厂
     */
    @Bean
    public ConnectionFactory cabinet9eConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(this.cabinet9eAmqpProperties.getHost());
        connectionFactory.setPort(this.cabinet9eAmqpProperties.getPort());
        if (Objects.nonNull(this.cabinet9eAmqpProperties.getVirtualHost())) {
            connectionFactory.setVirtualHost(this.cabinet9eAmqpProperties.getVirtualHost());
        }
        connectionFactory.setUsername(this.cabinet9eAmqpProperties.getUsername());
        connectionFactory.setPassword(this.cabinet9eAmqpProperties.getPassword());
        return connectionFactory;
    }

    /**
     * L系列电柜RabbitTemplate
     *
     * @param cabinet9eConnectionFactory 连接工程
     * @return RabbitTemplate
     */
    @Bean
    public RabbitTemplate cabinet9eRabbitTemplate(ConnectionFactory cabinet9eConnectionFactory) {
        return new RabbitTemplate(cabinet9eConnectionFactory);
    }

    /**
     * 如果没有消息检测处理器
     *
     * @return 默认的消息检测处理器
     */
    @Bean
    @ConditionalOnMissingBean(CheckSuccessHandler.class)
    public CheckSuccessHandler checkSuccessHandler() {
        logger.error("没有找到合适的消息检测处理器，需要实现com.boilingwater.cabinet.l.handler.CheckSuccessHandler接口并注入到容器中");
        return new CheckSuccessHandler() {
            @Override
            public void preSet(Map<Object, Object> args, String correlationId) {
            }

            @Override
            public void doCheck(Map<Object, Object> args, String correlationId) {
            }

            @Override
            public void doSuccess(String correlationId) {
            }
        };
    }
}
