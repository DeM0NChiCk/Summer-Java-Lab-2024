package ru.itis.CMService;

import org.apache.kafka.clients.admin.NewTopic;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class CarShopServiceApplication {

    public static final String MSG_TOPIC = "message";

    @Bean
    public NewTopic msgTopic() {
        return new NewTopic(MSG_TOPIC, 1, (short) 1);
    }

    @Bean
    public CacheManager cacheManager(RedissonClient redissonClient) {
        JsonJacksonCodec codec = new JsonJacksonCodec();
        Map<String, CacheConfig> config = new HashMap<>();
        config.put("cache", new CacheConfig(24 * 60 * 1000, 12 * 60 * 1000));
        return new RedissonSpringCacheManager(redissonClient, config, codec);
    }


    public static void main(String[] args) {
        SpringApplication.run(CarShopServiceApplication.class, args);
    }

}
