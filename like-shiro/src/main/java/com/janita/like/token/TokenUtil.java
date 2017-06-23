package com.janita.like.token;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.janita.like.util.CommonUtils;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class TokenUtil {

    private static final String SALT = "GGKSI8HFLSAF";
    private static final String LOGIN_NAME = "loginName";
    private static final String TOKEN_TIME = "tokenTime";


    /**
     * 生成token的静态方法，
     * 传入用户的帐号和id
     * @param loginName  用户名
     * @return token
     */
    public static String createToken(String loginName, Long tokenTime){

        final JWTSigner signer = new JWTSigner(SALT);
        final HashMap<String, Object> claims = new HashMap<>();
        claims.put(LOGIN_NAME, loginName);
        claims.put(TOKEN_TIME, tokenTime);
        claims.put(LOGIN_NAME,loginName);
        return signer.sign(claims);
    }


    /**
     * 解析Token，其中可以获取id参数
     */
    public static TokenDto parseToken(String token) throws SignatureException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, IOException {

        TokenDto tokenDto = new TokenDto();
        final JWTVerifier verifier = new JWTVerifier(SALT);
        Map<String, Object> claims ;
        claims = verifier.verify(token);
        tokenDto.setLoginName(claims.get(LOGIN_NAME).toString());
        tokenDto.setTokenTime(Long.parseLong( claims.get(TOKEN_TIME).toString()));

        return tokenDto;
    }

    /**
     * 判断该 token 是否过期
     * @param tokenDto
     * @param expireTime
     * @return
     */
    public static boolean isExpire(TokenDto tokenDto, long expireTime) {
        Long tokenTime = tokenDto.getTokenTime();
        long expire = tokenTime + expireTime;
        if (CommonUtils.getNowTime() > expire) {
            return true;
        }
        return false;
    }
}
