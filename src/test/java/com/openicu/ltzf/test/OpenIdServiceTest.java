package com.openicu.ltzf.test;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.factory.defaults.DefaultPayFactory;
import com.openicu.ltzf.payments.h5.model.PrepayRequest;
import com.openicu.ltzf.payments.h5.model.PrepayResponse;
import com.openicu.ltzf.payments.openid.OpenIdService;
import com.openicu.ltzf.payments.openid.model.OpenIdRequest;
import com.openicu.ltzf.payments.openid.model.OpenIdResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public class OpenIdServiceTest {


    private OpenIdService openIdService;

    @Before
    public void init() {

        Configuration configuration = new Configuration(
                "1106772", "1674036351", "ef2263f5ed2c6dc2115d1a361668751d"
        );

        DefaultPayFactory factory = new DefaultPayFactory(configuration);
        this.openIdService = factory.openIdService();
    }

    @Test
    public void test_prepay() throws IOException {
        OpenIdRequest request = new OpenIdRequest();
        request.setMchId("1674036351");
        request.setCallbackUrl("https://gaga.plus/");
        OpenIdResponse response = openIdService.getOpenId(request);
        System.out.println("请求参数: "+request);
        System.out.println("返回结果: "+response);
    }
}
