package com.openicu.ltzf.payments.jsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description: 订单退款出参
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Data
public class RefundOrderResponse {

    /**
     * 返回状态，枚举值：
     * 0：成功
     * 1：失败
     */
    private String code;
    /**
     * 返回数据
     */
    private Data data;
    /**
     * 消息
     */
    private String msg;
    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    public static class Data {
        /**
         * 商户号
         */
        @JsonProperty("mch_id")
        private String mchId;
        /**
         * 商户订单号
         */
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        /**
         * 商户退款单号
         */
        @JsonProperty("out_refund_no")
        private String outRefundNo;
        /**
         * 系统退款单号
         */
        @JsonProperty("order_no")
        private String orderNo;
        /**
         * 微信支付退款单号
         */
        @JsonProperty("pay_refund_no")
        private String payRefundNo;

    }


}
