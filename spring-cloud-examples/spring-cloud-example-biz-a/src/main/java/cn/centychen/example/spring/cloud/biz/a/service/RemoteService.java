package cn.centychen.example.spring.cloud.biz.a.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Cent.Chen
 * @Description Feign Client接口定义
 * @date 2019/8/2 10:45 AM
 */
@FeignClient(name = "spring-cloud-example-biz-b")
public interface RemoteService {

    /**
     * 调用服务B的hello方法
     *
     * @return
     */
    @GetMapping("/hello")
    String sayHello();
}
