package com.openicu.ltzf.factory;

import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @description: 配置
 * @author: 云奇迹
 * @date: 2024/4/15
 */
@Getter
public class Configuration {

    @Setter
    private String apiHost = "https://api.ltzf.cn/";

    private final String appId;

    private final String merchantId;

    private final String partnerKey;


    public Configuration(String appId, String merchantId, String partnerKey) {
        this.appId = appId;
        this.merchantId = merchantId;
        this.partnerKey = partnerKey;
    }

    @Setter
    private OkHttpClient okHttpClient;
    @Setter
    private  HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.HEADERS;
    @Setter
    private long connectTimeout = 60;
    @Setter
    private long readTimeout = 60;
    @Setter
    private long writeTimeout = 60;

}
