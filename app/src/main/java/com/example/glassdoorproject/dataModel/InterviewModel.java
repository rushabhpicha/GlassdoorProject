package com.example.glassdoorproject.dataModel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class InterviewModel {
        private String approvalStatus;
        private String attributionURL;
        private float employerId;
        private String employerName;
        private boolean featuredReview;

    public InterviewModel(String approvalStatus, String attributionURL, float employerId, String employerName, boolean featuredReview, float helpfulCount, float id, String interviewDate, String interviewSource, String interviewSteps, String jobTitle, String location, String negotiationDetails, boolean newReview, float notHelpfulCount, String otherSteps, String outcome, String processAnswer, String processDifficulty, String processInterviewExperience, float processLength, String processOverallExperience, InterViewQuestionsModel interViewQuestionsModel, String reasonForDeclining, String reviewDateTime, String sqLogoUrl, String testSteps, float totalHelpfulCount) {
        this.approvalStatus = approvalStatus;
        this.attributionURL = attributionURL;
        this.employerId = employerId;
        this.employerName = employerName;
        this.featuredReview = featuredReview;
        this.helpfulCount = helpfulCount;
        this.id = id;
        this.interviewDate = interviewDate;
        this.interviewSource = interviewSource;
        this.interviewSteps = interviewSteps;
        this.jobTitle = jobTitle;
        this.location = location;
        this.negotiationDetails = negotiationDetails;
        this.newReview = newReview;
        this.notHelpfulCount = notHelpfulCount;
        this.otherSteps = otherSteps;
        this.outcome = outcome;
        this.processAnswer = processAnswer;
        this.processDifficulty = processDifficulty;
        this.processInterviewExperience = processInterviewExperience;
        this.processLength = processLength;
        this.processOverallExperience = processOverallExperience;
        this.interViewQuestionsModel = interViewQuestionsModel;
        this.reasonForDeclining = reasonForDeclining;
        this.reviewDateTime = reviewDateTime;
        this.sqLogoUrl = sqLogoUrl;
        this.testSteps = testSteps;
        this.totalHelpfulCount = totalHelpfulCount;
    }

        private float helpfulCount;
        private float id;
        private String interviewDate;
        private String interviewSource;
        private String interviewSteps = null;
        private String jobTitle;
        private String location;
        private String negotiationDetails = null;
        private boolean newReview;
        private float notHelpfulCount;
        private String otherSteps = null;
        private String outcome;
        private String processAnswer;
        private String processDifficulty;
        private String processInterviewExperience = null;
        private float processLength;
        private String processOverallExperience;
        InterViewQuestionsModel interViewQuestionsModel;
        private String reasonForDeclining = null;
        private String reviewDateTime;
        private String sqLogoUrl;
        private String testSteps = null;
        private float totalHelpfulCount;


        // Getter Methods

        public String getApprovalStatus() {
            return approvalStatus;
        }

        public String getAttributionURL() {
            return attributionURL;
        }

        public float getEmployerId() {
            return employerId;
        }

        public String getEmployerName() {
            return employerName;
        }

        public boolean getFeaturedReview() {
            return featuredReview;
        }

        public float getHelpfulCount() {
            return helpfulCount;
        }

        public float getId() {
            return id;
        }

        public String getInterviewDate() {
            return interviewDate;
        }

        public String getInterviewSource() {
            return interviewSource;
        }

        public String getInterviewSteps() {
            return interviewSteps;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public String getLocation() {
            return location;
        }

        public String getNegotiationDetails() {
            return negotiationDetails;
        }

        public boolean getNewReview() {
            return newReview;
        }

        public float getNotHelpfulCount() {
            return notHelpfulCount;
        }

        public String getOtherSteps() {
            return otherSteps;
        }

        public String getOutcome() {
            return outcome;
        }

        public String getProcessAnswer() {
            return processAnswer;
        }

        public String getProcessDifficulty() {
            return processDifficulty;
        }

        public String getProcessInterviewExperience() {
            return processInterviewExperience;
        }

        public float getProcessLength() {
            return processLength;
        }

        public String getProcessOverallExperience() {
            return processOverallExperience;
        }

        public String getReasonForDeclining() {
            return reasonForDeclining;
        }

        public String getReviewDateTime() {
            return reviewDateTime;
        }

        public String getSqLogoUrl() {
            return sqLogoUrl;
        }

        public String getTestSteps() {
            return testSteps;
        }

        public float getTotalHelpfulCount() {
            return totalHelpfulCount;
        }

        public InterViewQuestionsModel getInterViewQuestionsModel() {
                return interViewQuestionsModel;
            }

        // Setter Methods

        public void setApprovalStatus(String approvalStatus) {
            this.approvalStatus = approvalStatus;
        }

        public void setAttributionURL(String attributionURL) {
            this.attributionURL = attributionURL;
        }

        public void setEmployerId(float employerId) {
            this.employerId = employerId;
        }

        public void setEmployerName(String employerName) {
            this.employerName = employerName;
        }

        public void setFeaturedReview(boolean featuredReview) {
            this.featuredReview = featuredReview;
        }

        public void setHelpfulCount(float helpfulCount) {
            this.helpfulCount = helpfulCount;
        }

        public void setId(float id) {
            this.id = id;
        }

        public void setInterviewDate(String interviewDate) {
            this.interviewDate = interviewDate;
        }

        public void setInterviewSource(String interviewSource) {
            this.interviewSource = interviewSource;
        }

        public void setInterviewSteps(String interviewSteps) {
            this.interviewSteps = interviewSteps;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setNegotiationDetails(String negotiationDetails) {
            this.negotiationDetails = negotiationDetails;
        }

        public void setNewReview(boolean newReview) {
            this.newReview = newReview;
        }

        public void setNotHelpfulCount(float notHelpfulCount) {
            this.notHelpfulCount = notHelpfulCount;
        }

        public void setOtherSteps(String otherSteps) {
            this.otherSteps = otherSteps;
        }

        public void setOutcome(String outcome) {
            this.outcome = outcome;
        }

        public void setProcessAnswer(String processAnswer) {
            this.processAnswer = processAnswer;
        }

        public void setProcessDifficulty(String processDifficulty) {
            this.processDifficulty = processDifficulty;
        }

        public void setProcessInterviewExperience(String processInterviewExperience) {
            this.processInterviewExperience = processInterviewExperience;
        }

        public void setProcessLength(float processLength) {
            this.processLength = processLength;
        }

        public void setProcessOverallExperience(String processOverallExperience) {
            this.processOverallExperience = processOverallExperience;
        }

        public void setReasonForDeclining(String reasonForDeclining) {
            this.reasonForDeclining = reasonForDeclining;
        }

        public void setReviewDateTime(String reviewDateTime) {
            this.reviewDateTime = reviewDateTime;
        }

        public void setSqLogoUrl(String sqLogoUrl) {
            this.sqLogoUrl = sqLogoUrl;
        }

        public void setTestSteps(String testSteps) {
            this.testSteps = testSteps;
        }

        public void setTotalHelpfulCount(float totalHelpfulCount) {
            this.totalHelpfulCount = totalHelpfulCount;
        }
    public void setInterViewQuestionsModel(InterViewQuestionsModel interViewQuestionsModel) {
        this.interViewQuestionsModel = interViewQuestionsModel;
    }
}

class InterViewQuestionsModel implements Parcelable {
    private String attributionURL = null;
    private String date;
    private String employer;
    private float helpfulCount;
    private float id;
    private String jobTitle;
    private String locationCity;
    private String locationCountry;
    private String locationState;
    private String question;
    ArrayList < Object > responses = new ArrayList < Object > ();
    private String squareLogo;
    private float totalHelpfulCount;


    protected InterViewQuestionsModel(Parcel in) {
        attributionURL = in.readString();
        date = in.readString();
        employer = in.readString();
        helpfulCount = in.readFloat();
        id = in.readFloat();
        jobTitle = in.readString();
        locationCity = in.readString();
        locationCountry = in.readString();
        locationState = in.readString();
        question = in.readString();
        squareLogo = in.readString();
        totalHelpfulCount = in.readFloat();
    }

    public static final Creator<InterViewQuestionsModel> CREATOR = new Creator<InterViewQuestionsModel>() {
        @Override
        public InterViewQuestionsModel createFromParcel(Parcel in) {
            return new InterViewQuestionsModel(in);
        }

        @Override
        public InterViewQuestionsModel[] newArray(int size) {
            return new InterViewQuestionsModel[size];
        }
    };

    public String getAttributionURL() {
        return attributionURL;
    }

    public String getDate() {
        return date;
    }

    public String getEmployer() {
        return employer;
    }

    public float getHelpfulCount() {
        return helpfulCount;
    }

    public float getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public String getLocationState() {
        return locationState;
    }

    public String getQuestion() {
        return question;
    }

    public String getSquareLogo() {
        return squareLogo;
    }

    public float getTotalHelpfulCount() {
        return totalHelpfulCount;
    }

    public void setAttributionURL(String attributionURL) {
        this.attributionURL = attributionURL;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public void setHelpfulCount(float helpfulCount) {
        this.helpfulCount = helpfulCount;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setSquareLogo(String squareLogo) {
        this.squareLogo = squareLogo;
    }

    public void setTotalHelpfulCount(float totalHelpfulCount) {
        this.totalHelpfulCount = totalHelpfulCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(attributionURL);
        dest.writeString(date);
        dest.writeString(employer);
        dest.writeFloat(helpfulCount);
        dest.writeFloat(id);
        dest.writeString(jobTitle);
        dest.writeString(locationCity);
        dest.writeString(locationCountry);
        dest.writeString(locationState);
        dest.writeString(question);
        dest.writeString(squareLogo);
        dest.writeFloat(totalHelpfulCount);
    }
}
