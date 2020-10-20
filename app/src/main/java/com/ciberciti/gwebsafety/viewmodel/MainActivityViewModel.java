package com.ciberciti.gwebsafety.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ciberciti.gwebsafety.model.SiteSummaryRepository;
import com.ciberciti.gwebsafety.model.SiteSummaryResponse;

public class MainActivityViewModel extends AndroidViewModel {


    private SiteSummaryRepository siteSummaryRepository;
    private String site;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        siteSummaryRepository = new SiteSummaryRepository(application);
    }

    public LiveData<SiteSummaryResponse> getSiteSummaryResponse() {
        return siteSummaryRepository.getMutableSiteSummaryResponse(getSite());
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
