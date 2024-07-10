package ru.itis.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class ProxyConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("car_shop_route",
                        route -> route.path("/car-shop-managment/**")
                                .and()
                                .method(HttpMethod.GET)
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://car-shop-service"))
                .route("car_manufacturer_route",
                        route -> route.path("/car-manufacturer-managment/**")
                                .and()
                                .method(HttpMethod.GET)
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://car-manufacturer-service"))
                .route("dealership_route",
                        route -> route.path("/dealership-managment/**")
                                .and()
                                .method(HttpMethod.GET)
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://dealership-service"))
                .build();
    }
}
