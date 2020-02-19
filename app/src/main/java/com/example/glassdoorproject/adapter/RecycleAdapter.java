package com.example.glassdoorproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

import java.util.ArrayList;
import java.util.Objects;

/* In the RecycleAdapter we check what kind of Object the Universal Object from the MainActivity is passed. Based
    on the information from the MainActivity further processing of the recyclerView is done.
*/
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_REVIEW = 0;
    private final int VIEW_TYPE_SALARY = 1;
    private final int VIEW_TYPE_INTERVIEW = 2;
    private ArrayList<Object> objects;
    private Context context;

    public RecycleAdapter(ArrayList<Object> objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Defining the three different layouts for review item, salary item and interview item.
        View itemLayoutView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        View itemLayoutView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_salary, parent, false);
        View itemLayoutView3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interview, parent, false);


        switch (viewType) {
            case VIEW_TYPE_REVIEW:
                return new ReviewViewHolder(itemLayoutView1);

            case VIEW_TYPE_SALARY:
                return new SalaryViewHolder(itemLayoutView2);

            case VIEW_TYPE_INTERVIEW:
                return new InterViewViewHolder(itemLayoutView3);

            default:
                return null;
        }
    }

    // This method returns which type of instance the object variable contains
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ReviewViewHolder) {
            ((ReviewViewHolder) holder).populateReview((ReviewModel) objects.get(position));

            ((ReviewViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ReviewModel reviewModel = (ReviewModel) objects.get(position);
                    Intent intent = new Intent(context,FullScreenActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("ReviewData", reviewModel);
                    intent.putExtras(bundle);
                    intent.putExtra("id", 1);
                    context.startActivity(intent);
                }
            });
        }

        if (holder instanceof SalaryViewHolder) {
            ((SalaryViewHolder) holder).populateSalary((SalaryModel) objects.get(position));
            ((SalaryViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SalaryModel salaryModel = (SalaryModel) objects.get(position);
                    Intent intent = new Intent(context,FullScreenActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("SalaryData", salaryModel);
                    intent.putExtras(bundle);
                    intent.putExtra("id", 2);
                    context.startActivity(intent);
                }
            });
        }
        if (holder instanceof InterViewViewHolder) {
            ((InterViewViewHolder) holder).populateInterview((InterviewModel) objects.get(position));
            ((InterViewViewHolder)holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InterviewModel interviewModel = (InterviewModel) objects.get(position);
                    Intent intent = new Intent(context,FullScreenActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("InterviewData", interviewModel);
                    intent.putExtras(bundle);
                    intent.putExtra("id", 3);
                    context.startActivity(intent);
                }
            });
        }
    }
        class ReviewViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            TextView tName, tLocation, theadline, tjobTitle;
            ImageView logo;
            RatingBar overallRatings;

            ReviewViewHolder(View itemView) {
                super(itemView);
                tName = itemView.findViewById(R.id.eName);
                cardView = itemView.findViewById(R.id.card_view);
                tLocation = itemView.findViewById(R.id.location);
                theadline = itemView.findViewById(R.id.headline);
                logo = itemView.findViewById(R.id.logo);
                tjobTitle =itemView.findViewById(R.id.jobTitle);
                overallRatings = itemView.findViewById(R.id.overallRating);
            }
            void populateReview(ReviewModel reviewModel) {
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
            private TextView eName, tbaseSalary, tmeanSalary, tlocation, tjobTitle;
            private ImageView logo;
            private CardView cardView;

            SalaryViewHolder(View itemView) {
                super(itemView);
                eName = itemView.findViewById(R.id.eName);
                tbaseSalary = itemView.findViewById(R.id.baseSalary);
                tmeanSalary = itemView.findViewById(R.id.meanSalary);
                tlocation = itemView.findViewById(R.id.location);
                tjobTitle = itemView.findViewById(R.id.jobTitle);
                logo = itemView.findViewById(R.id.logo);
                cardView = itemView.findViewById(R.id.card_view);
            }

            @SuppressLint("SetTextI18n")
            void populateSalary(SalaryModel salaryModel) {
                eName.setText(salaryModel.getEmployerName());
                tbaseSalary.setText(salaryModel.getBasePay().getAmount()+salaryModel.getBasePay().getSymbol());
                tmeanSalary.setText(salaryModel.getMeanBasePay().getAmount()+salaryModel.getMeanBasePay().getSymbol());
                tlocation.setText(salaryModel.getLocation());
                tjobTitle.setText(salaryModel.getJobTitle());
                Picasso.get().load(salaryModel.getSqLogoUrl()).into(logo);
            }
        }
    class InterViewViewHolder extends RecyclerView.ViewHolder {

        private TextView eName, location, jobTitle, overallExperience, questions;
        ImageView logo;
        CardView cardView;

        InterViewViewHolder(View itemView) {
            super(itemView);
            eName = itemView.findViewById(R.id.eName);
            logo = itemView.findViewById(R.id.logo);
            location = itemView.findViewById(R.id.location);
            jobTitle = itemView.findViewById(R.id.jobTitle);
            overallExperience = itemView.findViewById(R.id.overallExperience);
            cardView = itemView.findViewById(R.id.card_view);
        }

        void populateInterview(InterviewModel interviewModel) {
            eName.setText(interviewModel.getEmployerName());
            Picasso.get().load(interviewModel.getSqLogoUrl()).into(logo);
            location.setText(interviewModel.getLocation());
            jobTitle.setText(interviewModel.getJobTitle());
            overallExperience.setText(interviewModel.getProcessOverallExperience());
        }
    }
}

