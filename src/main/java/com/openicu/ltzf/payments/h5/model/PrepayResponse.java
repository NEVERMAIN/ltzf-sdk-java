package com.openicu.ltzf.payments.h5.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description: H5支付API 返回结果
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
    /**
     * 微信原生支付跳转链接，URL为拉起微信支付收银台的中间页面，可通过访问该URL来拉起微信客户端，完成支付，URL的有效期为5分钟。
     */
    private String data;

    private String msg;

    @JsonProperty("request_id")
    private String requestId;
}
