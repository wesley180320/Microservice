package com.mswesley.user.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class RabbiMQConfig {
//
//    @Value("${broker.queue.email.name}")
//    private String queue;
//
//    @Bean
//    public Queue queue(String queue) {
//        return  new Queue(queue, true);
//    }
//}
