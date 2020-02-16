package com.example.admin_rakshak;

public class patrolingVehicles {

    private String Name;
    private boolean Status;
    private  double Latitude;
    private  double Longitude;

    public patrolingVehicles(String name, boolean status, double latitude, double longitude) {
        Name = name;
        Status = status;
        Latitude = latitude;
        Longitude = longitude;
    }
    public patrolingVehicles() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
