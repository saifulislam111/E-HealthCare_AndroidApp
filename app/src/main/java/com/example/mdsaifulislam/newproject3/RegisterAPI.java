package com.example.mdsaifulislam.newproject3;

/**
 * Created by Md Saiful Islam on 7/23/2017.
 */

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;


public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/insert.php")
    public void insertUser(
            @Field("email") String email,
            @Field("age") String age,
            @Field("temp") String temp,
            @Field("hr") String hr,
            @Field("bp") String bp,
            @Field("syn") String syn,
     //       @Field("bp") String bp,
            Callback<Response> callback);
}