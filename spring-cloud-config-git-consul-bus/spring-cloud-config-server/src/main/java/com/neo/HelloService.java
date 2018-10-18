package com.neo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("test")
public interface HelloService {
    @RequestMapping(value = "/hello")
    String hello();
}

