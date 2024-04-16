package com.openicu.ltzf.test;

import com.alibaba.fastjson.JSON;
import com.openicu.ltzf.payments.nativepay.INativePayApi;
import com.openicu.ltzf.payments.nativepay.model.PrepayResponse;
import com.openicu.ltzf.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/15
 */
@Slf4j
public class ApiTest {
    public static void main(String[] args) {

        long timestamp = System.currentTimeMillis() / 1000;
        System.out.println(timestamp);

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", "1674036351");
        dataMap.put("out_trade_no", "LTZF2022113023096");
        dataMap.put("total_fee", "0.01");
        dataMap.put("body", "Image形象店-深圳腾大-QQ公仔");
        dataMap.put("timestamp", String.valueOf(timestamp));
        dataMap.put("notify_url", "https://gaga.plus");

        System.out.println(SignUtils.createSign(dataMap, "ef2263f5ed2c6dc2115d1a361668751d"));

    }

    @Test
    public void test_retrofit2() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        INativePayApi nativePayApi = new Retrofit.Builder()
                .baseUrl("https://api.ltzf.cn/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(INativePayApi.class);

        long timestamp = System.currentTimeMillis() / 1000;
        System.out.println(timestamp);


        Map<String,String> dataMap = new HashMap<>();
        dataMap.put("mch_id", "1674036351");
        dataMap.put("out_trade_no", "xfg240413002");
        dataMap.put("total_fee", "0.01");
        dataMap.put("body", "QQ公仔");
        dataMap.put("timestamp", String.valueOf(timestamp));
        dataMap.put("notify_url", "https://gaga.plus");

        Call<PrepayResponse> call = nativePayApi.prepay(
                dataMap.get("mch_id"),
                dataMap.get("out_trade_no"),
                dataMap.get("total_fee"),
                dataMap.get("body"),
                dataMap.get("timestamp"),
                dataMap.get("notify_url"),
                SignUtils.createSign(dataMap, "ef2263f5ed2c6dc2115d1a361668751d")
        );

        Response<PrepayResponse> response = call.execute();
        Object object = response.body();

        System.out.println(JSON.toJSONString(object));

    }

}
