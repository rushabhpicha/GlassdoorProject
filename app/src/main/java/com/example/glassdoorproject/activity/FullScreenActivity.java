package com.example.glassdoorproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glassdoorproject.R;
import com.example.glassdoorproject.dataModel.BasePay;
import com.example.glassdoorproject.dataModel.InterviewModel;
import com.example.glassdoorproject.dataModel.ReviewModel;
import com.example.glassdoorproject.dataModel.SalaryModel;

// In this activity we check the values of id and then appropriately look for the layout and call there implementation methods.
public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        int condition = bundle.getInt("id");
        switch (condition) {
            case 1:
                setContentView(R.layout.review_fullscreen);
                setReviewData();
                break;
            case 2:
                setContentView(R.layout.salary_fullscreen);
                setSalaryData();
                break;
            case 3:
                setContentView(R.layout.interview_fullscreen);
                setInterViewData();
                break;
        }
    }

    private void setInterViewData() {
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            InterviewModel interviewModel;
            Bundle bundle = getIntent().getExtras();
            interviewModel = bundle.getParcelable("InterviewData");
            TextView tinterview = findViewById(R.id.interview);
            tinterview.setText("Interview By :- "+interviewModel.getEmployerName());
        }
    }

    private void setSalaryData() {

        SalaryModel salaryModel;
        Bundle bundle = getIntent().getExtras();
        salaryModel = bundle.getParcelable("SalaryData");
        TextView tsalary = findViewById(R.id.salary);
        tsalary.setText("Salary By :- "+salaryModel.getEmployerName());

    }

    private void setReviewData() {

        ReviewModel reviewModel;
        Bundle bundle = getIntent().getExtras();
        reviewModel = bundle.getParcelable("ReviewData");
        String advice = reviewModel.getAdvice();

        TextView treview = findViewById(R.id.review);
        TextView tpros = findViewById(R.id.pros);
        TextView tcons = findViewById(R.id.cons);
        RatingBar tworkLifeBalance = findViewById(R.id.wlb);
        TextView temployeeName = findViewById(R.id.eName);
        RatingBar roverallRating = findViewById(R.id.overallrating);
        RatingBar rvalues = findViewById(R.id.valuesrating);
        TextView overall = findViewById(R.id.overall);
        TextView location = findViewById(R.id.location);

        if(advice != null || !advice.isEmpty()) {
            treview.setText(advice);
        }
        tpros.setText(reviewModel.getPros().replaceAll("[+]","-"));
        tcons.setText(reviewModel.getCons().replaceAll("[+]","-"));
        tworkLifeBalance.setRating(reviewModel.getWorkLifeBalanceRating());
        tworkLifeBalance.setEnabled(false);
        temployeeName.setText("Review By :- "+reviewModel.getEmployerName());
        roverallRating.setRating(reviewModel.getOverallNumeric());
        tworkLifeBalance.setEnabled(false);
        rvalues.setRating(reviewModel.getCultureAndValuesRating());
        rvalues.setEnabled(false);
        overall.setText(reviewModel.getOverall());
        location.setText(reviewModel.getLocation());
    }
}
