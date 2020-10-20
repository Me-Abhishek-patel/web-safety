package com.ciberciti.gwebsafety.service;


import com.ciberciti.gwebsafety.model.SiteSummaryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SiteSummaryDataService {

    @GET("sites/{site}")
    Call<SiteSummaryResponse> getSiteSummary(@Path("site") String site, @Query("key") String key);
}
