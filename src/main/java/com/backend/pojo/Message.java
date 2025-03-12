package com.backend.pojo;

import lombok.Data;

@Data
public class Message {
    private Long id; // 消息ID
    private String sender; // 发送者（客户或客服）
    private String receiver; // 接收者（客服或客户）
    private String content; // 消息内容
}
