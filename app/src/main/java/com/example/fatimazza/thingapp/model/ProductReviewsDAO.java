package com.example.fatimazza.thingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductReviewsDAO implements Parcelable {

    private int stars;
    private String body;
    private String author;

    public ProductReviewsDAO() {

    }

    public int getStars() {
        return stars;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    protected ProductReviewsDAO(Parcel in) {
        stars = in.readInt();
        body = in.readString();
        author = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(stars);
        dest.writeString(body);
        dest.writeString(author);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductReviewsDAO> CREATOR = new Creator<ProductReviewsDAO>() {
        @Override
        public ProductReviewsDAO createFromParcel(Parcel in) {
            return new ProductReviewsDAO(in);
        }

        @Override
        public ProductReviewsDAO[] newArray(int size) {
            return new ProductReviewsDAO[size];
        }
    };
}
