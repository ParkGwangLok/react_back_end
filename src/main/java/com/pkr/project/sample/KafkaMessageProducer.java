package com.pkr.project.sample;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaMessageProducer {
    public static void main(String[] args) {
        // Kafka 설정
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Kafka Producer 생성
        Producer<String, String> producer = new KafkaProducer<>(props);

        try {
            for (int i = 1; i <= 10; i++) {
                String key = "key-" + i;
                String value = "message-" + i;
                producer.send(new ProducerRecord<>("test-topic", key, value));
                System.out.println("Sent: " + key + " -> " + value);
            }
        } finally {
            producer.close();
        }
    }
}