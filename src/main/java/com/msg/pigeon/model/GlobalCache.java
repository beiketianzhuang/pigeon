package com.msg.pigeon.model;

import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class GlobalCache {

    public static ConcurrentMap<String, Set<WebSocketSession>> userSessionMap;

    public static Map<String, Set<WebSocketSession>> getUserSessionMap() {
        return userSessionMap;
    }


    public static void clear() {
        userSessionMap.clear();
    }
}
