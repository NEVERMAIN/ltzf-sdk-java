package com.openicu.ltzf.factory;

import com.openicu.ltzf.payments.app.AppPayService;
import com.openicu.ltzf.payments.h5.H5PayService;
import com.openicu.ltzf.payments.jsapi.JsapiPayService;
import com.openicu.ltzf.payments.jumph5.JumpH5PayService;
import com.openicu.ltzf.payments.nativepay.NativePayService;
import com.openicu.ltzf.payments.openid.OpenIdService;

/**
 * @description: 支付工厂
 * @author: 云奇迹
 * @date: 2024/4/15
 */
public interface PayFactory {

    /**
     * 获取Native支付服务接口
     * 该接口用于发起Native支付请求
     * @return NativePayService 返回 Native支付服务的实例
     */
    NativePayService nativePayService();

    /**
     * 获取H5支付服务接口
     * 该接口用于发起H5支付请求
     * @return H5PayService 返回H5支付服务的实例
     */
    H5PayService h5PayService();

    /**
     * 获取 公众号 支付服务接口
     * 该接口用于发起 公众号 支付请求
     * @return JsapiPayService 返回JSAPI支付服务的实例
     */
    JsapiPayService jsapiPayService();

    /**
     * 获取 OpenId 服务接口
     * 该接口用于获取 OpenId，以便于身份验证
     * @return OpenIdService 返回OpenId服务的实例
     */
    OpenIdService openIdService();

    /**
     * 获取 App 支付服务接口
     * 该接口用于发起 App 支付请求
     * @return AppPayService 返回App支付服务的实例
     */
    AppPayService appPayService();

    /**
     * 获取跳转 H5 支付服务接口
     * 该接口用于发起跳转 H5 支付请求
     * @return JumpH5PayService 返回跳转H5支付服务的实例
     */
    JumpH5PayService jumpH5PayService();



}
