package com.openicu.ltzf.payments.nativepay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @description: 扫码支付出参
 * @author: 云奇迹
 * @date: 2024/4/15
 */
@lombok.Data
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
    /**
     * 消息
     */
    private String msg;

    /**
     * 唯一请求ID，每次请求都会返回，定位问题时需要提供该次请求的request_id。
     */
    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    public static class Data {
        /**
         * 微信原生支付链接，此URL用于生成支付二维码，然后提供给用户扫码支付。
         */
        @JsonProperty("code_url")
        private String codeUrl;
        /**
         * 蓝兔支付生成的二维码链接地址
         */
        @JsonProperty("QRcode_url")
        private String QRcodeUrl;
    }


}
