package com.janita.url.result;

/**
 * Created by Janita on 2017/6/19 0019-下午 8:24
 * 该类是：
 */
public class ResultFactory {

    public static Result toSuccess() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        return result;
    }

    public static Result toSuccess(Object data){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setDate(data);
        return result;
    }

    public static Result toError(String msg) {
        Result result = new Result();
        result.setCode(-1);
        result.setMsg(msg);
        return result;
    }

}
