package com.richardlucasapps.compoundcomponents;

public class ContactInfo {

    private int picture; //int because it will be referencing an id from the R file.
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String homeAddress;
    private String homeCity;
    private String homeState;
    private String homeZipCode;

    public ContactInfo(int picture, String firstName, String lastName, String phoneNumber, String emailAddress,
                       String address, String city, String state, String zipCode) {
        this.picture = picture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.homeAddress = address;
        this.homeCity = city;
        this.homeState = state;
        this.homeZipCode = zipCode;
    }

    public int getPicture() {
        return picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public String getHomeZipCode() {
        return homeZipCode;
    }
}
