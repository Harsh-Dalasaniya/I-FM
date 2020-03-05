package com.example.indiasforestmatrix.Network;

import com.example.indiasforestmatrix.Model.common_responce;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Single;

public interface API {

    @FormUrlEncoded
    @POST("api_demo.php")
    Single<common_responce> ADD_STUDENT(@Field("tag")String Tag,
                                        @Field("std_name")String std_name,
                                        @Field("class_id")String class_id);

}
