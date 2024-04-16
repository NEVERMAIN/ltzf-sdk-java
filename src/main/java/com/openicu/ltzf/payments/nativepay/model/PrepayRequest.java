package com.openicu.ltzf.payments.nativepay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openicu.ltzf.utils.SignUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 扫码支付入参
 * @author: 云奇迹
 * @date: 2024/4/15
 */
@Data
public class PrepayRequest {
    /**
     * 商户号
     */
    @JsonProperty("mch_id")
    private String mchId;
    /**
     * 商户订单号，只能是数字、大小写字母_-且在同一个商户号下唯一。
     */
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    /**
     * 支付金额
     */
    @JsonProperty("total_fee")
    private String totalFee;
    /**
     * 商品描述
     */
    private String body;

    @JsonProperty("notify_url")
    /**
     * 支付通知地址，通知 URL 必须为直接可访问的 URL，不允许携带查询串，要求必须为 http 或 https 地址
     */
    private String notifyUrl;
    /**
     * 附加数据，在支付通知中原样返回，可作为自定义参数使用。
     */
    private String attach;
    /**
     * 订单失效时间，枚举值：
     * m：分钟
     * h：小时
     * 取值范围：1m～2h（接口请求后开始计算时间）
     */
    @JsonProperty("time_expire")
    private String timeExpire;

    /**
     * 当前时间戳
     */
    private String timestamp  = String.valueOf(System.currentTimeMillis() / 1000);

    public String getTimeStamp() {
        return this.timestamp;
    }

    public String createSign(String partnerKey) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", getMchId());
        dataMap.put("out_trade_no", getOutTradeNo());
        dataMap.put("total_fee", getTotalFee());
        dataMap.put("body", getBody());
        dataMap.put("timestamp", getTimeStamp());
        dataMap.put("notify_url", getNotifyUrl());

        return SignUtils.createSign(dataMap, partnerKey);
    }


}
