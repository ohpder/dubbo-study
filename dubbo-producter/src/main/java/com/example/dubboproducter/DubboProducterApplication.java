package com.example.dubboproducter;

import com.ohp.service.ProducterService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDubbo
@RestController
public class DubboProducterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProducterApplication.class, args);
    }
    @Autowired
    private ProducterService producterService;
    @GetMapping("/")
    public String hello(){
        return producterService.sayHello();
    }
}
