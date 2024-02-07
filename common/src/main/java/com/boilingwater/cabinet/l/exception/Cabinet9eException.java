package com.boilingwater.cabinet.l.exception;

/**
 * L系列电柜异常
 *
 * @author Benana
 * @since 2024-01-30
 */
public class Cabinet9eException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 错误明细，内部调试错误
     */
    private String detailMessage;

    /**
     * 空构造方法，避免反序列化问题
     */
    public Cabinet9eException() {
    }

    /**
     * 异常消息构造异常
     *
     * @param message 异常消息
     */
    public Cabinet9eException(String message) {
        this.message = message;
    }

    /**
     * 异常消息+异常码构造异常
     *
     * @param code    异常码
     * @param message 异常消息
     */
    public Cabinet9eException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    /**
     * 设置错误明细
     *
     * @param detailMessage 异常消息
     * @return 异常
     */
    public Cabinet9eException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 设置异常消息
     *
     * @param message 异常消息
     * @return 异常
     */
    public Cabinet9eException setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }
}
