package com.mycorp.testasset.api.users;

import com.mycorp.testasset.api.models.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserServices {

    @GET("products")
    Call<ArrayList<UserResponse>> getUsers();

}
