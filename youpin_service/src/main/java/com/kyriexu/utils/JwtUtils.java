package com.kyriexu.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author KyrieXu
 * @since 2020/7/28 9:23
 **/
@Component
@PropertySource("classpath:/jwt.properties")
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtUtils {
    private long expire;
    private String secret;

    public String createToken(String subject) {
        return Jwts.builder()
                // 设置这个token属于谁的
                .setSubject(subject)
                // 设置权限
                .claim("authorities", "login_user")
                .setIssuedAt(new Date())
                // 设置过期时间
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(expire)))
                // 设置签名signature,这个是至关重要的
                // 用secret加密
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    public Claims getTokenClaim(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isExpired(Date date){
        return date.before(new Date());
    }
}
