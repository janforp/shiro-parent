package com.janita.like.exception;

import com.janita.like.enums.ResultEnum;

/**
 * Created by Janita on 2017/6/21 0021-上午 11:53
 * 该类是：
 */
public class CustomException extends RuntimeException {

    /**
     * 结果编码
     */
    private String resultCode;

    /**
     * 返回说明
     */
    private String reason;


    public String getResultCode() {
        return resultCode;
    }

    public String getReason() {
        return reason;
    }

    public CustomException(String resultCode, String reason) {
        super(reason);
        this.resultCode = resultCode ;
    }

    public CustomException(ResultEnum resultEnum) {
        this.reason = resultEnum.getReason();
        this.resultCode = resultEnum.getResultCode();
    }

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
