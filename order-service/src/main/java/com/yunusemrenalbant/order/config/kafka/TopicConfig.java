package com.yunusemrenalbant.order.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Value("${spring.kafka.template.default-topic}")
    private String topicName;

    @Bean
    public NewTopic myTopic() {
        return TopicBuilder.name(topicName).build();
    }
}
