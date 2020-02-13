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
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "Response";
    String tag_json_obj = "json_obj_req";

    String url = "https://raw.githubusercontent.com/vikrama/feed-json-sample/master/feed.json";
    ArrayList<ReviewModel> reviewModelArrayList = new ArrayList<ReviewModel>();
    ArrayList<SalaryModel> salaryModelArrayList = new ArrayList<SalaryModel>();
    ArrayList<InterviewModel> interviewModelArrayList = new ArrayList<InterviewModel>();

    List<Object> universalList = new ArrayList<Object>();
    RecyclerView recyclerView;
    RecycleAdapter recycleAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        JsonObjectRequest jsonobjectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, response.toString());
                       // Toast.makeText(MainActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
                        pDialog.hide();
                            try {
                                boolean success = response.getBoolean("success");
                                if (success) {
                                    JSONObject jsonObject = response.getJSONObject("response");
                                    JSONArray aResults = jsonObject.getJSONArray("results");

                                    for (int i = 0; i < aResults.length(); i++) {
                                        JSONObject oResponse = aResults.getJSONObject(i);
                                        Log.i("Response3 ", oResponse + "");
                                        String type = oResponse.getString("type");
                                        Log.i("Type ", type);
                                        if(type.equals("REVIEW_RESULT")){
                                            JSONObject reviewResult = oResponse.getJSONObject("review");
                                            Log.i("Review", reviewResult+"");

                                            if(reviewResult != null) {
                                                
                                                sendData();
                                                reviewModelArrayList.clear();
                                                universalList.add(new ReviewModel(reviewResult.getString("advice"), reviewResult.getString("approvalStatus"), reviewResult.getString("attributionURL"), 0.0f, "", 0.0f, 0.0f, reviewResult.getString("cons"), 0.0f, true, 0.0f, reviewResult.getString("employerName"), "", "", true, "", 0.0f, 0.0f, "", reviewResult.getString("jobTitle"), "", "", reviewResult.getString("location"), true, 0.0f, "", 0.0f, reviewResult.getString("pros"), true, "", 0.0f, reviewResult.getString("sqLogoUrl"), 0.0f, Float.valueOf(reviewResult.getString("workLifeBalanceRating"))));
                                                recycleAdapter = new RecycleAdapter((ArrayList<Object>) universalList, MainActivity.this);
                                                recyclerView.setAdapter(recycleAdapter);
                                            }
                                        }
                                        if(type.equals("SALARY_RESULT")){
                                            JSONObject salaryResult = oResponse.getJSONObject("salary");
                                            JSONObject omeanBasePay = salaryResult.getJSONObject("meanBasePay");
                                            JSONObject obasePay =salaryResult.getJSONObject("basePay");

                                            BasePay basePay = new BasePay(Float.valueOf(obasePay.getString("amount")), obasePay.getString("currencyCode"),obasePay.getString("name"), obasePay.getString("symbol"));
                                            MeanBasePay meanBasePay = new MeanBasePay(Float.valueOf(omeanBasePay.getString("amount")), omeanBasePay.getString("currencyCode"),omeanBasePay.getString("name"), omeanBasePay.getString("symbol"));
                                            salaryModelArrayList.clear();
                                            universalList.add(new SalaryModel(salaryResult.getString("attributionURL"), basePay, 0.0f, salaryResult.getString("employerName"), "", 0.0f, salaryResult.getString("jobTitle"), salaryResult.getString("location"), meanBasePay, "", 0.0f, "", "", salaryResult.getString("sqLogoUrl")));
                                            recycleAdapter = new RecycleAdapter((ArrayList<Object>) universalList, MainActivity.this);
                                            recycleAdapter.notifyDataSetChanged();
                                        }
                                        if(type.equals("INTERVIEW_RESULT")){
                                            JSONObject interviewResult = oResponse.getJSONObject("interview");
                                            Log.i("Interview", interviewResult+"");
                                            JSONArray questions = interviewResult.getJSONArray("questions");
                                            Log.i("Questions", questions+"");
                                            interviewModelArrayList.clear();
                                            universalList.add(new InterviewModel(interviewResult.getString("approvalStatus"), interviewResult.getString("attributionURL"), Float.valueOf(interviewResult.getString("employerId")), interviewResult.getString("employerName"), interviewResult.getBoolean("featuredReview"), Float.valueOf(interviewResult.getString("helpfulCount")), Float.valueOf(interviewResult.getString("id")), interviewResult.getString("interviewDate"), interviewResult.getString("interviewSource"), interviewResult.getString("interviewSteps"), interviewResult.getString("jobTitle"), interviewResult.getString("location"), interviewResult.getString("negotiationDetails"), interviewResult.getBoolean("newReview"), Float.valueOf(interviewResult.getString("notHelpfulCount")), interviewResult.getString("otherSteps"), interviewResult.getString("outcome"), interviewResult.getString("processAnswer"), interviewResult.getString("processDifficulty"), interviewResult.getString("processInterviewExperience"), Float.valueOf(interviewResult.getString("processLength")), interviewResult.getString("processOverallExperience"), null, interviewResult.getString("reasonForDeclining"), interviewResult.getString("reviewDateTime"), interviewResult.getString("reviewDateTime"), interviewResult.getString("testSteps"), Float.valueOf(interviewResult.getString("totalHelpfulCount"))));
                                            recycleAdapter = new RecycleAdapter((ArrayList<Object>) universalList, MainActivity.this);
                                            recycleAdapter.notifyDataSetChanged();
                                        }
                                    }

                                    Log.i("Response1 ", jsonObject + "");
                                    Log.i("Response2 ", aResults + "");

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

    private void sendData() {
    }
}
