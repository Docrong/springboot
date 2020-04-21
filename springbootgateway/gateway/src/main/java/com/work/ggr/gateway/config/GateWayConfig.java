package com.work.ggr.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : gr
 * @date : 2020/3/30 15:26
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        id类似于数据库主键
/*
        routes
                .route("routeClient01", predicateSpec -> predicateSpec.path("/name/**").uri("http://localhost:8086"))
                .route("routeClient02", predicateSpec -> predicateSpec.path("/age/**").uri("http://localhost:8087"))
                .build();
*/
/*
*通过微服务名实现动态路由,uri的协议为lb,表示启动gateWay的负载均衡
*/
        routes
                .route("route3", predicateSpec -> predicateSpec.path("/name/**").uri("lb://eurekaclient"))
                .route("route4", predicateSpec -> predicateSpec.path("/age/**").uri("lb://eurekaclient2"))
                .build();
        return routes.build();
    }
}
