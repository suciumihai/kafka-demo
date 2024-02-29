package com.serby.Kafkademo.controller;

import com.serby.Kafkademo.kafka.KafkaProducer;
import com.serby.Kafkademo.kafka.KafkaProducerJson;
import com.serby.Kafkademo.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageControllerJson {

    private KafkaProducerJson kafkaProducer;

    public MessageControllerJson(KafkaProducerJson kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json message sent to tpic");
    }
}
