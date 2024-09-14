package com.gvt.apache.camel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.gvt.apache.camel")
public class ApplicationRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationRunner.class, args);
    }
}
