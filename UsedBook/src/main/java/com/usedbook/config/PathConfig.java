package com.usedbook.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 路径配置
 *
 * @author zhuliyou
 * @date 2021/04/22
 */
@Data
@Component
@ConfigurationProperties(prefix = "img-file-path")
public class PathConfig {
    private String winPath;
    private String linuxPath;

    public String getWinPath() {
        return winPath;
    }

    public void setWinPath(String winPath) {
        this.winPath = winPath;
    }

    public String getLinuxPath() {
        return linuxPath;
    }

    public void setLinuxPath(String linuxPath) {
        this.linuxPath = linuxPath;
    }
}