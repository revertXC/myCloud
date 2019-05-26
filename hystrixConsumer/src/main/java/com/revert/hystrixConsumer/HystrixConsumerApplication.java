package com.revert.hystrixConsumer;

import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revert.hystrixConsumer.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xiecong
 * @Date 2019/5/26 21:51
 * @Description TODO
 */
@SpringBootApplication
@EnableEurekaClient//服务注册
@EnableDiscoveryClient//服务发现
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class HystrixConsumerApplication {
    //// 管理界面用服务端口,Stream监控用Manager 端口http://it:4567/hystrix.stream
    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumerApplication.class, args);
    }


    @Autowired
    HystrixService hystrixService;


    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public String routine(@RequestParam String id){
        String json = "success";

        //测试异常 服务
//        json=hystrixService.routineService(id);

        //测试 超过返回时间
        json=hystrixService.routineService(new Integer(id));

        return json;
    }


}
