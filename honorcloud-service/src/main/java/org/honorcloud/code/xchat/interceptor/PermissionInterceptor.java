package org.honorcloud.code.xchat.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.honorcloud.code.xchat.enums.CodeEnum;
import org.honorcloud.code.xchat.exception.ErrorCodeException;
import org.honorcloud.code.xchat.utils.CheckUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * 权限校验拦截器
 *
 * @author yanpanyi
 * @date 2019/4/5
 */
@Component
@Slf4j
public class PermissionInterceptor implements HandlerInterceptor {

    private final static String TOKEN = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ErrorCodeException {
        String token = request.getHeader(PermissionInterceptor.TOKEN);

        log.info("权限校验 token -> {}", token);

        if (CheckUtils.checkToken(token)) {
            return true;
        }

        log.info("没有权限");

        throw new ErrorCodeException(CodeEnum.INVALID_TOKEN);
    }
}
