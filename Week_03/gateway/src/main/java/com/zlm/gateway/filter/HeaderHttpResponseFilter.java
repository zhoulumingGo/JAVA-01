package com.zlm.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * Created by zlm on 2021/1/26 13:57
 * @author zlm
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse fullHttpResponse) {
        fullHttpResponse.headers().set("res", "testfilter");
    }
}
