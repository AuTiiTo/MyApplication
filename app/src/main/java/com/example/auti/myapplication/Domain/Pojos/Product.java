package com.example.auti.myapplication.Domain.Pojos;

import java.util.UUID;

/**
 * Created by auti_ on 11/4/2017.
 */

public class Product {
    private String mCode;
    private String mName;
    private String mDescription;
    private String mBrand;
    private float mPrice;
    private int mUnitsInStock;
    private String mImageUrl;

    public Product(String name, float price, String urlImage) {
        this.mCode = UUID.randomUUID().toString();
        this.mName = name;
        this.mPrice = price;
        this.mImageUrl = urlImage;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String mCode) {
        this.mCode = mCode;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getBrand() {
        return mBrand;
    }

    public void setBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public float getPrice() {
        return mPrice;
    }

    public String getFormatedPrice() {
        return String.format("$%s", mPrice);
    }

    public void setPrice(float mPrice) {
        this.mPrice = mPrice;
    }

    public int getUnitsInStock() {
        return mUnitsInStock;
    }

    public String getFormattedUnitsInStock() {
        return String.format("$%d u.", mUnitsInStock);
    }

    public void setUnitsInStock(int mUnitsInStock) {
        this.mUnitsInStock = mUnitsInStock;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
