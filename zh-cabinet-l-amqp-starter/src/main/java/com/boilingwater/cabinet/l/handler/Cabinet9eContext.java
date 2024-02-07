package com.boilingwater.cabinet.l.handler;

import com.boilingwater.cabinet.l.exception.Cabinet9eException;
import com.boilingwater.cabinet.l.utils.Cabinet9eUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 中辉L系列消息处理器上下文管理
 *
 * @author Benana
 * @since 2023-11-20
 */
@Component
@ConditionalOnBean(Cabinet9eHandler.class)
public class Cabinet9eContext {

    public static final Logger logger = LoggerFactory.getLogger(Cabinet9eContext.class);

    private static final Map<String, Cabinet9eHandler> CABINET_9E_HANDLER_MAP = new ConcurrentHashMap<>(4);

    /**
     * 构造器注入
     *
     * @param cabinet9eHandlerMap 消息处理器
     * @throws Cabinet9eException Cabinet9eException
     */
    @Autowired(required = false)
    public Cabinet9eContext(Map<String, Cabinet9eHandler> cabinet9eHandlerMap) {
        if (CollectionUtils.isEmpty(cabinet9eHandlerMap)) {
            logger.warn("没有可用的L系列电柜消息处理器");
            return;
        }
        cabinet9eHandlerMap.forEach((k, v) -> {
            String command = v.getCommand();
            Cabinet9eHandler put = Cabinet9eContext.CABINET_9E_HANDLER_MAP.put(command, v);
            if (Objects.nonNull(put)) {
                throw new Cabinet9eException("该类型指令的处理器已存在：" + command);
            }
            logger.info("中辉L系列处理器已载入，command={}，handler={}", command, this.getClass().getName());
        });
    }

    /**
     * 根据指令获取具体的处理器
     *
     * @param command 指令
     * @return 处理器
     * @throws Cabinet9eException Cabinet9eException
     */
    public static Cabinet9eHandler getHandler(String command) {
        if (Cabinet9eUtils.isBlank(command)) {
            throw new Cabinet9eException("未找到L系列指令对应处理器，指令为空");
        }
        Cabinet9eHandler cabinet9eHandler = CABINET_9E_HANDLER_MAP.get(command);
        if (Objects.isNull(cabinet9eHandler)) {
            throw new Cabinet9eException("未找到L系列指令对应处理器：" + command);
        }
        return cabinet9eHandler;
    }

}
