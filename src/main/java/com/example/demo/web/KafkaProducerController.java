package com.example.demo.web;

import com.example.demo.Constants;
import com.example.demo.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {

        Random random = new Random();
        String topicName = Constants.TOPIC_NAME;
        if (random.nextInt(2) == 1) {
            topicName = Constants.TOPIC_NAME2;
        }

        kafkaProducer.sendMessage(message, topicName);
        return ResponseEntity.ok("Message sent to kafka topic " + topicName);
    }
}
