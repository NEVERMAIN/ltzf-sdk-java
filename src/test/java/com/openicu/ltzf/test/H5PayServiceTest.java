package com.openicu.ltzf.test;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.factory.defaults.DefaultPayFactory;
import com.openicu.ltzf.payments.h5.H5PayService;
import com.openicu.ltzf.payments.h5.model.PrepayRequest;
import com.openicu.ltzf.payments.h5.model.PrepayResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public class H5PayServiceTest {

    private H5PayService h5PayService;

    @Before
    public void init() {

        Configuration configuration = new Configuration(
                "1106772", "1674036351", "ef2263f5ed2c6dc2115d1a361668751d"
        );

        DefaultPayFactory factory = new DefaultPayFactory(configuration);
        this.h5PayService = factory.h5PayService();
    }

    @Test
    public void test_prepay() throws IOException {
        PrepayRequest prepayRequest = new PrepayRequest();
        prepayRequest.setMchId("1674036351");
        prepayRequest.setOutTradeNo(RandomStringUtils.randomNumeric(8));
        prepayRequest.setTotalFee("0.01");
        prepayRequest.setBody("QQ公仔");
        prepayRequest.setNotifyUrl("https://gaga.plus/");

        PrepayResponse response = h5PayService.prepay(prepayRequest);

        System.out.println("请求参数: "+prepayRequest);
        System.out.println("返回结果: "+response);
    }

}
