package com.example.fatimazza.thingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ProductDAO implements Parcelable {

    private int id;
    private String name;
    private long price;
    private String description;

    private List<ProductImageDAO> images;
    private List<ProductReviewsDAO> reviews;

    public ProductDAO() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public List<ProductImageDAO> getImages() {
        return images;
    }

    public List<ProductReviewsDAO> getReviews() {
        return reviews;
    }


    protected ProductDAO(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readLong();
        description = in.readString();
    }

    public static final Creator<ProductDAO> CREATOR = new Creator<ProductDAO>() {
        @Override
        public ProductDAO createFromParcel(Parcel in) {
            return new ProductDAO(in);
        }

        @Override
        public ProductDAO[] newArray(int size) {
            return new ProductDAO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeLong(price);
        parcel.writeString(description);
    }
}
