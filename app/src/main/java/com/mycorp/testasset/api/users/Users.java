package com.mycorp.testasset.api.users;

import android.util.Log;

import com.mycorp.testasset.api.client.ClientUtil;

public class Users {
    private static final String BASE_URL = "https://fakestoreapi.com/";

    public UserServices service;

    public Users() {
        service = ClientUtil.client(UserServices.class, BASE_URL);
    }
}
