package com.ghifar.test.demoTest.dto;

public class UserProfile {

    String title, first, last;
    String street, city;
    String picture;
    String gender;
    String streetNumber;


    public UserProfile() {
    }

    public UserProfile(String title, String first, String last, String street, String city, String picture) {
        this.title = title;
        this.first = first;
        this.last = last;
        this.street = street;
        this.city = city;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }


    @Override
    public String toString() {
        return "UserProfile{" +
                "title='" + title + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", picture='" + picture + '\'' +
                ", gender='" + gender + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }
}
