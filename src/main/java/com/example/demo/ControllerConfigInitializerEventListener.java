package com.example.demo;

import com.example.demo.library.HelloServlet;
import com.example.demo.model.Path;
import com.example.demo.model.RoutingConfigVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

/**
 * Created by ds on 2019-05-22 오후 10:03.
 */

@Slf4j
@Component
public class ControllerConfigInitializerEventListener {

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HelloServlet());
        log.info("register hello servlet");
        registrationBean.addUrlMappings("/Hello");
        return registrationBean;
    }

//    @EventListener
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        RequestMappingHandlerMapping requestMappingHandlerMapping;
//        log.info("ControllerConfigInitializerEventListener");
//        ApplicationContext applicationContext = event.getApplicationContext();
//
//        RoutingConfigVO routingConfigVO = null;
//
//        try {
//            routingConfigVO = applicationContext.getBean("routingConfigVO", RoutingConfigVO.class);
//        } catch (BeansException e) {
//            log.warn("Routing Config 설정이 없습니다.");
//            return;
//        }
//
//        if (routingConfigVO.getPaths() == null) {
//            log.warn("Routing 설정이 없습니다.");
//        }
//
//        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) ((GenericApplicationContext) applicationContext).getBeanFactory();
//
//        List<Path> pathList = routingConfigVO.getPaths();
//
//        for (Path path : pathList) {
//            log.info(path.toString());
//
//            // SqlSessionFactory 등록
//            AbstractBeanDefinition sqlSessionFactoryBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(SqlSessionFactoryBean.class)
//                    .addPropertyReference("dataSource", repositoryName + "DataSource")
//                    .addPropertyValue("mapperLocations", mapperLocations)
//                    .addPropertyValue("configLocation", configLocation)
//                    .getBeanDefinition();
//
//            beanFactory.registerBeanDefinition(repositoryName + "SqlSessionFactory", sqlSessionFactoryBeanDefinition);
//        }
//    }

}