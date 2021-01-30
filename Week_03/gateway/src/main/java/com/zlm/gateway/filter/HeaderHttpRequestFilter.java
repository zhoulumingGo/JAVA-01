package com.zlm.gateway.filter;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by zlm on 2021/1/26 13:52
 * @author zlm
 */
public class HeaderHttpRequestFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest) {
        fullRequest.headers().set("mao","soul");
    }
}
