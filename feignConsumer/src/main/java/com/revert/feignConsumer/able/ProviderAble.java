package com.revert.feignConsumer.able;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author xiecong
 * @Date 2019/6/20 16:08
 * @Description TODO
 */
@FeignClient(value = "eureka-provider")
public interface ProviderAble {

    @RequestMapping(value = "hi")
    String hi(String name);
}
