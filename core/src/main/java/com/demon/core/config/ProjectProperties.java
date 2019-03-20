package com.demon.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目配置项
 * @author oneperfect
 * @date 2018/03/07
 */
@Data
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectProperties {


    // 拦截规则，可通过“,”隔开多个
    private String UrlPatterns = "/**";
    // 忽略规则，可通过“,”隔开多个
    private String Excludes = "/error" +
            ",/login/" +
            ",/login/enter" +
            ",/assets/**" +
            ",/layui/**";

}
