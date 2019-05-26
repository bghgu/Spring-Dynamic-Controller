package com.example.demo.library.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by ds on 2019-05-26 오후 3:13.
 */

public class CustomServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CustomServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        LOG.info("CustomServlet init");
        super.init(config);
    }

    @Override
    public void service(javax.servlet.ServletRequest servletRequest, javax.servlet.ServletResponse servletResponse) throws ServletException, IOException {
        LOG.info("CustomServlet service");
        RequestContext context = RequestContext.getCurrentContext();
        context.setZuulEngineRan();
        RequestContext.getCurrentContext().unset();
    }
}