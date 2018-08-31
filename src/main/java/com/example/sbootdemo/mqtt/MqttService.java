package com.example.sbootdemo.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by wuzh on 2018/8/31.
 * mqtt发布端服务类，可以暴露给调用者
 */
@Service
public class MqttService {
//    @Autowired
    MessageChannel mqttOutboundChannel;

    /**
     * 发布消息到指定主题上
     * @param payload 发送的消息内容
     * @param topic 主题名，由调用者定义
     */
    public void  pubMsgToTopic(String payload,String topic){
        if (StringUtils.isEmpty(topic)){
            throw  new IllegalArgumentException("topic can't be empty or null or blank");
        }
        mqttOutboundChannel.send(MessageBuilder.withPayload(payload).setHeader(MqttHeaders.TOPIC,topic).build());
    }
}
