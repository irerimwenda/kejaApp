package com.example.ireribrian.apartments;

/**
 * Created by ireribrian on 9/6/2018.
 */

public class Rating {

    private String email;
    private String massionateId;
    private String rateValue;
    private String commment;

    public Rating() {
    }

    public Rating(String email, String massionateId, String rateValue, String commment) {
        this.email = email;
        this.massionateId = massionateId;
        this.rateValue = rateValue;
        this.commment = commment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMassionateId() {
        return massionateId;
    }

    public void setMassionateId(String massionateId) {
        this.massionateId = massionateId;
    }

    public String getRateValue() {
        return rateValue;
    }

    public void setRateValue(String rateValue) {
        this.rateValue = rateValue;
    }

    public String getCommment() {
        return commment;
    }

    public void setCommment(String commment) {
        this.commment = commment;
    }
}
