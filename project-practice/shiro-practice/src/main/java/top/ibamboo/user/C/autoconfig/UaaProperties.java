package top.ibamboo.user.C.autoconfig;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by C0907 on 2017/8/28.
 */
@ConfigurationProperties(
        prefix = "uaa",
        ignoreInvalidFields = true,
        ignoreUnknownFields = true
)
@Component
@Data
@Slf4j
public class UaaProperties {
    RedisConfig redis;

    @Data
    public static class RedisConfig {
        String host;
        Integer port;
    }
}
