package com.example.admin_rakshak;

public class upload_post {
    private String ImageUrl;
    private String Description;

    public upload_post() {
    }
    public upload_post(String imageUrl, String description) {
        if(description.trim().equals("")){
            description="";
        }

        ImageUrl = imageUrl;
        Description = description;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
