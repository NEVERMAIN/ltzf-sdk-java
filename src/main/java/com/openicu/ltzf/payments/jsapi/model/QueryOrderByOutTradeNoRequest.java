package com.openicu.ltzf.payments.jsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openicu.ltzf.utils.SignUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 查询订单入参
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Data
public class QueryOrderByOutTradeNoRequest {

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
     * 当前时间戳
     */
    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
    /**
     * 签名
     */
    private String sign;

    public String getTimeStamp() {
        return this.timestamp;
    }

    public String createSign(String partnerKey) {

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", getMchId());
        dataMap.put("out_trade_no", getOutTradeNo());
        dataMap.put("timestamp", getTimeStamp());

        return SignUtils.createSign(dataMap, partnerKey);
    }


}
