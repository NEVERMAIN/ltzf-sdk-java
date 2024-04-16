package com.openicu.ltzf.test;

import com.wechat.pay.java.core.RSAAutoCertificateConfig;

import com.wechat.pay.java.service.payments.nativepay.NativePayService;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayResponse;
import org.junit.Before;
import org.junit.Test;

/**
 * @description: 微信支付SDK使用
 * @author: 云奇迹
 * @date: 2024/4/15
 */
public class WeChatPayTest {

    private NativePayService nativePayService;

    @Before
    public void init(){
        RSAAutoCertificateConfig config = new RSAAutoCertificateConfig.Builder().merchantId("").build();

        NativePayService payService = new NativePayService.Builder().config(config).build();

    }

    @Test
    public void test_prepay(){
        PrepayRequest prepayRequest = new PrepayRequest();

        PrepayResponse prepay = nativePayService.prepay(prepayRequest);
    }



}
