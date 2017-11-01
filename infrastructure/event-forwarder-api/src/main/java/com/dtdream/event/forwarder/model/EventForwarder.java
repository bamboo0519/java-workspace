package com.dtdream.event.forwarder.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bamboo on 2017/9/8.
 */
@Data
public class EventForwarder implements Serializable{
    private static final long serialVersionUID = -1010686491521110522L;

    Long id;

    String eventId;      // 事件ID
    String eventName;    // 事件名称

    String producer;      // 事件产生者 (Class toString)
    String subscriber;    // 事件订阅者 (Class toString)
    String consumer;      // 事件消费者 (Class toString)

    Date happenTime;     // 事件发生时间

    String description;  // 事件描述
    String data;         // 事件内容 (DBObject)

}
