package com.openicu.ltzf.payments.jsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrepayResponse {

    /**
     * 返回状态，枚举值：
     * 0：成功
     * 1：失败
     */
    private Integer code;
    /**
     * 返回数据
     */
    private Data data;

    private String msg;

    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        /**
         * 公众号 appid
         */
        private String appId;
        /**
         * 时间戳
         */
        private String timeStamp;
        /**
         * 随机字符串
         */
        private String nonceStr;
        /**
         * 订单详情扩展字符串
         */
        @JsonProperty("package")
        private String packageField;
        /**
         * 签名方式
         */
        private String signType;
        /**
         * 签名
         */
        private String paySign;

    }

}
