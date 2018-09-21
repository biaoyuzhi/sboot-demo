package com.example.sbootdemo.mqtt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

/**
 * Created by wuzh on 2018/8/31.
 * mqtt的配置类，定义了发布端和消费端的bean
 */
@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq.mqtt")
@Data
public class MqttConfig {
    private String serveruri;
    private String username;
    private String password;
    private String topic;

    @Bean
    public MqttPahoClientFactory mqttPahoClientFactory(){
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setServerURIs(serveruri);
        factory.setUserName(username);
        factory.setPassword(password);
        return factory;
    }
    //publisher
    @Bean
    public IntegrationFlow mqttOutFlow() {
        return IntegrationFlows.from(mqttOutboundChannel()).transform(payload->payload+" sent to MQTT")//transform()方法中将调用者发布的消息后面拼接了" sent to MQTT"内容
                .handle(mqttOutboundMessageHandler())
                .get();
    }
    @Bean
    public MessageChannel mqttOutboundChannel(){
        return new DirectChannel();
    }
    @Bean
    public MessageHandler mqttOutboundMessageHandler(){
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("siSamplePublisher",mqttPahoClientFactory());
        messageHandler.setAsync(true);
        return messageHandler;
    }

    //consumer
    @Bean
    public IntegrationFlow mqttInFlow(){
        return IntegrationFlows.from(mqttInbound())
                .handle(loggingHandler())
                .get();
    }
    @Bean
    public LoggingHandler loggingHandler(){
        LoggingHandler loggingHandler = new LoggingHandler("INFO");
        loggingHandler.setLoggerName("loggerHandler");
        return loggingHandler;
    }
    @Bean
    public MessageProducerSupport mqttInbound(){
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("siSampleConsumer", mqttPahoClientFactory(), topic);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        return adapter;
    }
}
