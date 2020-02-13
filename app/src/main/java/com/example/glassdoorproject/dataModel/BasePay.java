package com.example.glassdoorproject.dataModel;

import android.os.Parcel;
import android.os.Parcelable;

public class BasePay implements Parcelable {
        private float amount;

        public BasePay(float amount, String currencyCode, String name, String symbol) {
            this.amount = amount;
            this.currencyCode = currencyCode;
            this.name = name;
            this.symbol = symbol;
        }

        private String currencyCode;
        private String name;
        private String symbol;


        // Getter Methods

    protected BasePay(Parcel in) {
        amount = in.readFloat();
        currencyCode = in.readString();
        name = in.readString();
        symbol = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(amount);
        dest.writeString(currencyCode);
        dest.writeString(name);
        dest.writeString(symbol);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BasePay> CREATOR = new Creator<BasePay>() {
        @Override
        public BasePay createFromParcel(Parcel in) {
            return new BasePay(in);
        }

        @Override
        public BasePay[] newArray(int size) {
            return new BasePay[size];
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

}
