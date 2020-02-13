package com.example.glassdoorproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glassdoorproject.R;
import com.example.glassdoorproject.activity.FullScreenActivity;
import com.example.glassdoorproject.activity.MainActivity;
import com.example.glassdoorproject.dataModel.BasePay;
import com.example.glassdoorproject.dataModel.InterviewModel;
import com.example.glassdoorproject.dataModel.ReviewModel;
import com.example.glassdoorproject.dataModel.SalaryModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.parceler.Parcels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final int VIEW_TYPE_REVIEW = 0;
    final int VIEW_TYPE_SALARY = 1;
    final int VIEW_TYPE_INTERVIEW = 2;
    int index;

    ArrayList<Object> objects = new ArrayList<Object>();
    Context context;

    public RecycleAdapter(ArrayList<Object> objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        View itemLayoutView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_salary, parent, false);
        View itemLayoutView3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interview, parent, false);


        switch (viewType) {

            case VIEW_TYPE_REVIEW:

                ReviewViewHolder reviewViewHolder = new ReviewViewHolder(itemLayoutView1);
                return reviewViewHolder;

            case VIEW_TYPE_SALARY:

                SalaryViewHolder salaryViewHolder = new SalaryViewHolder(itemLayoutView2);
                return salaryViewHolder;

            case VIEW_TYPE_INTERVIEW:

                InterViewViewHolder interViewViewHolder = new InterViewViewHolder(itemLayoutView3);
                return interViewViewHolder;

            default:
                return null;
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (objects.get(position) instanceof ReviewModel) {
            return VIEW_TYPE_REVIEW;
        } else if (objects.get(position) instanceof SalaryModel) {
            return VIEW_TYPE_SALARY;
        } else {
            return VIEW_TYPE_INTERVIEW;
        }
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof ReviewViewHolder) {
            ((ReviewViewHolder) holder).populateReview((ReviewModel) objects.get(position));

            ((ReviewViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FullScreenActivity.class);
                    intent.putExtra("id", 1);
                    intent.putExtra("advice", ((ReviewModel) objects.get(position)).getAdvice());
                    intent.putExtra("approvalStatus", ((ReviewModel) objects.get(position)).getApprovalStatus());
                    intent.putExtra("attributionURL", ((ReviewModel) objects.get(position)).getAttributionURL());
                    intent.putExtra("pros", ((ReviewModel) objects.get(position)).getPros());
                    intent.putExtra("cons", ((ReviewModel) objects.get(position)).getCons());
                    intent.putExtra("employerName", ((ReviewModel) objects.get(position)).getEmployerName());
                    intent.putExtra("headline", ((ReviewModel) objects.get(position)).getHeadline());
                    intent.putExtra("location", ((ReviewModel) objects.get(position)).getLocation());
                    intent.putExtra("sqLogoUrl", ((ReviewModel) objects.get(position)).getSqLogoUrl());
                    intent.putExtra("workLifeBalanceRating", ((ReviewModel) objects.get(position)).getWorkLifeBalanceRating());
                    context.startActivity(intent);

                }
            });
        }

        if (holder instanceof SalaryViewHolder) {
            ((SalaryViewHolder) holder).populateSalary((SalaryModel) objects.get(position));
            ((SalaryViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FullScreenActivity.class);
                    intent.putExtra("id", 2);
                    intent.putExtra("eName", ((SalaryModel) objects.get(position)).getEmployerName());
                    intent.putExtra("attributionURL", ((SalaryModel) objects.get(position)).getAttributionURL());
                    intent.putExtra("jobTitle", ((SalaryModel) objects.get(position)).getJobTitle());
                    intent.putExtra("location", ((SalaryModel) objects.get(position)).getLocation());
                    intent.putExtra("sqLogoURL", ((SalaryModel) objects.get(position)).getSqLogoUrl());
                    intent.putExtra("basePay", (Parcelable) ((SalaryModel) objects.get(position)).getBasePay());
                    context.startActivity(intent);
                }
            });
        }
        if (holder instanceof InterViewViewHolder) {
            ((InterViewViewHolder) holder).populateInterview((InterviewModel) objects.get(position));
        }
    }
        class ReviewViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            TextView tName, tLocation, theadline, tjobTitle;
            ImageView logo;
            RatingBar overallRatings;

            public ReviewViewHolder(View itemView) {
                super(itemView);
                tName = itemView.findViewById(R.id.eName);
                cardView = itemView.findViewById(R.id.card_view);
                tLocation = itemView.findViewById(R.id.location);
                theadline = itemView.findViewById(R.id.headline);
                logo = itemView.findViewById(R.id.logo);
                tjobTitle =itemView.findViewById(R.id.jobTitle);
                overallRatings = itemView.findViewById(R.id.overallRating);
            }
            public void populateReview(ReviewModel reviewModel) {
                tName.setText(reviewModel.getEmployerName());
                theadline.setText(reviewModel.getHeadline());
                tjobTitle.setText(reviewModel.getJobTitle());
                overallRatings.setRating(reviewModel.getOverallNumeric());
                overallRatings.setEnabled(false);
                tLocation.setText(reviewModel.getLocation());
                Picasso.get().load(reviewModel.getSqLogoUrl()).into(logo);
            }
        }

        class SalaryViewHolder extends RecyclerView.ViewHolder {
            private TextView eName, tbaseSalary, tmeanSalary, tLocation, tjobTitle;
            private ImageView logo;
            private CardView cardView;

            public SalaryViewHolder(View itemView) {
                super(itemView);
                eName = itemView.findViewById(R.id.eName);
                tbaseSalary = itemView.findViewById(R.id.baseSalary);
                tmeanSalary = itemView.findViewById(R.id.meanSalary);
                tLocation = itemView.findViewById(R.id.location);
                tjobTitle = itemView.findViewById(R.id.jobTitle);
                logo = itemView.findViewById(R.id.logo);
                cardView = itemView.findViewById(R.id.card_view);
            }

            public void populateSalary(SalaryModel salaryModel) {
                eName.setText(salaryModel.getEmployerName());
                tbaseSalary.setText(String.valueOf(salaryModel.getBasePay().getAmount())+salaryModel.getBasePay().getSymbol());
                tmeanSalary.setText(String.valueOf(salaryModel.getMeanBasePay().getAmount())+salaryModel.getMeanBasePay().getSymbol());
                tLocation.setText(salaryModel.getLocation());
                tjobTitle.setText(salaryModel.getJobTitle());
                Picasso.get().load(salaryModel.getSqLogoUrl()).into(logo);
            }
        }
    class InterViewViewHolder extends RecyclerView.ViewHolder {

        private TextView eName, location, jobTitle, overallExperience, questions;
        ImageView logo;

        public InterViewViewHolder(View itemView) {
            super(itemView);
            eName = itemView.findViewById(R.id.eName);
            logo = itemView.findViewById(R.id.logo);
            location = itemView.findViewById(R.id.location);
            jobTitle = itemView.findViewById(R.id.jobTitle);
            overallExperience = itemView.findViewById(R.id.overallExperience);

        }

        public void populateInterview(InterviewModel interviewModel) {
            eName.setText(interviewModel.getEmployerName());
            Picasso.get().load(interviewModel.getSqLogoUrl()).into(logo);
            location.setText(interviewModel.getLocation());
            jobTitle.setText(interviewModel.getJobTitle());
            overallExperience.setText(interviewModel.getProcessOverallExperience());

        }
    }
}

