package com.example.dubboproducter.service;

import com.ohp.service.ProducterService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@DubboService
public class ProducterServiceImpl implements ProducterService {
    @Value(
            value = "${server.port}"
    )
    private Integer port;
    @Override
    public String sayHello(){
        return "端口是"+port;
    }
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    @Override
    public Long getTime(long time) {
        if (atomicBoolean.get()){
            atomicBoolean.set(false);
            return System.currentTimeMillis()-time;
        }else {
            atomicBoolean.set(true);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return System.currentTimeMillis()-time;
        }
    }
}
