package com.openicu.ltzf.payments.nativepay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openicu.ltzf.utils.SignUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 查询退款结果API 入参
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Data
public class GetRefundOrderRequest {

    @JsonProperty("mch_id")
    private String mchId;
    @JsonProperty("out_refund_no")
    private String outRefundNo;

    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

    private String sign;

    public String createSign(String partnerKey){
        Map<String,String> dataMap = new HashMap<>();
        dataMap.put("mch_id",getMchId());
        dataMap.put("out_refund_no",getOutRefundNo());
        dataMap.put("timestamp",getTimestamp());

        return SignUtils.createSign(dataMap,partnerKey);
    }
}
