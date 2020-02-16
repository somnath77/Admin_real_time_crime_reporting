package com.example.admin_rakshak;

public class reportBlog {
    private String type,desc;
    private boolean status,makePublicStatus;
    private double latitude,longitude;
    private long contact;


    public reportBlog(String type, String desc, boolean status, boolean makePublicStatus, double latitude, double longitude, long contact) {
        this.type = type;
        this.desc = desc;
        this.status = status;
        this.makePublicStatus = makePublicStatus;
        this.latitude = latitude;
        this.longitude = longitude;
        this.contact = contact;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public reportBlog(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isMakePublicStatus() {
        return makePublicStatus;
    }

    public void setMakePublicStatus(boolean makePublicStatus) {
        this.makePublicStatus = makePublicStatus;
    }
}
