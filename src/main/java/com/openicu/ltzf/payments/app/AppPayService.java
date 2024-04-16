package com.openicu.ltzf.payments.app;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.payments.app.model.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public class AppPayService {

    private IAppPayApi appPayApi;

    private Configuration configuration;

    public AppPayService(IAppPayApi appPayApi, Configuration configuration) {
        this.appPayApi = appPayApi;
        this.configuration = configuration;
    }

    public PrepayResponse prepay(PrepayRequest request) throws IOException {

        // 1.发起请求 & 签名
        Call<PrepayResponse> call = appPayApi.prepay(
                request.getAppId(),
                request.getMchId(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getTimestamp(),
                request.getNotifyUrl(),
                request.getAttach(),
                request.getTimeExpire(),
                request.getDeveloperAppid(),
                request.crateSign(configuration.getPartnerKey())
        );

        // 2.获取数据
        Response<PrepayResponse> response = call.execute();
        // 3.返回结果
        return response.body();
    }

    public QueryOrderByOutTradeNoResponse queryOrderByOutTradeNo(QueryOrderByOutTradeNoRequest request) throws IOException {
        // 1.请求结果 & 签名
        Call<QueryOrderByOutTradeNoResponse> call = appPayApi.getPayOrder(
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
        // 1.请求结果 & 签名
        Call<RefundOrderResponse> call = appPayApi.refundOrder(
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
        Call<GetRefundOrderResponse> call = appPayApi.getRefundOrder(
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
