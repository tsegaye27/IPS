package com.example.internsystemapp;

public class AppliedInternshipsLists {

    private String title;
    private String companyName;
    private String duration;
    private String location;
    private String status;

    public AppliedInternshipsLists(String title, String companyName, String location, String duration, String status) {
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.duration = duration;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
