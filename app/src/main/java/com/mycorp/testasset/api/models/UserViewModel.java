package com.mycorp.testasset.api.models;

import android.app.Service;
import android.service.autofill.UserData;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.mycorp.testasset.api.Helpers;
import com.mycorp.testasset.api.client.ClientUtil;
import com.mycorp.testasset.api.users.UserServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {
    MutableLiveData<ArrayList<UserResponse>> postLiveData;

    public UserViewModel(){
        postLiveData = new MutableLiveData<>();

        init();
    }

    public MutableLiveData<ArrayList<UserResponse>> getPostLiveData(){

        return postLiveData;
    }

    private void init() {
        UserDatas();
    }

    private void UserDatas() {
        ClientUtil clientUtil = new ClientUtil();
        UserServices userServices = ClientUtil.client(UserServices.class, Helpers.URL);

        userServices.getUsers().enqueue(new Callback<ArrayList<UserResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UserResponse>> call, Response<ArrayList<UserResponse>> response) {
                postLiveData.setValue(response.body());

                String gs = new Gson().toJson(response.body());
                Log.d("gs", gs);
            }

            @Override
            public void onFailure(Call<ArrayList<UserResponse>> call, Throwable t) {

            }
        });
    }

}
