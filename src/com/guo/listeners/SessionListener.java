package com.guo.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author guosx
 * @date 2021/2/27
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    int count = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("count",count);
    }
}
