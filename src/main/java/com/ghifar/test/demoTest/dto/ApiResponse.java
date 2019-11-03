package com.ghifar.test.demoTest.dto;

public class ApiResponse {

   String gender;
   String fullname;
   String address;
   String picture;

    public ApiResponse(String gender, String fullname, String address, String picture) {
        this.gender = gender;
        this.fullname = fullname;
        this.address = address;
        this.picture = picture;
    }

    public ApiResponse() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    @Override
    public String toString() {
        return "ApiResponse{" +
                "gender='" + gender + '\'' +
                ", fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
