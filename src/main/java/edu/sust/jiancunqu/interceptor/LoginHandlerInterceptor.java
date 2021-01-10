package edu.sust.jiancunqu.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功之后应该有用户的session

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }
        for (Cookie cookie : cookies) {
            if ("loginUser".equals(cookie.getName())) {
                return true;
            }
        }
        response.sendRedirect(request.getContextPath() + "/");
        return false;
    }
}
