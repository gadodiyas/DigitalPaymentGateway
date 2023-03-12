package org.example.model;

import org.example.model.enums.PaymentMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private static int cnt = 0;
    private int id;
    private String name;


    public Bank(String name) {
        id = ++cnt;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    //change logic to return true or false alternatively
    public boolean makePayment(double amount) {
        return true;
    }
}
