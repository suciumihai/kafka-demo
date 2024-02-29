package com.serby.Kafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    //consume method subscribes to serbyTopic
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info(String.format("mesajul consumat este %s", message));
    }
}
