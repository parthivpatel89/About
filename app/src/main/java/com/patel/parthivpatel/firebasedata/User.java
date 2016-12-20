package com.patel.parthivpatel.firebasedata;

/**
 * Created by SNET1 on 15-Dec-16.
 */
import com.google.firebase.database.IgnoreExtraProperties;
public class User {

    public String name;
    public String email;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}