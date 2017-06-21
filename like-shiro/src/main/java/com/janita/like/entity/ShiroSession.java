package com.janita.like.entity;

/**
 * Created by com.janita.like.MybatisCodeGenerate on 2017-06-21
 */
public class ShiroSession implements java.io.Serializable {

    // Fields

    // 主键
    private String sessionId;
    // session的具体内容
    private String content;
    private Long createTime;

    // Constructors

    /**
     * default constructor
     */
    public ShiroSession() {
    }

    /**
     * full constructor
     */
    public ShiroSession(String sessionId, String content, Long createTime) {
        this.sessionId = sessionId;
        this.content = content;
        this.createTime = createTime;
    }

    // Property accessors

    /**
     * 主键
     */
    public String getSessionId() {
        return this.sessionId;
    }

    /**
     * 主键
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * session的具体内容
     */
    public String getContent() {
        return this.content;
    }

    /**
     * session的具体内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

}