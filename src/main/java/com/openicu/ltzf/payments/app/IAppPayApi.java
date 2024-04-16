package com.openicu.ltzf.payments.app;

import com.openicu.ltzf.payments.app.model.*;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @description: APP支付API
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public interface IAppPayApi {

    @POST("api/wxpay/app")
    @Headers("content-type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    Call<PrepayResponse> prepay(
            @Field("app_id") String appId,
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("total_fee") String totalFee,
            @Field("body") String body,
            @Field("timestamp") String timestamp,
            @Field("notify_url") String notifyUrl,
            @Field("attach") String attach,
            @Field("time_expire") String timeExpire,
            @Field("developer_appid") String developerAppid,
            @Field("sign") String sign
    );

    /**
     * 查询订单API
     */
    @POST("api/wxpay/get_pay_order")
    @Headers("content-type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    Call<QueryOrderByOutTradeNoResponse> getPayOrder(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );


    @POST("api/wxpay/refund_order")
    @Headers("content-type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    Call<RefundOrderResponse> refundOrder(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("refund_fee") String refundFee,
            @Field("refund_desc") String refundDesc,
            @Field("notify_url") String notifyUrl,
            @Field("sign") String sign
    );

    @POST("api/wxpay/get_refund_order")
    @Headers("content-type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    Call<GetRefundOrderResponse> getRefundOrder(
            @Field("mch_id") String mchId,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );


}
