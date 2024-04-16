package com.openicu.ltzf.payments.jumph5;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.payments.jumph5.model.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public class JumpH5PayService {

    private IJumpH5PayApi jumpH5PayApi;

    private Configuration configuration;

    public JumpH5PayService(IJumpH5PayApi jumpH5PayApi, Configuration configuration) {
        this.jumpH5PayApi = jumpH5PayApi;
        this.configuration = configuration;
    }


    public PrepayResponse prepay(PrepayRequest request) throws IOException {

        // 1.请求参数 & 签名
        Call<PrepayResponse> call = jumpH5PayApi.prepay(
                request.getMchId(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getTimeStamp(),
                request.getNotifyUrl(),
                request.getQuitUrl(),
                request.getReturnUrl(),
                request.getAttach(),
                request.getTimeExpire(),
                request.getDeveloperAppid(),
                request.createSign(configuration.getPartnerKey())
        );
        // 2.获取数据
        Response<PrepayResponse> response = call.execute();
        // 3. 返回结果
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
        Call<QueryOrderByOutTradeNoResponse> call = jumpH5PayApi.getPayOrder(
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
        Call<RefundOrderResponse> call = jumpH5PayApi.refundOrder(
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
        // 1.请求结果 & 签名
        Call<GetRefundOrderResponse> call = jumpH5PayApi.getRefundOrder(
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
