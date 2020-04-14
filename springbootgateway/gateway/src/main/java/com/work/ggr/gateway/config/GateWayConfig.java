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
        routes
                .route("client01", predicateSpec -> predicateSpec.path("/name/**").uri("http://localhost:8086"))
                .route("client02", predicateSpec -> predicateSpec.path("/age/**").uri("http://localhost:8087"))
                .build();
        return routes.build();
    }
}
