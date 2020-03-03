package com.example.logbackdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogbackDemoApplication {
    private static Logger logger = LoggerFactory.getLogger(LogbackDemoApplication.class);
    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(LogbackDemoApplication.class, args);
        for (int i=0;i<1000000;i++){
            Thread.sleep(5000);
            LogUtils.info(logger,"输出info："+i);
            LogUtils.error(logger,"输出error:"+i);
        }
    }
}
