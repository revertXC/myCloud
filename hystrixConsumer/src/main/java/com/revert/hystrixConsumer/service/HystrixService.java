package com.revert.hystrixConsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xiecong
 * @Date 2019/5/26 22:07
 * @Description TODO
 */
@Service
public class HystrixService {

    @Autowired
    private RestTemplate restTemplate;
    //实现的callback方法来实现短路保护
    @HystrixCommand(fallbackMethod = "callback")
    public String routineService(String id){
        System.out.println(id);
        String jsons = restTemplate.getForObject("http://Eureka-client/user/getUser2", String.class);
        return jsons;
    }
    //实现的callback方法来实现短路保护
    @HystrixCommand(fallbackMethod = "callback")
    public String routineService(Integer id){
        System.out.println(id);
        try{
            Thread.sleep(5000L);
        }catch (Exception e){
            e.printStackTrace();
        }
        String jsons = restTemplate.getForObject("http://eureka-provider/hi", String.class);
        return jsons;
    }

    public String callback(String id){
        String msg="出现错误id："+id;
        return msg;
    }

    public String callback(Integer id){
        String msg="出现错误id："+id;
        return msg;
    }

}
