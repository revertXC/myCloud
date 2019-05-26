package com.revert.ribbonConsumer.common.config;

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
