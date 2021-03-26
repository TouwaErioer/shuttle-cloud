package com.shuttle.major.utils;

import com.shuttle.major.config.exception.BusinessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;

@Component
public class JwtUtils {

    private static String key;

    @Value("${jwt.key}")
    public void setKey(String jwtKey) {
        key = jwtKey;
    }

    /**
     * 获取UserId
     *
     * @param token Token
     * @return userId
     */
    public static long getUserId(String token) {
        return parseJWT(token).get("userId", Integer.class);
    }

    /**
     * 获取UserName
     *
     * @param token Token
     * @return userName
     */
    public static String getUserName(String token) {
        return parseJWT(token).get("name", String.class);
    }

    /**
     * 管理员
     *
     * @param token Token
     * @return admin
     */
    public static boolean is_admin(String token) {
        return parseJWT(token).get("admin", Boolean.class);
    }

    /**
     * 解析token
     *
     * @param token Token
     * @return token对象
     */
    public static Claims parseJWT(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                    .parseClaimsJws(token).getBody();
            return claims;
        } catch (ExpiredJwtException eje) {
            throw new BusinessException(0, "token过期");
        } catch (Exception e) {
            throw new BusinessException(0, "token解析异常");
        }
    }
}
