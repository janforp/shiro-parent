package com.janita.project.handler;

import com.janita.project.exception.CustomException;
import com.janita.project.result.ResultDto;
import com.janita.project.result.ResultDtoFactory;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017-05-22 11:51
 * 自定义异常统一处理
 */
@RestControllerAdvice
@SuppressWarnings("unused")
public class ExceptionHandle {

    @ExceptionHandler(value = UnknownAccountException.class)
    public ResultDto handleDataNotFoundException(UnknownAccountException unknownAccountException) {
        return ResultDtoFactory.toError("-1", unknownAccountException.getMessage());
    }

    @ExceptionHandler(value = LockedAccountException.class)
    public ResultDto handleLoginException(LockedAccountException lockedAccountException) {
        return ResultDtoFactory.toError("-1", lockedAccountException.getMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResultDto handleNullPointerException(NullPointerException nullPointerException) {
        return ResultDtoFactory.toError("16", "空指针啦");
    }

    /**
     * 验证失败时抛出的异常
     * @param exception 验证失败异常
     * @return  页面dto
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultDto handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        //按需重新封装需要返回的错误信息
        List<String> invalidArguments = new ArrayList<>();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            invalidArguments.add(error.getDefaultMessage());
        }
        return ResultDtoFactory.toError("-1",invalidArguments.toString().replaceAll("\\[" , "").replaceAll("]", ""));
    }

    @ExceptionHandler(value = CustomException.class)
    public ResultDto handleCustomException(CustomException customException) {
        return ResultDtoFactory.toError(customException.getResultCode(), customException.getReason());
    }
}
