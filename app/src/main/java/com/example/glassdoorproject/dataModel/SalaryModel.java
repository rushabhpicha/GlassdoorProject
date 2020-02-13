package com.example.glassdoorproject.dataModel;

import android.os.Parcel;
import android.os.Parcelable;

public class SalaryModel implements Parcelable {
        private String attributionURL;
        BasePay BasePayObject;
        private float employerId;
        private String employerName;
        private String employmentStatus;
        private float id;
        private String jobTitle;
        private String location;
        MeanBasePay MeanBasePayObject;
        private String payDeltaLocationType;
        private float payDeltaPercent;
        private String payPeriod;
        private String reviewDateTime;
        private String sqLogoUrl;

    public SalaryModel(String attributionURL, BasePay basePayObject, float employerId, String employerName, String employmentStatus, float id, String jobTitle, String location, MeanBasePay meanBasePayObject, String payDeltaLocationType, float payDeltaPercent, String payPeriod, String reviewDateTime, String sqLogoUrl) {
        this.attributionURL = attributionURL;
        BasePayObject = basePayObject;
        this.employerId = employerId;
        this.employerName = employerName;
        this.employmentStatus = employmentStatus;
        this.id = id;
        this.jobTitle = jobTitle;
        this.location = location;
        MeanBasePayObject = meanBasePayObject;
        this.payDeltaLocationType = payDeltaLocationType;
        this.payDeltaPercent = payDeltaPercent;
        this.payPeriod = payPeriod;
        this.reviewDateTime = reviewDateTime;
        this.sqLogoUrl = sqLogoUrl;
    }

    public SalaryModel() {

    }

    protected SalaryModel(Parcel in) {
        attributionURL = in.readString();
        BasePayObject = in.readParcelable(BasePay.class.getClassLoader());
        employerId = in.readFloat();
        employerName = in.readString();
        employmentStatus = in.readString();
        id = in.readFloat();
        jobTitle = in.readString();
        location = in.readString();
        MeanBasePayObject = in.readParcelable(MeanBasePay.class.getClassLoader());
        payDeltaLocationType = in.readString();
        payDeltaPercent = in.readFloat();
        payPeriod = in.readString();
        reviewDateTime = in.readString();
        sqLogoUrl = in.readString();
    }

    public static final Creator<SalaryModel> CREATOR = new Creator<SalaryModel>() {
        @Override
        public SalaryModel createFromParcel(Parcel in) {
            return new SalaryModel(in);
        }

        @Override
        public SalaryModel[] newArray(int size) {
            return new SalaryModel[size];
        }
    };

    public String getAttributionURL() {
            return attributionURL;
        }

        public BasePay getBasePay() {
            return BasePayObject;
        }

        public float getEmployerId() {
            return employerId;
        }

        public String getEmployerName() {
            return employerName;
        }

        public String getEmploymentStatus() {
            return employmentStatus;
        }

        public float getId() {
            return id;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public String getLocation() {
            return location;
        }

        public MeanBasePay getMeanBasePay() {
            return MeanBasePayObject;
        }

        public String getPayDeltaLocationType() {
            return payDeltaLocationType;
        }

        public float getPayDeltaPercent() {
            return payDeltaPercent;
        }

        public String getPayPeriod() {
            return payPeriod;
        }

        public String getReviewDateTime() {
            return reviewDateTime;
        }

        public String getSqLogoUrl() {
            return sqLogoUrl;
        }

        public void setAttributionURL(String attributionURL) {
            this.attributionURL = attributionURL;
        }

        public void setBasePay(BasePay basePayObject) {
            this.BasePayObject = basePayObject;
        }

        public void setEmployerId(float employerId) {
            this.employerId = employerId;
        }

        public void setEmployerName(String employerName) {
            this.employerName = employerName;
        }

        public void setEmploymentStatus(String employmentStatus) {
            this.employmentStatus = employmentStatus;
        }

        public void setId(float id) {
            this.id = id;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setMeanBasePay(MeanBasePay meanBasePayObject) {
            this.MeanBasePayObject = meanBasePayObject;
        }

        public void setPayDeltaLocationType(String payDeltaLocationType) {
            this.payDeltaLocationType = payDeltaLocationType;
        }

        public void setPayDeltaPercent(float payDeltaPercent) {
            this.payDeltaPercent = payDeltaPercent;
        }

        public void setPayPeriod(String payPeriod) {
            this.payPeriod = payPeriod;
        }

        public void setReviewDateTime(String reviewDateTime) {
            this.reviewDateTime = reviewDateTime;
        }

        public void setSqLogoUrl(String sqLogoUrl) {
            this.sqLogoUrl = sqLogoUrl;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(attributionURL);
        dest.writeParcelable(BasePayObject, flags);
        dest.writeFloat(employerId);
        dest.writeString(employerName);
        dest.writeString(employmentStatus);
        dest.writeFloat(id);
        dest.writeString(jobTitle);
        dest.writeString(location);
        dest.writeParcelable(MeanBasePayObject, flags);
        dest.writeString(payDeltaLocationType);
        dest.writeFloat(payDeltaPercent);
        dest.writeString(payPeriod);
        dest.writeString(reviewDateTime);
        dest.writeString(sqLogoUrl);
    }
}


