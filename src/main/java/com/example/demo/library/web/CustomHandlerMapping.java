//package com.example.demo.library.web;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.util.PathMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.servlet.HandlerExecutionChain;
//import org.springframework.web.servlet.handler.AbstractUrlHandlerMapping;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Collection;
//
///**
// * Created by ds on 2019-05-26 오후 3:09.
// */
//
//public class CustomHandlerMapping extends AbstractUrlHandlerMapping {
//
//    private static final Logger LOG = LoggerFactory.getLogger(CustomHandlerMapping.class);
//    private static RequestMappingHandlerMapping requestMappingHandlerMapping;
//
//    private final CustomController controller;
//
//    private ErrorController errorController;
//
//    private PathMatcher pathMatcher = new AntPathMatcher();
//
//    private volatile boolean dirty = true;
//
//    public CustomHandlerMapping(CustomRouteLocator routeLocator, CustomController controller) {
//        LOG.info("CustomHandlerMapping constructor");
//        this.routeLocator = routeLocator;
//        this.controller = controller;
//        setOrder(-200);
//    }
//
//    @Override
//    protected HandlerExecutionChain getCorsHandlerExecutionChain(
//            HttpServletRequest request, HandlerExecutionChain chain,
//            CorsConfiguration config) {
//        if (config == null) {
//            // Allow CORS requests to go to the backend
//            return chain;
//        }
//        return super.getCorsHandlerExecutionChain(request, chain, config);
//    }
//
//    public void setErrorController(ErrorController errorController) {
//        this.errorController = errorController;
//    }
//
//    public void setDirty(boolean dirty) {
//        this.dirty = dirty;
//        if (this.routeLocator instanceof CustomRefreshableRouteLocator) {
//            ((CustomRefreshableRouteLocator) this.routeLocator).refresh();
//        }
//    }
//
//    @Override
//    protected Object lookupHandler(String urlPath, HttpServletRequest request)
//            throws Exception {
//        if (this.errorController != null
//                && urlPath.equals(this.errorController.getErrorPath())) {
//            return null;
//        }
//        if (isIgnoredPath(urlPath, this.routeLocator.getIgnoredPaths())) {
//            return null;
//        }
//        CustomRequestContext ctx = CustomRequestContext.getCurrentContext();
//
//        if (ctx.containsKey("forward.to")) {
//            return null;
//        }
//        if (this.dirty) {
//            synchronized (this) {
//                if (this.dirty) {
//                    registerHandlers();
//                    this.dirty = false;
//                }
//            }
//        }
//        return super.lookupHandler(urlPath, request);
//    }
//
//    private boolean isIgnoredPath(String urlPath, Collection<String> ignored) {
//        if (ignored != null) {
//            for (String ignoredPath : ignored) {
//                if (this.pathMatcher.match(ignoredPath, urlPath)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private void registerHandlers() {
//        Collection<Route> routes = this.routeLocator.getRoutes();
//        if (routes.isEmpty()) {
//            this.logger.warn("No routes found from RouteLocator");
//        }
//        else {
//            for (Route route : routes) {
//                registerHandler(route.getFullPath(), this.zuul);
//            }
//        }
//    }
//}