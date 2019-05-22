package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ds on 2019-05-22 오후 9:48.
 */

@Setter
@Getter
@ToString
@Component
@ConfigurationProperties(value = "routing")
public class RoutingConfigVO {
    private List<Path> paths;
}