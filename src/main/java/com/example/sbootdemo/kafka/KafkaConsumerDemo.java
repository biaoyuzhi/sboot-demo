package com.example.sbootdemo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Kafka消费端类
 *
 * Created by wuzh on 2019/5/17.
 */
public class KafkaConsumerDemo {

    public void startKafkaConsumer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","192.168.92.60:9092");   //指令端该参数为--bootstrap.server，注意不带s，此处必须带s
        properties.put("group.id","test-consumer-group");           //消费端所属组
        properties.put("enable.auto.commit", "true");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("HelloKafka"));            //指定订阅的topic名称，可以写多个
        while (true){                                               //循环监听
            ConsumerRecords<String, String> records = consumer.poll(100);   //弹出超时时间
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("偏移量 = %d, 取得值 = %s", record.offset(), record.value());   //这个打印方式值得借鉴，但是它不带换行
                System.out.println();
            }
        }
    }

}
