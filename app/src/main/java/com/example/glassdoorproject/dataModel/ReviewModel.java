package com.example.glassdoorproject.dataModel;

import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class ReviewModel implements Parcelable{
        @SerializedName("advice")
        @Expose
        private String advice = "";
        @SerializedName("approvalStatus")
        @Expose
        private String approvalStatus = "";
        @SerializedName("attributionURL")
        @Expose
        private String attributionURL = "";
        private float careerOpportunitiesRating;
        private String ceoApproval = "";
        private float ceoRating;
        private float compensationAndBenefitsRating;
        private String cons = "";
        private float cultureAndValuesRating;
        private boolean currentJob;
        private float employerId;
        private String employerName = "";
        private String employerResponse = "";
        private String employmentStatus = "";
        private boolean featuredReview;
        private String headline = "";
        private float helpfulCount;
        private float id;
        private String jobInformation = "";
        private String jobTitle;
        private String jobTitleFromDb = "";
        private String lengthOfEmployment = "";
        private String location = "";
        private boolean newReview;
        private float notHelpfulCount;
        private String overall = "";
        private float overallNumeric;
        @SerializedName("pros")
        @Expose
        private String pros;
        private boolean recommendToFriend;
        private String reviewDateTime;
        private float seniorLeadershipRating;
        private String sqLogoUrl;
        private float totalHelpfulCount;
        private float workLifeBalanceRating;

    @ParcelConstructor
    public ReviewModel(String advice, String approvalStatus, String attributionURL, float careerOpportunitiesRating, String ceoApproval, float ceoRating, float compensationAndBenefitsRating, String cons, float cultureAndValuesRating, boolean currentJob, float employerId, String employerName, String employerResponse, String employmentStatus, boolean featuredReview, String headline, float helpfulCount, float id, String jobInformation, String jobTitle, String jobTitleFromDb, String lengthOfEmployment, String location, boolean newReview, float notHelpfulCount, String overall, float overallNumeric, String pros, boolean recommendToFriend, String reviewDateTime, float seniorLeadershipRating, String sqLogoUrl, float totalHelpfulCount, float workLifeBalanceRating) {
        this.advice = advice;
        this.approvalStatus = approvalStatus;
        this.attributionURL = attributionURL;
        this.careerOpportunitiesRating = careerOpportunitiesRating;
        this.ceoApproval = ceoApproval;
        this.ceoRating = ceoRating;
        this.compensationAndBenefitsRating = compensationAndBenefitsRating;
        this.cons = cons;
        this.cultureAndValuesRating = cultureAndValuesRating;
        this.currentJob = currentJob;
        this.employerId = employerId;
        this.employerName = employerName;
        this.employerResponse = employerResponse;
        this.employmentStatus = employmentStatus;
        this.featuredReview = featuredReview;
        this.headline = headline;
        this.helpfulCount = helpfulCount;
        this.id = id;
        this.jobInformation = jobInformation;
        this.jobTitle = jobTitle;
        this.jobTitleFromDb = jobTitleFromDb;
        this.lengthOfEmployment = lengthOfEmployment;
        this.location = location;
        this.newReview = newReview;
        this.notHelpfulCount = notHelpfulCount;
        this.overall = overall;
        this.overallNumeric = overallNumeric;
        this.pros = pros;
        this.recommendToFriend = recommendToFriend;
        this.reviewDateTime = reviewDateTime;
        this.seniorLeadershipRating = seniorLeadershipRating;
        this.sqLogoUrl = sqLogoUrl;
        this.totalHelpfulCount = totalHelpfulCount;
        this.workLifeBalanceRating = workLifeBalanceRating;
    }

        // Getter Methods

    protected ReviewModel(android.os.Parcel in) {
        advice = in.readString();
        approvalStatus = in.readString();
        attributionURL = in.readString();
        careerOpportunitiesRating = in.readFloat();
        ceoApproval = in.readString();
        ceoRating = in.readFloat();
        compensationAndBenefitsRating = in.readFloat();
        cons = in.readString();
        cultureAndValuesRating = in.readFloat();
        currentJob = in.readByte() != 0;
        employerId = in.readFloat();
        employerName = in.readString();
        employerResponse = in.readString();
        employmentStatus = in.readString();
        featuredReview = in.readByte() != 0;
        headline = in.readString();
        helpfulCount = in.readFloat();
        id = in.readFloat();
        jobInformation = in.readString();
        jobTitle = in.readString();
        jobTitleFromDb = in.readString();
        lengthOfEmployment = in.readString();
        location = in.readString();
        newReview = in.readByte() != 0;
        notHelpfulCount = in.readFloat();
        overall = in.readString();
        overallNumeric = in.readFloat();
        pros = in.readString();
        recommendToFriend = in.readByte() != 0;
        reviewDateTime = in.readString();
        seniorLeadershipRating = in.readFloat();
        sqLogoUrl = in.readString();
        totalHelpfulCount = in.readFloat();
        workLifeBalanceRating = in.readFloat();
    }

    public static final Creator<ReviewModel> CREATOR = new Creator<ReviewModel>() {
        @Override
        public ReviewModel createFromParcel(android.os.Parcel in) {
            return new ReviewModel(in);
        }

        @Override
        public ReviewModel[] newArray(int size) {
            return new ReviewModel[size];
        }
    };

    public String getAdvice() {
            return advice;
        }

        public String getApprovalStatus() {
            return approvalStatus;
        }

        public String getAttributionURL() {
            return attributionURL;
        }

        public float getCareerOpportunitiesRating() {
            return careerOpportunitiesRating;
        }

        public String getCeoApproval() {
            return ceoApproval;
        }

        public float getCeoRating() {
            return ceoRating;
        }

        public float getCompensationAndBenefitsRating() {
            return compensationAndBenefitsRating;
        }

        public String getCons() {
            return cons;
        }

        public float getCultureAndValuesRating() {
            return cultureAndValuesRating;
        }

        public boolean getCurrentJob() {
            return currentJob;
        }

        public float getEmployerId() {
            return employerId;
        }

        public String getEmployerName() {
            return employerName;
        }

        public String getEmployerResponse() {
            return employerResponse;
        }

        public String getEmploymentStatus() {
            return employmentStatus;
        }

        public boolean getFeaturedReview() {
            return featuredReview;
        }

        public String getHeadline() {
            return headline;
        }

        public float getHelpfulCount() {
            return helpfulCount;
        }

        public float getId() {
            return id;
        }

        public String getJobInformation() {
            return jobInformation;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public String getJobTitleFromDb() {
            return jobTitleFromDb;
        }

        public String getLengthOfEmployment() {
            return lengthOfEmployment;
        }

        public String getLocation() {
            return location;
        }

        public boolean getNewReview() {
            return newReview;
        }

        public float getNotHelpfulCount() {
            return notHelpfulCount;
        }

        public String getOverall() {
            return overall;
        }

        public float getOverallNumeric() {
            return overallNumeric;
        }

        public String getPros() {
            return pros;
        }

        public boolean getRecommendToFriend() {
            return recommendToFriend;
        }

        public String getReviewDateTime() {
            return reviewDateTime;
        }

        public float getSeniorLeadershipRating() {
            return seniorLeadershipRating;
        }

        public String getSqLogoUrl() {
            return sqLogoUrl;
        }

        public float getTotalHelpfulCount() {
            return totalHelpfulCount;
        }

        public float getWorkLifeBalanceRating() {
            return workLifeBalanceRating;
        }

        // Setter Methods

        public void setAdvice(String advice) {
            this.advice = advice;
        }

        public void setApprovalStatus(String approvalStatus) {
            this.approvalStatus = approvalStatus;
        }

        public void setAttributionURL(String attributionURL) {
            this.attributionURL = attributionURL;
        }

        public void setCareerOpportunitiesRating(float careerOpportunitiesRating) {
            this.careerOpportunitiesRating = careerOpportunitiesRating;
        }

        public void setCeoApproval(String ceoApproval) {
            this.ceoApproval = ceoApproval;
        }

        public void setCeoRating(float ceoRating) {
            this.ceoRating = ceoRating;
        }

        public void setCompensationAndBenefitsRating(float compensationAndBenefitsRating) {
            this.compensationAndBenefitsRating = compensationAndBenefitsRating;
        }

        public void setCons(String cons) {
            this.cons = cons;
        }

        public void setCultureAndValuesRating(float cultureAndValuesRating) {
            this.cultureAndValuesRating = cultureAndValuesRating;
        }

        public void setCurrentJob(boolean currentJob) {
            this.currentJob = currentJob;
        }

        public void setEmployerId(float employerId) {
            this.employerId = employerId;
        }

        public void setEmployerName(String employerName) {
            this.employerName = employerName;
        }

        public void setEmployerResponse(String employerResponse) {
            this.employerResponse = employerResponse;
        }

        public void setEmploymentStatus(String employmentStatus) {
            this.employmentStatus = employmentStatus;
        }

        public void setFeaturedReview(boolean featuredReview) {
            this.featuredReview = featuredReview;
        }

        public void setHeadline(String headline) {
            this.headline = headline;
        }

        public void setHelpfulCount(float helpfulCount) {
            this.helpfulCount = helpfulCount;
        }

        public void setId(float id) {
            this.id = id;
        }

        public void setJobInformation(String jobInformation) {
            this.jobInformation = jobInformation;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public void setJobTitleFromDb(String jobTitleFromDb) {
            this.jobTitleFromDb = jobTitleFromDb;
        }

        public void setLengthOfEmployment(String lengthOfEmployment) {
            this.lengthOfEmployment = lengthOfEmployment;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setNewReview(boolean newReview) {
            this.newReview = newReview;
        }

        public void setNotHelpfulCount(float notHelpfulCount) {
            this.notHelpfulCount = notHelpfulCount;
        }

        public void setOverall(String overall) {
            this.overall = overall;
        }

        public void setOverallNumeric(float overallNumeric) {
            this.overallNumeric = overallNumeric;
        }

        public void setPros(String pros) {
            this.pros = pros;
        }

        public void setRecommendToFriend(boolean recommendToFriend) {
            this.recommendToFriend = recommendToFriend;
        }

        public void setReviewDateTime(String reviewDateTime) {
            this.reviewDateTime = reviewDateTime;
        }

        public void setSeniorLeadershipRating(float seniorLeadershipRating) {
            this.seniorLeadershipRating = seniorLeadershipRating;
        }

        public void setSqLogoUrl(String sqLogoUrl) {
            this.sqLogoUrl = sqLogoUrl;
        }

        public void setTotalHelpfulCount(float totalHelpfulCount) {
            this.totalHelpfulCount = totalHelpfulCount;
        }

        public void setWorkLifeBalanceRating(float workLifeBalanceRating) {
            this.workLifeBalanceRating = workLifeBalanceRating;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(advice);
        dest.writeString(approvalStatus);
        dest.writeString(attributionURL);
        dest.writeFloat(careerOpportunitiesRating);
        dest.writeString(ceoApproval);
        dest.writeFloat(ceoRating);
        dest.writeFloat(compensationAndBenefitsRating);
        dest.writeString(cons);
        dest.writeFloat(cultureAndValuesRating);
        dest.writeByte((byte) (currentJob ? 1 : 0));
        dest.writeFloat(employerId);
        dest.writeString(employerName);
        dest.writeString(employerResponse);
        dest.writeString(employmentStatus);
        dest.writeByte((byte) (featuredReview ? 1 : 0));
        dest.writeString(headline);
        dest.writeFloat(helpfulCount);
        dest.writeFloat(id);
        dest.writeString(jobInformation);
        dest.writeString(jobTitle);
        dest.writeString(jobTitleFromDb);
        dest.writeString(lengthOfEmployment);
        dest.writeString(location);
        dest.writeByte((byte) (newReview ? 1 : 0));
        dest.writeFloat(notHelpfulCount);
        dest.writeString(overall);
        dest.writeFloat(overallNumeric);
        dest.writeString(pros);
        dest.writeByte((byte) (recommendToFriend ? 1 : 0));
        dest.writeString(reviewDateTime);
        dest.writeFloat(seniorLeadershipRating);
        dest.writeString(sqLogoUrl);
        dest.writeFloat(totalHelpfulCount);
        dest.writeFloat(workLifeBalanceRating);
    }
}
