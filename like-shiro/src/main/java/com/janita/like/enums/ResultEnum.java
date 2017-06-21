package com.janita.like.enums;

/**
 * Created by Janita on 2017-05-22 12:55
 * 封装返回结果
 */
public enum ResultEnum {

    UNKNOWN_ERROR("-1","未知错误"),

    SUCCESS("0", "成功"),

    RESOURCE_NOT_EXIST("3", "资源不存在"),

    DATA_NOT_FOUND("4", "参数有空"),

    ORIGIN_DATE_EMPTY("5","原始数据为空"),

    STUDENT_INFO_EMPTY("6", "学生信息为空"),

    TEACHER_INFO_EMPTY("7", "教师信息为空"),

    CLAZZ_INFO_EMPTY("8", "班级信息为空"),

    SCHOOL_INFO_EMPTY("9", "学校信息为空"),

    PROGRESS_INFO_EMPTY("10", "历程信息为空"),

    EMPTY_USERNAME_PASSWORD("11", "用户名或密码为空"),

    USER_DATA_NOT_SYNCHRONIZED("12", "用户数据还没有与睿智同步，登录失败" ),

    LOGIN_RUI_ZHI_FAILED("13", "调用睿智登录接口失败" ),

    HEADER_TOKEN_NAME_EMPTY("14", "请求头的token或者username为空" ),

    WRONG_TOKEN("15", "请求头中的token空或者验证不一致" ),

    WRONG_GROUP_NAME("16", "默认组不能被编辑"),

    REPEAT_GROUP_NAME("17", "该组名已存在"),

    WRONG_KEY("18", "错误的key"),

    WRONG_SECRET("19", "错误的secret"),

    ACCESS_WRONG("20","权限不够"),

    EXPORT_EXCEL_FAIL("21", "导出excel出现异常"),

    PARSE_EXCEL_FAIL("22", "解析excel出现异常"),

    EXCEL_ALREADY_PARSED("23", "该excel已解析过");

    private String resultCode;

    private String reason;

    ResultEnum(String resultCode, String reason) {
        this.resultCode = resultCode;
        this.reason = reason;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getReason() {
        return reason;
    }
}
