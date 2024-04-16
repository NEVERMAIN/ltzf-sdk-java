package com.openicu.ltzf.payments.nativepay;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.payments.nativepay.model.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @description: 扫码支付 API
 * @author: 云奇迹
 * @date: 2024/4/15
 */
public class NativePayService {

    private INativePayApi nativePayApi;

    private Configuration configuration;

    public NativePayService(INativePayApi nativePayApi, Configuration configuration) {
        this.nativePayApi = nativePayApi;
        this.configuration = configuration;
    }

    /**
     * 支付接口
     *
     * @param prepayRequest  请求入参
     * @return  微信二维码信息
     * @throws IOException 异常
     */
    public PrepayResponse prepay(PrepayRequest prepayRequest) throws IOException {

        // 1.请求结果 & 签名
        Call<PrepayResponse> call = nativePayApi.prepay(
                prepayRequest.getMchId(),
                prepayRequest.getOutTradeNo(),
                prepayRequest.getTotalFee(),
                prepayRequest.getBody(),
                prepayRequest.getTimeStamp(),
                prepayRequest.getNotifyUrl(),
                prepayRequest.createSign(configuration.getPartnerKey())
        );

        // 2.获取数据
        Response<PrepayResponse> response = call.execute();
        // 3.返回结果
        return response.body();
    }

    /**
     * 查询订单
     *
     * @param request 请求参数
     * @return 订单信息
     */
    public QueryOrderByOutTradeNoResponse queryOrderByOutTradeNo(QueryOrderByOutTradeNoRequest request) throws IOException {

        // 1.请求结果 & 签名
        Call<QueryOrderByOutTradeNoResponse> call = nativePayApi.getPayOrder(
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

    /**
     * 申请退单
     *
     * @param request 申请退单请求参数
     * @return 申请退单信息
     */
    public RefundOrderResponse refundOrder(RefundOrderRequest request) throws IOException {

        // 1.请求结果 & 签名
        Call<RefundOrderResponse> call = nativePayApi.refundOrder(
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

    /**
     * 查询退单情况
     * @param request 查询退单请求参数
     * @return  退单信息
     * @throws IOException
     */
    public GetRefundOrderResponse getRefundOrder(GetRefundOrderRequest request) throws IOException {
        Call<GetRefundOrderResponse> call = nativePayApi.getRefundOrder(
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
