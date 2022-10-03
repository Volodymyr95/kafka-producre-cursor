package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic cursorTopic() {
        return TopicBuilder.name("cursor")
            .build();
    }

    @Bean
    public NewTopic cursor2() {
        return TopicBuilder.name("cursor2")
            .build();
    }
}
