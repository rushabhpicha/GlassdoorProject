package com.example.glassdoorproject.dataModel;

import android.os.Parcel;
import android.os.Parcelable;

public class MeanBasePay implements Parcelable {
    private float amount;

    public MeanBasePay(float amount, String currencyCode, String name, String symbol) {
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.name = name;
        this.symbol = symbol;
    }

    private String currencyCode;
    private String name;
    private String symbol;


    // Getter Methods

    protected MeanBasePay(Parcel in) {
        amount = in.readFloat();
        currencyCode = in.readString();
        name = in.readString();
        symbol = in.readString();
    }

    public static final Creator<MeanBasePay> CREATOR = new Creator<MeanBasePay>() {
        @Override
        public MeanBasePay createFromParcel(Parcel in) {
            return new MeanBasePay(in);
        }

        @Override
        public MeanBasePay[] newArray(int size) {
            return new MeanBasePay[size];
        }
    };

    public float getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    // Setter Methods

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(amount);
        dest.writeString(currencyCode);
        dest.writeString(name);
        dest.writeString(symbol);
    }
}
