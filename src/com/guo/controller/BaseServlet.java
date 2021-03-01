package com.guo.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author guosx
 * @date 2021/2/26
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String[] split = uri.split("/");
        String methodName = split[split.length-1];
        Class clazz = this.getClass();
        try {
            Method declaredMethod = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
