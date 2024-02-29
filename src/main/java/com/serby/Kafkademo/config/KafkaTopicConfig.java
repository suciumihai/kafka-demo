package com.serby.Kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicNameJson;

    @Bean
    public NewTopic serbyTopic(){
        return TopicBuilder.name(topicName).partitions(3).build();
    }

    @Bean
    public NewTopic serbyTopicJson(){
        return TopicBuilder.name(topicNameJson).partitions(3).build();
    }
}
