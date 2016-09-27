package com.mygaienko.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.jms.Queue;

/**
 * Created by enda1n on 27.09.2016.
 */
@Configuration
@ImportResource("classpath*:si-config/hello-si-config.xml")
public class HelloActiveMQConfig {

    public static final String HELLO_QUEUE = "hello.queue";

    @Bean
    public Queue helloJMSQueue() {
        return new ActiveMQQueue(HELLO_QUEUE);
    }
}
