package com.ciberciti.gwebsafety.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.ciberciti.gwebsafety.model.SiteSummaryRepository;
import com.ciberciti.gwebsafety.model.SiteSummaryResponse;

import java.net.MalformedURLException;
import java.net.URL;

public class SharedViewModel extends AndroidViewModel {

    private final SiteSummaryRepository siteSummaryRepository;
    private String site;
    private String host;

    public SharedViewModel(@NonNull Application application) {
        super(application);
        siteSummaryRepository = new SiteSummaryRepository(application);
    }

    public LiveData<SiteSummaryResponse> getSiteSummaryResponse() {
        return siteSummaryRepository.getMutableSiteSummaryResponse(getHost());
    }

    public String getHost() {
        return host;
    }

    public void setHost() {
        if (getSite() != null) {
            try {
                URL aURL = new URL(getSite());
                host = aURL.getHost() + "";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        this.host = host;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
