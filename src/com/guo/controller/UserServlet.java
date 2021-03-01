package com.guo.controller;

import com.guo.entity.User;
import com.guo.service.UserService;
import com.guo.uilts.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author guosx
 * @date 2021/2/25
 */
@WebServlet("/sys/user/*")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();

//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String uri = request.getRequestURI();
//        if (uri.endsWith("list")) {
//            list(request, response);
//        } else if (uri.endsWith("add")) {
//            add(request, response);
//
//        } else if (uri.endsWith("deleteById")) {
//            deleteById(request, response);
//        }
//    }


    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> usersList = userService.listAll();
        request.setAttribute("usersList", usersList);
        request.getRequestDispatcher("/userlist.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        user.setUsername(username);
        user.setPassword(Md5Util.md5(password));
        user.setSex(Integer.valueOf(sex));
        userService.addUser(user);
        request.getRequestDispatcher("/sys/user/list").forward(request,response);
    }

    protected void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userService.deleteById(Integer.valueOf(id));
        request.getRequestDispatcher("/sys/user/list").forward(request,response);
    }

    protected void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = userService.findById(Integer.valueOf(id));
        request.setAttribute("user",user);
        request.getRequestDispatcher("/toUpdate.jsp").forward(request,response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUsername(username);
        user.setPassword(Md5Util.md5(password));
        user.setSex(Integer.valueOf(sex));
        userService.updateUser(user);
        request.getRequestDispatcher("/sys/user/list").forward(request,response);
    }


}
