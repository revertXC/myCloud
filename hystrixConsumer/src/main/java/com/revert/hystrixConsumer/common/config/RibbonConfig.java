package com.revert.hystrixConsumer.common.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * xiecong
 *
 */
@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }


}
