package com.example.demo.library;

import com.example.demo.library.web.CustomController;
import com.example.demo.library.web.CustomServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ds on 2019-05-26 오후 3:06.
 */

@Configuration
@EnableConfigurationProperties({RouteProperties.class})
@ConditionalOnClass({CustomServlet.class})
@ConditionalOnBean(ServerMarkerConfiguration.Marker.class)
public class ServerAutoConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(ServerAutoConfiguration.class);

    //@Autowired
    protected RouteProperties routeProperties;

    public ServerAutoConfiguration() {
        LOG.info("ServerAutoConfiguration constructor");
    }

    @Bean
    public CustomController customController() {
        LOG.info("customController : return new CustomController()");
        return new CustomController();
    }

//    @Bean
//    public CustomHandlerMapping customHandlerMapping(RouteLocator routes) {
//        CustomHandlerMapping mapping = new CustomHandlerMapping(routes, customController());
//        mapping.setErrorController(this.errorController);
//        mapping.setCorsConfigurations(getCorsConfigurations());
//        return mapping;
//    }

//    @Bean
//    @ConditionalOnMissingBean(name = "zuulServlet")
//    @ConditionalOnProperty(name = "zuul.use-filter", havingValue = "false", matchIfMissing = true)
//    public ServletRegistrationBean zuulServlet() {
//        ServletRegistrationBean<CustomServlet> servlet = new ServletRegistrationBean<>(
//                new CustomServlet(), this.routeProperties.getServletPattern());
//        // The whole point of exposing this servlet is to provide a route that doesn't
//        // buffer requests.
//        servlet.addInitParameter("buffer-requests", "false");
//        return servlet;
//    }

}