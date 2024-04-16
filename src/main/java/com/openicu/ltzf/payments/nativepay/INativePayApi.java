package com.openicu.ltzf.payments.nativepay;

import com.openicu.ltzf.payments.nativepay.model.GetRefundOrderResponse;
import com.openicu.ltzf.payments.nativepay.model.PrepayResponse;
import com.openicu.ltzf.payments.nativepay.model.QueryOrderByOutTradeNoResponse;
import com.openicu.ltzf.payments.nativepay.model.RefundOrderResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @description: 扫码支付 API
 * @author: 云奇迹
 * @date: 2024/4/15
 */
public interface INativePayApi {

    /**
     * 扫码支付 API
     */
    @POST("api/wxpay/native")
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<PrepayResponse> prepay(@Field("mch_id") String mchId,
                                @Field("out_trade_no") String outTradeNo,
                                @Field("total_fee") String totalFee,
                                @Field("body") String body,
                                @Field("timestamp") String timestamp,
                                @Field("notify_url") String notifyUrl,
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
