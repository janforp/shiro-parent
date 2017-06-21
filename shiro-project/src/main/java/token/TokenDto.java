package token;

import java.io.Serializable;

/**
 * Created by Janita on 2017-03-28 16:14
 * token 实体类
 */
public class TokenDto implements Serializable {

    private static final long serialVersionUID = 1L;
    //用户id
    private String userId;
    //用户角色(student，teacher，admin，school)
    private String audience;
    //
    private String issuer;
    //用户名
    private String username;
    //生成时间
    private long iat;
    //过期时间
    private long exp;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public long getIat() {
        return iat;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
