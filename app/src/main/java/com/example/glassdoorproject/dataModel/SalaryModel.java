package com.example.glassdoorproject.dataModel;

public class SalaryModel {
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
    }


