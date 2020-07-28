package com.kyriexu.config;

import com.kyriexu.exception.GlobalException;
import com.kyriexu.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author KyrieXu
 * @since 2020/7/28 9:58
 **/
@Component
public class JwtInterceptor implements HandlerInterceptor {
    private String[] whiteList = new String[]{"/login", "/swagger-resources/**", "/v2/**", "/swagger-ui.html/**", "/resources/webjars/**"};

    public static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    private AntPathMatcher matcher = new AntPathMatcher();

    private JwtUtils jwtUtils;

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        logger.info(uri);
        // 不拦截登陆请求
        for (String s : whiteList) {
            if (matcher.match(s, uri))
                return true;
        }
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token))
            throw new GlobalException("token不能为空");

        Claims claim = jwtUtils.getTokenClaim(token);
        if (claim == null || jwtUtils.isExpired(claim.getExpiration()))
            throw new GlobalException("校验失败，token过期");

        String authority = (String) claim.get("authorities");

        if (!StringUtils.hasText(authority) || !authority.equals("login_user"))
            throw new GlobalException("token验证失败，请登陆");

        return true;
    }
}
