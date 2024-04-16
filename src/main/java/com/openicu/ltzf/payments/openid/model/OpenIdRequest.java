package com.openicu.ltzf.payments.openid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openicu.ltzf.utils.SignUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Data
public class OpenIdRequest {

    @JsonProperty("mch_id")
    private String mchId;
    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
    @JsonProperty("callback_url")
    private String callbackUrl;
    private String attach;


    public String creatSign(String partnerKey) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", getMchId());
        dataMap.put("timestamp", getTimestamp());
        dataMap.put("callback_url", getCallbackUrl());

        return SignUtils.createSign(dataMap, partnerKey);
    }


}
