package com.example.listingapp.model;


import java.io.Serializable;
import java.util.Objects;


public class UserListen implements Serializable {

    private String userName;
    private String lisdescription;

    public UserListen() {
    }

    public UserListen(String userName, String lisdescription) {
        this.userName = userName;
        this.lisdescription = lisdescription;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLisdescription() {
        return lisdescription;
    }

    public void setLisdescription(String lisdescription) {
        this.lisdescription = lisdescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserListen that = (UserListen) o;
        return Objects.equals(userName, that.userName) && Objects.equals(lisdescription, that.lisdescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, lisdescription);
    }
}
