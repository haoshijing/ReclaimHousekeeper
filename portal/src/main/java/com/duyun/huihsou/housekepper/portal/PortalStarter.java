package com.duyun.huihsou.housekepper.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author
 */
@ImportResource({"classpath:app.xml"})
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class PortalStarter /*extends SpringBootServletInitializer */{

    public static void main(String[] args) {
        SpringApplication.run(PortalStarter.class, args);
    }
}