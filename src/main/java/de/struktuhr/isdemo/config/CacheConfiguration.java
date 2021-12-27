package de.struktuhr.isdemo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.infinispan.spring.remote.provider.SpringRemoteCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@Configuration
public class CacheConfiguration {

    @Autowired
    SpringRemoteCacheManager springRemoteCacheManager;

    @Primary
    @Bean
    public CacheManager cacheManager() {
        return new WrappingRemoteCacheManager(springRemoteCacheManager);
    }

    @Bean
    public CacheManager localCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("persons");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(10)
                .maximumSize(500)
                .expireAfterWrite(Duration.ofSeconds(10))
                .recordStats());
        return cacheManager;
    }

}
