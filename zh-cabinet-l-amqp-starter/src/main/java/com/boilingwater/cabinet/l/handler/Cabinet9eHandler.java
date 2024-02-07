package com.boilingwater.cabinet.l.handler;

/**
 * 中辉L系列消息处理器接口
 *
 * @author Benana
 * @since 2023-11-14
 */
public interface Cabinet9eHandler {

    /**
     * 执行处理
     *
     * @param message 消息原文
     */
    void doHandler(String message);

    /**
     * 获取指令
     *
     * @return 指令
     */
    String getCommand();
}
