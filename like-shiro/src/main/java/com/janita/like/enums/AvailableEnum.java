package com.janita.like.enums;

/**
 * Created by Janita on 2017/6/21 0021-下午 3:57
 * 该类是：
 */
public enum  AvailableEnum {

    available(1),

    not_available(0);

    public final Integer val;

    AvailableEnum(Integer val){
        this.val = val;
    }
}
