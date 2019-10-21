package com.msg.pigeon.websocket.push;

import com.msg.pigeon.model.GlobalCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Set;


@Slf4j
@Component
public class MessageServer implements WebSocketServer<String, Void> {

    /**
     * 默认将内存中维护的websession都推送到客户端
     */
    @Override
    @Scheduled(fixedRate = 30 * 1000)
    public void pushAll() {
        Set<String> users = GlobalCache.getUserSessionMap().keySet();
        users.forEach(this::pushByT);
    }

    /**
     * 为每个用户推送
     *
     * @param userId
     */
    @Override
    public void pushByT(String userId) {
    }

    /**
     * 理论上一个用户能打开无数个websession，然后为每个session推送相关的内容
     *
     * @param session
     */
    @Override
    public void pushBySession(WebSocketSession session, Void vo) {

    }
}
