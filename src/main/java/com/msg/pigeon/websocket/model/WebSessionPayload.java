package com.msg.pigeon.websocket.model;

import lombok.Data;

import java.util.List;

@Data
public class WebSessionPayload {

    private List<MessageType> messageTypes;
    private String message;
    private AlertPage alertPage;
    private MessagePage messagePage;
    private Integer userId;
    private Integer productId;

    @Data
    public static class AlertPage {
        private Integer pageNum;
        private Integer pageSize;
    }

    @Data
    public static class MessagePage {
        private Integer pageNum;
        private Integer pageSize;
    }
}
