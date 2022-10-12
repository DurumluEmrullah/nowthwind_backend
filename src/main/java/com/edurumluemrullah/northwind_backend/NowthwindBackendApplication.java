package com.edurumluemrullah.northwind_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class NowthwindBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NowthwindBackendApplication.class, args);
    }

}
