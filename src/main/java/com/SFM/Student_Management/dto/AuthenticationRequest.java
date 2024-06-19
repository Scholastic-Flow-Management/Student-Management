package com.SFM.Student_Management.dto;

public class AuthenticationRequest {
    private  String Email;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private  String Password;
}
