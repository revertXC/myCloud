package com.revert.feignConsumer;

import com.revert.feignConsumer.able.ProviderAble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiecong
 * @Date 2019/5/26 21:51
 * @Description TODO
 */
@SpringBootApplication
@EnableEurekaClient//服务注册
@EnableDiscoveryClient//服务发现
@EnableFeignClients
@RestController
public class FeignConsumerApplication {
    //// 管理界面用服务端口,Stream监控用Manager 端口http://it:4567/hystrix.stream
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

    @Autowired
    private ProviderAble providerAble;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return providerAble.hi( name );
    }

}
