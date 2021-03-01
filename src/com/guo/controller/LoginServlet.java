package com.guo.controller;

import com.guo.constants.Constants;
import com.guo.entity.User;
import com.guo.service.UserService;
import com.guo.uilts.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author guosx
 * @date 2021/2/25
 */
@WebServlet("/sys/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        user.setUsername(username);
        user.setPassword(Md5Util.md5(password));
        ArrayList<User> listUser = userService.findByNameAndPs(user);
        //cookies一天免登陆
        Cookie[] cookies = request.getCookies();
        int index = 0;
        String name = null;
        if (cookies != null) {
            for (Cookie cs : cookies) {
                String key = cs.getName();
                if ("c_username".equals(key)) {
                    name = cs.getValue();
                    if (username==""){
                        index++;
                    }
                }
                if ("c_password".equals(key)) {
                    String password2 = cs.getValue();
                    if (password==""){
                        index++;
                    }
                }
            }
        }
        if (index == 2) {
//            ServletContext servletContext = getServletContext();
//            Object obj = servletContext.getAttribute(Constants.COUNT);
//            int count = 0;
//            if (obj == null) {
//                count = 1;
//            } else {
//                count = Integer.valueOf(obj.toString());
//            }
//            servletContext.setAttribute(Constants.COUNT, count);
//            request.setAttribute("count", count);
            request.setAttribute("username", name);
            request.getRequestDispatcher("/sys/user/list").forward(request, response);
            return;
        }
        if (listUser.size() != 0) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60 * 30);
            session.setAttribute(Constants.SESSION_LOGIN, listUser.get(0));
            if ("remember".equals(remember)){
                Cookie cookie  = new Cookie("c_username",username);
                Cookie cookie1  = new Cookie("c_password",Md5Util.md5(password));
                cookie.setPath("/");
                cookie1.setPath("/");
                cookie.setMaxAge(24*60*60);
                cookie1.setMaxAge(24*60*60);
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
//            //计数
//            ServletContext servletContext = getServletContext();
//            Object obj = servletContext.getAttribute(Constants.COUNT);
//            int count = 0;
//            if (obj == null) {
//                count = 1;
//            } else {
//                count = Integer.valueOf(obj.toString()) + 1;
//            }
//            servletContext.setAttribute(Constants.COUNT, count);
//            request.setAttribute("count", count);
            request.setAttribute("username",username);
            request.getRequestDispatcher("/sys/user/list").forward(request, response);
        } else {
            request.setAttribute("msg", "登录失败!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
