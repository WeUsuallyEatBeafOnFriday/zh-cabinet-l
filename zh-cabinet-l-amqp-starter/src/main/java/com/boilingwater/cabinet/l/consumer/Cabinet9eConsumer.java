package com.boilingwater.cabinet.l.consumer;

import com.boilingwater.cabinet.l.handler.CheckSuccessHandler;
import com.boilingwater.cabinet.l.utils.Cabinet9eUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * 中辉L系列消息消费者
 *
 * @author Benana
 * @since 2024-02-06
 */
@ConditionalOnProperty(name = "cabinet.l.amqp.receiver-routing-key")
@Component
@RabbitListener(queues = "${cabinet.l.amqp.receiver-routing-key}")
public class Cabinet9eConsumer {

    private final CheckSuccessHandler checkSuccessHandler;

    @Autowired
    public Cabinet9eConsumer(CheckSuccessHandler checkSuccessHandler) {
        this.checkSuccessHandler = checkSuccessHandler;
    }

    /**
     * 中辉L系列消息消费者
     *
     * @param message       消息内容
     * @param correlationId 消息唯一标识
     */
    @RabbitHandler
    private void process(String message, @Header(value = AmqpHeaders.CORRELATION_ID, required = false) String correlationId) {
        if (!Cabinet9eUtils.isBlank(correlationId)) {
            this.checkSuccessHandler.doSuccess(correlationId);
            return;
        }
    }

}
