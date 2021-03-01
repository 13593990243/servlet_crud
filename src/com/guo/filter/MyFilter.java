package com.guo.filter;

import com.guo.constants.Constants;
import com.guo.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author guosx
 * @date 2021/2/26
 */
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.endsWith("/index.jsp") || uri.endsWith("/sys/login")){
        }else {
            HttpSession session = request.getSession();
            User uesr  =(User) session.getAttribute(Constants.SESSION_LOGIN);
            if (uesr==null){
                response.sendRedirect("/index.jsp");
                return;
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
