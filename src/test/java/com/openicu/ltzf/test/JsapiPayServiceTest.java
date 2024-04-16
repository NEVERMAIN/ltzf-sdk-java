package com.openicu.ltzf.test;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.factory.defaults.DefaultPayFactory;
import com.openicu.ltzf.payments.jsapi.JsapiPayService;
import com.openicu.ltzf.payments.jsapi.model.PrepayRequest;
import com.openicu.ltzf.payments.jsapi.model.PrepayResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public class JsapiPayServiceTest {

    private JsapiPayService jsapiPayService;

    @Before
    public void init() {

        Configuration configuration = new Configuration(
                "1106772", "1674036351", "ef2263f5ed2c6dc2115d1a361668751d"
        );

        DefaultPayFactory factory = new DefaultPayFactory(configuration);
        this.jsapiPayService = factory.jsapiPayService();
    }

    @Test
    public void test_prepay() throws IOException {

        PrepayRequest request = new PrepayRequest();
        request.setMchId("1674036351");
        request.setOutTradeNo(RandomStringUtils.randomNumeric(8));
        request.setTotalFee("0.01");
        request.setOpenid("o6OsG6fPEeZFba6gqH9xsR9jrgnk");
        request.setBody("QQ公仔");
        request.setNotifyUrl("https://gaga.plus/");

        PrepayResponse response = jsapiPayService.prepay(request);

        System.out.println("请求参数: "+request);
        System.out.println("返回结果: "+response);

    }
}
