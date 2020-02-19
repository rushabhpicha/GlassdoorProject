package com.example.glassdoorproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.glassdoorproject.R;
import com.example.glassdoorproject.adapter.RecycleAdapter;
import com.example.glassdoorproject.dataModel.BasePay;
import com.example.glassdoorproject.dataModel.InterviewModel;
import com.example.glassdoorproject.dataModel.MeanBasePay;
import com.example.glassdoorproject.dataModel.ReviewModel;
import com.example.glassdoorproject.dataModel.SalaryModel;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
    In this activity we are using Volley library to parse the Json Data from the URL.
 */
public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    String tag_json_obj = "json_obj_req";

    String url = "https://raw.githubusercontent.com/vikrama/feed-json-sample/master/feed.json";
    ArrayList<ReviewModel> reviewModelArrayList = new ArrayList<ReviewModel>();
    ArrayList<SalaryModel> salaryModelArrayList = new ArrayList<SalaryModel>();
    ArrayList<InterviewModel> interviewModelArrayList = new ArrayList<InterviewModel>();

    List<Object> universalList = new ArrayList<Object>();
    RecyclerView recyclerView;
    RecycleAdapter recycleAdapter;
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog pDialog;
    boolean success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonobjectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, response.toString());
                        pDialog.hide();
                        try {
                            success = response.getBoolean("success");  // if the value of the success key is true we move further
                            if (success) {
                                JSONObject jsonObject = response.getJSONObject("response");
                                JSONArray resultsArray = jsonObject.getJSONArray("results");

                                // Iterating the results JSON Array
                                for (int i = 0; i < resultsArray.length(); i++) {
                                    JSONObject jsonObjectResponse = resultsArray.getJSONObject(i);
                                    Log.i(TAG, jsonObjectResponse + "");
                                    String type = jsonObjectResponse.getString("type");
                                    Log.i(TAG, type);

                                    /* Here we check the type of JSON Response. If the response is of Review type, we insert the ReviewModel inside our Universal
                                    object. If the response type is Salary, we insert th SalaryModel, otherwise we insert the Interview Model */
                                    if(type.equals("REVIEW_RESULT")){
                                        JSONObject reviewResult = jsonObjectResponse.getJSONObject("review");
                                        Log.i(TAG, reviewResult+"");

                                        if(reviewResult != null) {
                                            reviewModelArrayList.clear();  //clearing the arraylist everytime before updating it
                                            universalList.add(new ReviewModel(reviewResult.getString("advice"), reviewResult.getString("approvalStatus"), reviewResult.getString("attributionURL"), 0.0f, "", 0.0f, 0.0f, reviewResult.getString("cons"), Float.valueOf(reviewResult.getString("cultureAndValuesRating")), true, 0.0f, reviewResult.getString("employerName"), "", "", true, reviewResult.getString("headline"), 0.0f, 0.0f, "", reviewResult.getString("jobTitle"), "", "", reviewResult.getString("location"), true, 0.0f, reviewResult.getString("overall"), Float.valueOf(reviewResult.getString("overallNumeric")), reviewResult.getString("pros"), true, "", 0.0f, reviewResult.getString("sqLogoUrl"), 0.0f, Float.valueOf(reviewResult.getString("workLifeBalanceRating"))));
                                        }
                                    }
                                    if(type.equals("SALARY_RESULT")){
                                        JSONObject salaryResult = jsonObjectResponse.getJSONObject("salary");
                                        JSONObject salaryMeanBasePay = salaryResult.getJSONObject("meanBasePay");// retrieving the Mean Pay from Salary Resullt
                                        JSONObject salaryBasePay =salaryResult.getJSONObject("basePay");// retrieving the base pay from Salary Result

                                        BasePay basePay = new BasePay(Float.valueOf(salaryBasePay.getString("amount")), salaryBasePay.getString("currencyCode"),salaryBasePay.getString("name"), salaryBasePay.getString("symbol"));
                                        MeanBasePay meanBasePay = new MeanBasePay(Float.valueOf(salaryMeanBasePay.getString("amount")), salaryMeanBasePay.getString("currencyCode"),salaryMeanBasePay.getString("name"), salaryMeanBasePay.getString("symbol"));
                                        if(salaryResult != null) {
                                            salaryModelArrayList.clear();
                                            universalList.add(new SalaryModel(salaryResult.getString("attributionURL"), basePay, 0.0f, salaryResult.getString("employerName"), "", 0.0f, salaryResult.getString("jobTitle"), salaryResult.getString("location"), meanBasePay, "", 0.0f, "", "", salaryResult.getString("sqLogoUrl")));
                                        }
                                    }
                                    if(type.equals("INTERVIEW_RESULT")){
                                        JSONObject interviewResult = jsonObjectResponse.getJSONObject("interview");
                                        Log.i(TAG, interviewResult+"");
                                        JSONArray questions = interviewResult.getJSONArray("questions");
                                        Log.i(TAG, questions+"");
                                        if(interviewResult != null) {
                                            interviewModelArrayList.clear();
                                            universalList.add(new InterviewModel(interviewResult.getString("approvalStatus"), interviewResult.getString("attributionURL"), Float.valueOf(interviewResult.getString("employerId")), interviewResult.getString("employerName"), interviewResult.getBoolean("featuredReview"), Float.valueOf(interviewResult.getString("helpfulCount")), Float.valueOf(interviewResult.getString("id")), interviewResult.getString("interviewDate"), interviewResult.getString("interviewSource"), interviewResult.getString("interviewSteps"), interviewResult.getString("jobTitle"), interviewResult.getString("location"), interviewResult.getString("negotiationDetails"), interviewResult.getBoolean("newReview"), Float.valueOf(interviewResult.getString("notHelpfulCount")), interviewResult.getString("otherSteps"), interviewResult.getString("outcome"), interviewResult.getString("processAnswer"), interviewResult.getString("processDifficulty"), interviewResult.getString("processInterviewExperience"), Float.valueOf(interviewResult.getString("processLength")), interviewResult.getString("processOverallExperience"), null, interviewResult.getString("reasonForDeclining"), interviewResult.getString("reviewDateTime"), interviewResult.getString("reviewDateTime"), interviewResult.getString("testSteps"), Float.valueOf(interviewResult.getString("totalHelpfulCount"))));
                                        }
                                    }
                                    //Calling the Constructor of Recycle Adapter
                                    recycleAdapter = new RecycleAdapter((ArrayList<Object>) universalList, MainActivity.this);
                                    recyclerView.setAdapter(recycleAdapter);
                                }

                                Log.i( TAG, jsonObject + "");
                                Log.i( TAG, resultsArray + "");

                            }
                        } catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(MainActivity.this, "Some Error", Toast.LENGTH_LONG).show();
                pDialog.hide();
            }
        });
        requestQueue.add(jsonobjectRequest);
    }
}
