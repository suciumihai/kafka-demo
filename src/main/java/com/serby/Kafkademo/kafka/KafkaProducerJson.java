package com.serby.Kafkademo.kafka;

import com.serby.Kafkademo.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerJson {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerJson.class);

    @Value("${spring.kafka.topic-json.name}")
    private String topicNameJson;

    private KafkaTemplate<String, User> kafkaTemplate;

    public KafkaProducerJson( KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {
        LOGGER.info(String.format("mesajul trimis de prudocuer e %s", data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicNameJson)
                .build();
        kafkaTemplate.send(message);
    }
}
