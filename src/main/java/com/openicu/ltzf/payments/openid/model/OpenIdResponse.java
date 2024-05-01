package com.openicu.ltzf.payments.openid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
@Data
public class OpenIdResponse {

    /**
     * 返回状态，枚举值：
     * 0：成功
     * 1：失败
     */
    private Integer code;
    /**
     * 授权链接，在微信里访问这个链接，访问后将自动跳转到您填写的回调地址，地址后面会增加openid和attach参数
     * (例如：https://www.ltzf.cn/?openid=XXXXXX&attach=自定义数据)
     */
    private String data;
    /**
     * 消息
     */
    private String msg;

    @JsonProperty("request_id")
    private String requestId;




}
