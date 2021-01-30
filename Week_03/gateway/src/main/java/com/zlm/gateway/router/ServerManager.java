package com.zlm.gateway.router;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zlm on 2021/1/30 12:05
 * @author zlm
 */
public class ServerManager {
    public volatile static Map<String, Integer> serverMap = new TreeMap<>();

    static {
        serverMap.put("http://localhost:8801", 2);
        serverMap.put("http://localhost:8802", 3);
        serverMap.put("http://localhost:8803", 5);
    }
}
