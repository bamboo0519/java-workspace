package top.ibamboo.user.C.beans;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by C0907 on 2017/8/28.
 */
public class JedisCacheManager extends AbstractCacheManager {
    RedisTemplate template;

    public static String sessionName = "session";

    public JedisCacheManager(RedisTemplate template){
        this.template = template;
    }
    @Override
    protected Cache createCache(String name) throws CacheException {
//        return new JedisShiroCache<>(name, template); TODO
        return null;
    }
}
