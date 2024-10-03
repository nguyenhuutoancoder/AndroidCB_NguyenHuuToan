package com.example.mycontacts;

import java.io.Serializable;

public class MyContact implements Serializable {
    int imageId;
    String name;
    String phone;



    public MyContact(int imageId, String name, String phone) {
        this.imageId = imageId;
        this.name = name;
        this.phone = phone;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
