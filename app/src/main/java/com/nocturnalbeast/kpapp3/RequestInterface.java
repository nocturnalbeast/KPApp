package com.nocturnalbeast.kpapp3;

import com.nocturnalbeast.kpapp3.models.ServerRequest;
import com.nocturnalbeast.kpapp3.models.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("kp_upd_back/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
