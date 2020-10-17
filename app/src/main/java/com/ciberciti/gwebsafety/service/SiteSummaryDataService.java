package com.ciberciti.gwebsafety.service;

import com.ciberciti.gwebsafety.model.SiteSummaryResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SiteSummaryDataService {

    @GET("sites/{site}")
    SiteSummaryResponse getSiteSummary(@Path("site") String site, @Query("key") String key);
}
