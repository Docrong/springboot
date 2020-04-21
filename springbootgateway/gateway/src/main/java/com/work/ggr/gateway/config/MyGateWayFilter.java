package com.work.ggr.gateway.config;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author : gr
 * @date : 2020/4/21 9:44
 * 自定义全局过滤器
 */
@Component
@Logger
public class MyGateWayFilter implements GlobalFilter, Ordered {


    /**
     * 访问路径里面带上参数'uname',没有就返回状态吗403
     * @param exchange 服务器servlet交换
     * @param chain 妆台链
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("enter MyGateWayFilter:" + new Date());
        String uName = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uName == null) {
            System.out.println("******用户名为null,非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.valueOf(403));

            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * filter排序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
