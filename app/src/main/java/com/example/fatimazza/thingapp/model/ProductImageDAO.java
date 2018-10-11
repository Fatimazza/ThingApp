package com.example.fatimazza.thingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductImageDAO implements Parcelable {

    private String full;
    private String thumb;

    public ProductImageDAO() {

    }

    public String getFull() {
        return full;
    }

    public String getThumb() {
        return thumb;
    }

    protected ProductImageDAO(Parcel in) {
        full = in.readString();
        thumb = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(full);
        dest.writeString(thumb);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductImageDAO> CREATOR = new Creator<ProductImageDAO>() {
        @Override
        public ProductImageDAO createFromParcel(Parcel in) {
            return new ProductImageDAO(in);
        }

        @Override
        public ProductImageDAO[] newArray(int size) {
            return new ProductImageDAO[size];
        }
    };
}
