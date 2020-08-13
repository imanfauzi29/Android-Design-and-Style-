package com.mycorp.testasset.normalmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;
import com.mycorp.testasset.R;
import com.mycorp.testasset.api.UserAdapter.UserAdapter;
import com.mycorp.testasset.api.models.UserResponse;
import com.mycorp.testasset.api.models.UserViewModel;
import com.mycorp.testasset.api.users.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MaterialHome extends AppCompatActivity {

    UserViewModel userViewModel;
    UserAdapter userAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_home);

        recyclerView = findViewById(R.id.rvUsers);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getPostLiveData().observe(this, product);

    }

    Observer<ArrayList<UserResponse>> product = new Observer<ArrayList<UserResponse>>() {
        @Override
        public void onChanged(ArrayList<UserResponse> userResponses) {
            userAdapter = new UserAdapter(MaterialHome.this, userResponses);
            recyclerView.setLayoutManager(new GridLayoutManager(MaterialHome.this, 2));
            recyclerView.setAdapter(userAdapter);
        }
    };

}