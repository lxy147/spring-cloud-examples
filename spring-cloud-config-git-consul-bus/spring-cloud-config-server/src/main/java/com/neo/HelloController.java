package com.neo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {

    @RequestMapping("/healths")
    public String home() {
        return "Hello World";
    }
    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private HelloService helloServicess;
    /**
     * 从所有服务中选择一个服务
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancer.choose("test").getUri().toString();
    }

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("test");
    }

    @RequestMapping(value = "/feign-hello", method = RequestMethod.GET)
    public String feignHello() {
        return helloServicess.hello();
    }




}
