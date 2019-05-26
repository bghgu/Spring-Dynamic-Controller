package com.example.demo.library.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ServletWrappingController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ds on 2019-05-26 오후 3:09.
 */

public class CustomController extends ServletWrappingController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomController.class);

    public CustomController() {
        LOG.info("CustomController constructor");
        setServletClass(CustomServlet.class);
        setServletName("custom");
        setSupportedMethods((String[]) null); // Allow all
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        LOG.info("CustomController handleRequest");
        try {
            // We don't care about the other features of the base class, just want to
            // handle the request
            return super.handleRequestInternal(request, response);
        }
        finally {
            // @see com.netflix.zuul.context.ContextLifecycleFilter.doFilter
            RequestContext.getCurrentContext().unset();
        }
    }
}