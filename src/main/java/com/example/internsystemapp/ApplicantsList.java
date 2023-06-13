package com.example.internsystemapp;

public class ApplicantsList {

    private String fullName;

    private String email;

    private String universityName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public ApplicantsList(String fullName, String email, String universityName){
        this.fullName=fullName;
        this.email=email;
        this.universityName=universityName;
    }
}
