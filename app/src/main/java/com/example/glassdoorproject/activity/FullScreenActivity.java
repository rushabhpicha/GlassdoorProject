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
import com.example.glassdoorproject.dataModel.ReviewModel;

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
                setInterViewData();
                setContentView(R.layout.interview_fullscreen);
                break;
        }
    }

    private void setInterViewData() {
    }

    private void setSalaryData() {
        TextView tName = findViewById(R.id.salary);
        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        String value = intent.getExtras().getString("location");
        String attributionURL = bundle.getString("attributionURL");
        String jobTitle = bundle.getString("jobTitle");
        String location = bundle.getString("location");
        String sqLogoURL = bundle.getString("sqLogoURL");
        BasePay basePay = bundle.getParcelable("basePay");
        Float amount = basePay.getAmount();
        Toast.makeText(this, ""+amount, Toast.LENGTH_SHORT).show();
        Log.i("Location", location);

    }

    private void setReviewData() {

        TextView treview = findViewById(R.id.review);
        TextView tpros = findViewById(R.id.pros);
        TextView tcons = findViewById(R.id.cons);
        RatingBar tworkLifeBalance = findViewById(R.id.wlb);
        TextView tEmployeeName = findViewById(R.id.eName);


        Bundle bundle = getIntent().getExtras();
        String advice = bundle.getString("advice");
        String approvalStatus = bundle.getString("approvalStatus");
        String attributionURL = bundle.getString("attributionURL");
        String pros = bundle.getString("pros").replaceAll("[+]","-");
        String cons = bundle.getString("cons").replaceAll("[+]","-");
        String employerName = bundle.getString("employerName");
        String headline = bundle.getString("headline");
        String location = bundle.getString("location");
        String sqLogoURL = bundle.getString("sqLogoURL");
        final Float workLifeBalanceRating = bundle.getFloat("workLifeBalanceRating");

        treview.setText(advice);
        tpros.setText(pros);
        tcons.setText(cons);
        tworkLifeBalance.setRating(workLifeBalanceRating);
        tworkLifeBalance.setEnabled(false);
        tEmployeeName.setText("Review By :- "+employerName);

//        Toast.makeText(this, ""+sqLogoURL, Toast.LENGTH_SHORT).show();
    }
}
