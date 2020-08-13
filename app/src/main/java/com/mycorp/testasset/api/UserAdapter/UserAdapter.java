package com.mycorp.testasset.api.UserAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mycorp.testasset.R;
import com.mycorp.testasset.api.models.UserResponse;
import com.mycorp.testasset.databinding.ItemListBinding;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private ArrayList<UserResponse> user = new ArrayList<>();
    private Context context;

    public UserAdapter(Context applicationContext, ArrayList<UserResponse> user) {
        this.context = applicationContext;
        this.user = user;

        Log.d("user", String.valueOf(user));
        notifyItemChanged(0, user);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemListBinding itemListBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_list, parent, false);

        return new MyViewHolder(itemListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(user.get(position));
    }

    @Override
    public int getItemCount() {
        if (user != null) {
            return user.size();
        }else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ItemListBinding itemListBinding;
        public MyViewHolder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());

            this.itemListBinding = binding;


        }

        public void bind(UserResponse userResponse) {
            itemListBinding.setProduct(userResponse);
            itemListBinding.setImages(userResponse.getImage());
        }
    }
}
