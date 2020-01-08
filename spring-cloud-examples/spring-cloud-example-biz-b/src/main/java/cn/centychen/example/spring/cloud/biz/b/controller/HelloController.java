package cn.centychen.example.spring.cloud.biz.b.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cent.Chen
 * @date 2019/8/2 10:16 AM
 * @Description
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    /**
     * 示例方法
     *
     * @return
     */
    @GetMapping
    public String sayHello() {
        return "Hello,This is Biz-B Service.";
    }
}
