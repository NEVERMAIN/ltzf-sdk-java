package com.openicu.ltzf.payments.jsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openicu.ltzf.utils.SignUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 订单退款入参
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Data
public class RefundOrderRequest {

    /**
     * 商户号
     */
    @JsonProperty("mcn_id")
    private String mcnId;
    /**
     * 商户订单号
     */
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    /**
     * 商户退款单号，只能是数字、大小写字母_-且在同一个商户号下唯一。
     */
    @JsonProperty("out_refund_no")
    private String outRefundNo;

    /**
     * 退款金额
     */
    @JsonProperty("refund_fee")
    private String refundFee;
    /**
     * 退款描述
     */
    @JsonProperty("refund_desc")
    private String refundDesc;
    /**
     * 退款通知地址
     */
    @JsonProperty("notify_url")
    private String notifyUrl;

    /**
     * 当前时间戳
     */
    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);


    public String createSign(String partnerKey) {

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", getMcnId());
        dataMap.put("out_trade_no", getOutTradeNo());
        dataMap.put("out_refund_no", getOutRefundNo());
        dataMap.put("refund_fee", getRefundFee());
        dataMap.put("timestamp", getTimestamp());

        return SignUtils.createSign(dataMap,partnerKey);
    }


}
