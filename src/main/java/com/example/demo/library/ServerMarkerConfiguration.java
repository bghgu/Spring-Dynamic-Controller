package com.example.demo.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ds on 2019-05-26 오후 2:55.
 */

@Configuration
public class ServerMarkerConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(ServerMarkerConfiguration.class);

    @Bean
    public Marker ServerMarkerBean() {
        LOG.info("ServerMarkerBean : return new Marker()");
        return new Marker();
    }

    class Marker {

    }
}