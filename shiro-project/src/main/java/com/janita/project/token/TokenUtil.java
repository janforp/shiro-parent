package com.janita.project.token;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private static final String SECRET = "123";
    private static final String USER_ID = "userId";
    private static final String USERNAME = "username";
    private static final String AUDIENCE = "audience";
    private static final String ISS = "iss";
    private static final String EXP = "exp";
    private static final String IAT = "iat";

    //token过期时间设置
    private static final Long tokenExpireTime = 3600000L;

    /**
     * 生成token的静态方法，
     * 传入用户的帐号和id
     * @param username  用户名
     * @param userId    userId
     * @param userRole 用户角色 1：学生，2：老师，3：管理员
     * @return token
     */
    public static String createToken(String username, String userId, Integer userRole){

        final String issuer = "";

        final long iat = System.currentTimeMillis();
        final long exp = iat + tokenExpireTime;

        final JWTSigner signer = new JWTSigner(SECRET);
        final HashMap<String, Object> claims = new HashMap<>();
        String audience = null;

        switch (userRole) {
        case 1:
            audience = "student";
            break;
        case 2:
            audience = "teacher";
            break;
        case 3:
            audience = "admin";
            break;
        case 4:
            audience = "school";
            break;
        }
        claims.put(USER_ID, userId);
        claims.put(ISS, issuer);
        claims.put(EXP, exp);
        claims.put(IAT, iat);
        claims.put(AUDIENCE, audience);
        claims.put(USERNAME,username);

        return signer.sign(claims);
    }


    /**
     * 解析Token，其中可以获取id参数
     */
    public static TokenDto parseToken(String token) throws SignatureException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, IOException {

        TokenDto tokenDto = new TokenDto();
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        Map<String, Object> claims ;
        claims = verifier.verify(token);
        tokenDto.setUserId(claims.get(USER_ID).toString());
        tokenDto.setAudience(claims.get(AUDIENCE).toString());
        tokenDto.setUsername(claims.get(USERNAME).toString());

        return tokenDto;
    }
}
