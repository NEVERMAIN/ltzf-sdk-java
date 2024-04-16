package com.openicu.ltzf.payments.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description: 查询退款结果API 出餐
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Data
public class GetRefundOrderResponse {

    private String code;

    private Data data;

    private String msg;

    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    public static class Data {
        @JsonProperty("refund_status")
        private Integer refundStatus;
        @JsonProperty("mch_id")
        private String mchId;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("pay_no")
        private String payNo;
        @JsonProperty("order_no")
        private String orderNo;
        @JsonProperty("out_refund_no")
        private String outRefundNo;
        @JsonProperty("pay_refund_no")
        private String payRefundNo;
        @JsonProperty("refund_fee")
        private String refundFee;
        @JsonProperty("user_received_account")
        private String userReceivedAccount;
        @JsonProperty("success_time")
        private String successTime;

    }

}
