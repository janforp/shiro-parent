package com.janita.like.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Janita on 2017/6/21 0021-下午 4:00
 * 该类是：
 */
public class CreateStudentDto {

    @NotBlank(message = "名字不能空")
    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
