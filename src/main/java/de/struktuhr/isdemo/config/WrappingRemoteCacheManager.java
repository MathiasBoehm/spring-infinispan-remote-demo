package de.struktuhr.isdemo.config;

import java.util.Collection;

import org.infinispan.spring.remote.provider.SpringRemoteCacheManager;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

public class WrappingRemoteCacheManager implements CacheManager {

    private SpringRemoteCacheManager springRemoteCacheManager;

    public WrappingRemoteCacheManager(SpringRemoteCacheManager springRemoteCacheManager) {
        this.springRemoteCacheManager = springRemoteCacheManager;
    }


    @Override
    public Cache getCache(String name) {
        return springRemoteCacheManager.getCache(name);
    }

    @Override
    public Collection<String> getCacheNames() {
        return springRemoteCacheManager.getCacheNames();
    }
}
