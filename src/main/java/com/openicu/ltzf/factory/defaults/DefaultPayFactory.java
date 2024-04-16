package com.openicu.ltzf.factory.defaults;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.factory.PayFactory;
import com.openicu.ltzf.payments.app.AppPayService;
import com.openicu.ltzf.payments.app.IAppPayApi;
import com.openicu.ltzf.payments.h5.H5PayService;
import com.openicu.ltzf.payments.h5.IH5PayApi;
import com.openicu.ltzf.payments.jsapi.IJsapiPayApi;
import com.openicu.ltzf.payments.jsapi.JsapiPayService;
import com.openicu.ltzf.payments.jumph5.IJumpH5PayApi;
import com.openicu.ltzf.payments.jumph5.JumpH5PayService;
import com.openicu.ltzf.payments.nativepay.INativePayApi;
import com.openicu.ltzf.payments.nativepay.NativePayService;
import com.openicu.ltzf.payments.openid.IOpenIdApi;
import com.openicu.ltzf.payments.openid.OpenIdService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/15
 */
public class DefaultPayFactory implements PayFactory {

    private final Configuration configuration;

    private final OkHttpClient okHttpClient;

    public DefaultPayFactory(Configuration configuration) {
        this.configuration = configuration;
        // 1. 日志配置
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(configuration.getLevel());

        // 2. 开启 OkHttpClient 客户端
        this.okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(configuration.getConnectTimeout(), TimeUnit.SECONDS)
                .writeTimeout(configuration.getWriteTimeout(), TimeUnit.SECONDS)
                .readTimeout(configuration.getReadTimeout(), TimeUnit.SECONDS)
                .build();

    }

    @Override
    public NativePayService nativePayService() {

        // 1. 构建 API
        INativePayApi nativePayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(INativePayApi.class);

        // 2.创建 native 支付服务
        return new NativePayService(nativePayApi, configuration);
    }

    @Override
    public H5PayService h5PayService() {

        // 1.构建 API
        IH5PayApi h5PayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IH5PayApi.class);
        // 2.创建 h5 支付服务
        return new H5PayService(h5PayApi, configuration);
    }

    @Override
    public JsapiPayService jsapiPayService() {

        // 1.构建 API
        IJsapiPayApi jsapiPayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IJsapiPayApi.class);
        // 2.创建 Jsapi 支付服务
        return new JsapiPayService(jsapiPayApi, configuration);
    }

    @Override
    public OpenIdService openIdService() {

        // 构建 API
        IOpenIdApi openIdApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IOpenIdApi.class);

        // 2. 创建 openId 服务
        return new OpenIdService(openIdApi, configuration);
    }

    @Override
    public AppPayService appPayService() {
        // 构建 API
        IAppPayApi appPayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(IAppPayApi.class);

        // 2. 创建 app 服务
        return new AppPayService(appPayApi, configuration);
    }

    @Override
    public JumpH5PayService jumpH5PayService() {
        // 1.构建 API
        IJumpH5PayApi jumpH5PayApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(IJumpH5PayApi.class);

        // 2.创建 jump_h5 支付服务
        return new JumpH5PayService(jumpH5PayApi,configuration);
    }
}
