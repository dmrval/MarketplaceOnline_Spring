package com.epam.dmrval.learnSpring;

import java.util.Random;

/**
 * Author - Damir_Valeev
 * Created on 9/24/2019
 */
public class Client {
    String id;
    String fullname;

    public Client(String id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
