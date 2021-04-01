package com.ciberciti.gwebsafety.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    private String site;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

//    public LiveData<SiteSummaryResponse> getSiteSummaryResponse() {
//        return siteSummaryRepository.getMutableSiteSummaryResponse(getHost());
//    }


    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
