package com.zlm.gateway.filter;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author zlm
 */
public interface HttpRequestFilter {

    void filter(FullHttpRequest fullRequest);

}
