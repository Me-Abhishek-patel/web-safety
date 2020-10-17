package com.ciberciti.gwebsafety.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static final String BASE_URL = "https://abusiveexperiencereport.googleapis.com/v1/";
    private static Retrofit retrofit = null;

    public static SiteSummaryDataService getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(SiteSummaryDataService.class);
    }
}
