package com.revert.ribbonConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * xiecong
 */
@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;


    /**
     * 项目说明
     * @return
     */
    @GetMapping({"/"})
    public String index(){
        return "hello world,this is ribbon-consumer";
    }

    /**
     * 远程服务ribbon rest
     * @return
     */
    @GetMapping( "/index")
    public Object ribbonIndex() {
        String str= restTemplate.getForEntity("http://eureka-provider/index", String.class).getBody();
        System.out.println("<<<<<<<<<<<<<ribbon返回值:"+str+">>>>>>>>>>>>>>>>>");
        return str;
    }

}
