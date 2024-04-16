package com.openicu.ltzf.payments.jsapi;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.payments.jsapi.model.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @description: 公众号支付服务
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public class JsapiPayService {

    private IJsapiPayApi jsapiPayApi;

    private Configuration configuration;

    public JsapiPayService(IJsapiPayApi jsapiPayApi, Configuration configuration) {
        this.jsapiPayApi = jsapiPayApi;
        this.configuration = configuration;
    }

    /**
     * 处理预支付请求
     *
     * @param request 包含预支付所需全部信息的请求对象
     * @return 预支付响应对象，包含支付所需的预支付交易会话标识等信息
     * @throws IOException 如果执行HTTP请求时发生错误
     */
    public PrepayResponse prepay(PrepayRequest request) throws IOException {

        // 1. 请求参数 & 签名
        Call<PrepayResponse> call = jsapiPayApi.prepay(
                request.getMchId(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getOpenid(),
                request.getTimeStamp(),
                request.getNotifyUrl(),
                request.getReturnUrl(),
                request.getTimeExpire(),
                request.getDeveloperAppid(),
                request.createSign(configuration.getPartnerKey())
        );

        // 2. 获取服务器响应
        Response<PrepayResponse> response = call.execute();
        // 3. 处理并返回结果
        return response.body();
    }


    public QueryOrderByOutTradeNoResponse queryOrderByOutTradeNo(QueryOrderByOutTradeNoRequest request) throws IOException {

        // 1.请求参数 & 签名
        Call<QueryOrderByOutTradeNoResponse> call = jsapiPayApi.getPayOrder(
                request.getMchId(),
                request.getOutTradeNo(),
                request.getTimeStamp(),
                request.createSign(configuration.getPartnerKey())
        );

        // 2.获取数据
        Response<QueryOrderByOutTradeNoResponse> response = call.execute();
        // 3.返回结果
        return response.body();


    }

    public RefundOrderResponse refundOrder(RefundOrderRequest request) throws IOException {

        // 1.请求参数 & 签名
        Call<RefundOrderResponse> call = jsapiPayApi.refundOrder(
                request.getMcnId(),
                request.getOutTradeNo(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.getRefundFee(),
                request.getRefundDesc(),
                request.getNotifyUrl(),
                request.createSign(configuration.getPartnerKey())
        );

        // 2.获取数据
        Response<RefundOrderResponse> response = call.execute();

        // 3.返回结果
        return response.body();


    }

    public GetRefundOrderResponse getRefundOrder(GetRefundOrderRequest request) throws IOException {

        // 1.请求参数 & 签名
        Call<GetRefundOrderResponse> call = jsapiPayApi.getRefundOrder(
                request.getMchId(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.createSign(configuration.getPartnerKey())
        );
        // 2.获取数据
        Response<GetRefundOrderResponse> response = call.execute();
        // 3.返回结果
        return response.body();

    }


}
