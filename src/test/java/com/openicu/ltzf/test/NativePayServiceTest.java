package com.openicu.ltzf.test;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.EnumValues;
import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.factory.defaults.DefaultPayFactory;
import com.openicu.ltzf.payments.nativepay.NativePayService;
import com.openicu.ltzf.payments.nativepay.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Slf4j
public class NativePayServiceTest {

    private NativePayService nativePayService;

    @Before
    public void init(){
        Configuration configuration = new Configuration(
                "1106772","1674036351","ef2263f5ed2c6dc2115d1a361668751d"
        );

        DefaultPayFactory factory = new DefaultPayFactory(configuration);
        this.nativePayService = factory.nativePayService();
    }

    @Test
    public void test_prepay() throws IOException {

        PrepayRequest prepayRequest = new PrepayRequest();
        prepayRequest.setMchId("1674036351");
        prepayRequest.setOutTradeNo(RandomStringUtils.randomNumeric(8));
        prepayRequest.setTotalFee("0.01");
        prepayRequest.setBody("QQ公仔");
        prepayRequest.setNotifyUrl("https://gaga.plus/");

        PrepayResponse prepayResponse = nativePayService.prepay(prepayRequest);

        System.out.println("请求参数: "+JSON.toJSONString(prepayRequest));
        System.out.println("返回结果: "+JSON.toJSONString(prepayResponse));
    }

    @Test
    public void test_queryOrder() throws IOException {
        QueryOrderByOutTradeNoRequest request = new QueryOrderByOutTradeNoRequest();
        request.setMchId("1674036351");
        request.setOutTradeNo("48868856");
        QueryOrderByOutTradeNoResponse response = nativePayService.queryOrderByOutTradeNo(request);

        System.out.println("请求参数: "+JSON.toJSONString(request));
        System.out.println("返回结果: "+JSON.toJSONString(response));
    }

    @Test
    public void test_refundOrder() throws IOException {
        RefundOrderRequest request = new RefundOrderRequest();
        request.setMcnId("1674036351");
        request.setOutTradeNo("48868856");
        request.setOutRefundNo(RandomStringUtils.randomNumeric(8));
        request.setRefundFee("0.01");
        request.setRefundDesc("Error");

        RefundOrderResponse response = nativePayService.refundOrder(request);

        System.out.println("请求参数: "+JSON.toJSONString(request));
        System.out.println("返回结果: "+JSON.toJSONString(response));
    }


    @Test
    public void test_queryRefundOrder() throws IOException {
        GetRefundOrderRequest request = new GetRefundOrderRequest();
        request.setMchId("1674036351");
        request.setOutRefundNo("84875822");

        GetRefundOrderResponse response = nativePayService.getRefundOrder(request);

        System.out.println("请求参数: "+JSON.toJSONString(request));
        System.out.println("返回结果: "+JSON.toJSONString(response));
    }

}
