package com.openicu.ltzf.payments.openid;


import com.openicu.ltzf.payments.openid.model.OpenIdRequest;
import com.openicu.ltzf.payments.openid.model.OpenIdResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @description: 获取微信 Openid API
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public interface IOpenIdApi {

    @POST("api/wxpay/get_wechat_openid")
    @Headers("content-type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    Call<OpenIdResponse> getOpenid(
            @Field("mch_id") String mchId,
            @Field("timestamp") String timestamp,
            @Field("callback_url") String callbackUrl,
            @Field("attach") String attach,
            @Field("sign") String sign
    );

}
