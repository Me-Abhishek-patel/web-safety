package com.ciberciti.gwebsafety.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiteSummaryResponse {

    @SerializedName("reviewedSite")
    @Expose
    private String reviewedSite;
    @SerializedName("lastChangeTime")
    @Expose
    private String lastChangeTime;
    @SerializedName("abusiveStatus")
    @Expose
    private String abusiveStatus;
    @SerializedName("reportUrl")
    @Expose
    private String reportUrl;
    @SerializedName("filterStatus")
    @Expose
    private String filterStatus;

    public String getReviewedSite() {
        return reviewedSite;
    }

    public void setReviewedSite(String reviewedSite) {
        this.reviewedSite = reviewedSite;
    }

    public String getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(String lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public String getAbusiveStatus() {
        return abusiveStatus;
    }

    public void setAbusiveStatus(String abusiveStatus) {
        this.abusiveStatus = abusiveStatus;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getFilterStatus() {
        return filterStatus;
    }

    public void setFilterStatus(String filterStatus) {
        this.filterStatus = filterStatus;
    }

}