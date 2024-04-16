package com.openicu.ltzf.payments.openid;

import com.openicu.ltzf.factory.Configuration;
import com.openicu.ltzf.payments.openid.model.OpenIdRequest;
import com.openicu.ltzf.payments.openid.model.OpenIdResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/4/16
 */
public class OpenIdService {

    private IOpenIdApi openIdApi;

    private Configuration configuration;

    public OpenIdService(IOpenIdApi openIdApi,Configuration configuration) {
        this.openIdApi = openIdApi;
        this.configuration =  configuration;
    }

    public OpenIdResponse getOpenId(OpenIdRequest request) throws IOException {
        // 1.请求参数
        Call<OpenIdResponse> call = openIdApi.getOpenid(
                request.getMchId(),
                request.getTimestamp(),
                request.getCallbackUrl(),
                request.getAttach(),
                request.creatSign(configuration.getPartnerKey())
        );
        // 2.获取数据
        Response<OpenIdResponse> response = call.execute();
        // 3.返回结果
        return response.body();
    }

}
