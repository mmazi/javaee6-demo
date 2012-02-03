package com.housing.javaee6demo.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Enumeration;

/**
 * @author Matija Mazi <br/>
 * @created 2.2.12 13:30
 */
public class HelloWorldServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("HelloWorldServlet.doGet");
        ServletOutputStream out = resp.getOutputStream();
        out.println(MessageFormat.format("Hello, {0}!", req.getParameter("name")));

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            out.println(MessageFormat.format("{0} = {1}", paramName, req.getParameter(paramName)));
        }
    }
}
