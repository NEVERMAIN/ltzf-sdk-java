package com.openicu.ltzf.payments.app.model;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Data
public class PrepayResponse {

    /**
     * 返回状态，枚举值：
     * 0：成功
     * 1：失败
     */
    private Integer code;

    private Data data;

    private String msg;

    @JsonProperty("request_id")
    private String requestId;


    @lombok.Data
    public static class Data{
        /**
         * 移动应用appid
         */
        private String appid;
        /**
         * 商户号
         */
        private String partnerid;
        /**
         * 预支付交易会话ID
         */
        private String prepayid;
        /**
         * 订单详情扩展字符串
         */
        @JsonProperty("package")
        private String package_field;
        /**
         * 随机字符串
         */
        private String noncestr;
        /**
         * 时间戳
         */
        private String timestamp;
        /**
         * 签名
         */
        private String sign;

    }
}
