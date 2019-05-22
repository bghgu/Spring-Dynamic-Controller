package com.example.demo;

import com.example.demo.model.RoutingConfigVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2019-05-22 오후 9:49.
 */

@Slf4j
@RestController
public class DemoController {

    private final RoutingConfigVO routing;

    public DemoController(final RoutingConfigVO routing) {
        this.routing = routing;
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        return new ResponseEntity<>(routing, HttpStatus.OK);
    }
}