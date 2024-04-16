package com.openicu.ltzf.payments.h5;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.payments.h5.model.PrepayRequest;
import com.openicu.ltzf.payments.h5.model.PrepayResponse;
import com.openicu.ltzf.payments.nativepay.model.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @description: h5 支付服务
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public class H5PayService {


    private IH5PayApi h5PayApi;

    private Configuration configuration;

    public H5PayService(IH5PayApi h5PayApi, Configuration configuration) {
        this.h5PayApi = h5PayApi;
        this.configuration = configuration;
    }

    public PrepayResponse prepay(PrepayRequest request) throws IOException {

        // 1.请求结果 & 签名
        Call<PrepayResponse> call = h5PayApi.prepay(
                request.getMchId(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getTimeStamp(),
                request.getNotifyUrl(),
                request.getReturnUrl(),
                request.getAttach(),
                request.getTimeExpire(),
                request.getDeveloperAppid(),
                request.createSign(configuration.getPartnerKey())
        );

        // 2.获取数据
        Response<PrepayResponse> response = call.execute();
        // 3.返回结果
        return response.body();
    }

    public QueryOrderByOutTradeNoResponse queryOrderByOutTradeNo(QueryOrderByOutTradeNoRequest request) throws IOException {
        // 1.请求参数 & 签名
        Call<QueryOrderByOutTradeNoResponse> call = h5PayApi.getPayOrder(
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
        Call<RefundOrderResponse> call = h5PayApi.refundOrder(
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

        // 1.请求结果 & 签名
        Call<GetRefundOrderResponse> call = h5PayApi.getRefundOrder(
                request.getMchId(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.createSign(configuration.getPartnerKey())
        );
        // 2.获取数据
        Response<GetRefundOrderResponse> response = call.execute();
        // 3. 返回结果
        return response.body();
    }
}
