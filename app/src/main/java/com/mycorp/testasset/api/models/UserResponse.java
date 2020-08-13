package com.mycorp.testasset.api.models;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

public class UserResponse{

	@SerializedName("image")
	private String image;

	@SerializedName("price")
	private double price;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String product_title;

	@SerializedName("category")
	private String category;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.product_title = title;
	}

	public String getTitle(){
		return product_title;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	@BindingAdapter("images")
	public static void loadImage(ImageView view, String image) {
		Glide.with(view.getContext()).load(image).apply(RequestOptions.centerInsideTransform()).into(view);
	}
}