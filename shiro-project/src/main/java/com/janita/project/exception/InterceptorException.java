package com.janita.project.exception;

import com.janita.project.enums.ResultEnum;

/**
 * Created by Janita on 2017/6/2 0002
 * 登录时的异常
 */
public class InterceptorException extends  RuntimeException{

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

    public InterceptorException(String resultCode, String reason) {
        super(reason);
        this.resultCode = resultCode ;
    }

    public InterceptorException(ResultEnum resultEnum) {
        this.reason = resultEnum.getReason();
        this.resultCode = resultEnum.getResultCode();
    }
}
