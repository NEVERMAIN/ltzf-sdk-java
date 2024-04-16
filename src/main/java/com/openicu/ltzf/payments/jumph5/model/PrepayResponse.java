package com.openicu.ltzf.payments.jumph5.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description:
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
     * 支付跳转链接，URL为拉起微信支付的中间页面，可通过访问该URL来拉起微信客户端，
     * 完成支付，URL的有效期为5分钟。
     */
    private String data;
    /**
     * 消息
     */
    private String msg;

    /**
     * 唯一请求ID，每次请求都会返回，定位问题时需要提供该次请求的request_id。
     */
    @JsonProperty("request_id")
    private String requestId;


}
