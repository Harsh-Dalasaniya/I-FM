package com.example.indiasforestmatrix.Model;

import com.google.android.gms.common.api.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;

public class common_responce {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("messsage")
    @Expose
    private String messsage;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

}
