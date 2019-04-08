package com.demon.core.config;

import com.demon.core.utils.GlobalUtil;
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

    // 是否开启验证码
    private boolean captchaOpen = false;
    // 上传文件路径
    private String fileUploadPath;
    // 上传文件静态访问路径
    private String staticPathPattern = "/upload/**";
    // cookie记住登录信息时间，默认7天
    private Integer rememberMeTimeout = 7;
    // Session会话超时时间，默认30分钟
    private Integer globalSessionTimeout = 1800;
    // Session会话检测间隔时间，默认15分钟
    private Integer sessionValidationInterval = 900;

    /* xss防护设置 */
    // xss防护开关
    private boolean xssEnabled = true;

    // 拦截规则，可通过“,”隔开多个
    private String UrlPatterns = "/**";
    // 忽略规则，可通过“,”隔开多个
    private String Excludes = "/error" +
            ",/login/" +
            ",/login/enter" +
            ",/assets/**" +
            ",/layui/**";

    public String getFileUploadPath() {
        if(fileUploadPath == null) {
            return GlobalUtil.getProjectPath() + "/upload/";
        }
        return fileUploadPath;
    }

}
