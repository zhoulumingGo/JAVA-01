package com.zlm.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * Created by zlm on 2021/1/26 13:56
 */
public interface HttpResponseFilter {
    void filter(FullHttpResponse fullHttpResponse);
}
