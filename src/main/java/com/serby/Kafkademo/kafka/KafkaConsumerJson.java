package com.serby.Kafkademo.kafka;

import com.serby.Kafkademo.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerJson {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerJson.class);

    //consume method subscribes to serbyTopic
    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "myGroup")
    public void consume(User user) {
        LOGGER.info(String.format("mesajul json consumat este %s", user.toString()));
    }
}
