package com.ciberciti.gwebsafety.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.ciberciti.gwebsafety.R;
import com.ciberciti.gwebsafety.service.RetrofitInstance;
import com.ciberciti.gwebsafety.service.SiteSummaryDataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SiteSummaryRepository {


    SiteSummaryDataService siteSummaryDataService;
    MutableLiveData<SiteSummaryResponse> mutableSiteSummaryResponse = new MutableLiveData<>();
    Application application;

    public SiteSummaryRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<SiteSummaryResponse> getMutableSiteSummaryResponse(String site) {
        siteSummaryDataService = RetrofitInstance.getRetrofitInstance();
        Call<SiteSummaryResponse> siteSummaryResponseCall = siteSummaryDataService.getSiteSummary(site, application.getApplicationContext().getString(R.string.key));
        siteSummaryResponseCall.enqueue(new Callback<SiteSummaryResponse>() {
            @Override
            public void onResponse(Call<SiteSummaryResponse> call, Response<SiteSummaryResponse> response) {
                mutableSiteSummaryResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SiteSummaryResponse> call, Throwable t) {

            }
        });
        return mutableSiteSummaryResponse;
    }

}
