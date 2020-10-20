package com.ciberciti.gwebsafety.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ciberciti.gwebsafety.R;
import com.ciberciti.gwebsafety.model.SiteSummaryResponse;
import com.ciberciti.gwebsafety.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    LiveData<SiteSummaryResponse> siteSummaryResponseLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        querySite();
    }

    private void querySite() {

        mainActivityViewModel.setSite("0123movies.org");
        siteSummaryResponseLiveData = mainActivityViewModel.getSiteSummaryResponse();
        mainActivityViewModel.getSiteSummaryResponse().observe(this, new Observer<SiteSummaryResponse>() {
            @Override
            public void onChanged(SiteSummaryResponse siteSummaryResponse) {
                //use siteSummary data here


            }
        });

    }
}