package com.boilingwater.cabinet.l.handler;

import java.util.Map;

/**
 * 消息检测处理器
 *
 * @author Benana
 * @since 2024-02-06
 */
public interface CheckSuccessHandler {

    /**
     * 唯一标识预设
     *
     * @param args          参数
     * @param correlationId 消息唯一标识
     */
    void preSet(Map<Object, Object> args, String correlationId);

    /**
     * 开始检测
     *
     * @param args          参数
     * @param correlationId 消息唯一标识
     */
    void doCheck(Map<Object, Object> args, String correlationId);

    /**
     * 执行指令发送成功逻辑
     *
     * @param correlationId 消息编号
     */
    void doSuccess(String correlationId);
}
