package com.lance.blog.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for test
 *
 * @author Lance
 * @date 2018/1/19 15:49
 */
public class AccountServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("Hello AccountServlet");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String action = req.getParameter("action");

        if (null == username) {
            username = "guest";
            password = "123";
        }

        Subject subject = SecurityUtils.getSubject();
        if ("logout".equals(action)) {
            logger.info("Ready to logout");
            subject.logout();
            req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req, resp);
        } else {
            logger.info("Ready to login");
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        }


        if (subject.isPermitted("grade:write")) {
            req.getRequestDispatcher("/grade").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
