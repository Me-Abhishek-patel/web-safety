package com.ciberciti.gwebsafety.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.ciberciti.gwebsafety.R;
import com.ciberciti.gwebsafety.model.SiteSummaryResponse;
import com.ciberciti.gwebsafety.viewmodel.SharedViewModel;

public class ResultFragment extends Fragment {

    SharedViewModel sharedViewModel;
    TextView tvReviewedSite, tvLastChecked, tvSafetyCheck, tvReportUrl;

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvReviewedSite = getView().findViewById(R.id.tv_reviewedSite);
        tvLastChecked = getView().findViewById(R.id.tv_lastChangeTime);
        tvSafetyCheck = getView().findViewById(R.id.tv_abusiveStatus);
        tvReportUrl = getView().findViewById(R.id.tv_reportUrl);
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        sharedViewModel.getSiteSummaryResponse().observe(getViewLifecycleOwner(), new Observer<SiteSummaryResponse>() {
            @Override
            public void onChanged(SiteSummaryResponse siteSummaryResponse) {

                tvReviewedSite.setText(siteSummaryResponse.getReviewedSite());
                tvLastChecked.setText(siteSummaryResponse.getLastChangeTime());
                tvSafetyCheck.setText(siteSummaryResponse.getAbusiveStatus());
                tvReportUrl.setText(siteSummaryResponse.getReportUrl());
            }
        });
    }

}