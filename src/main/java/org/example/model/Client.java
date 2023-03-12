package org.example.model;

import org.example.model.enums.PaymentMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Client {
    private static int cnt = 0;
    private int id;
    private String name;

    private Set<PaymentMode> paymentModes = new HashSet<>();

    public Client(String name, List<PaymentMode> paymentModes) {
        id = ++cnt;
        this.name = name;
        this.paymentModes.addAll(paymentModes);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<PaymentMode> getPaymentModes() {
        return paymentModes;
    }

    public void addPaymentMode(PaymentMode paymentMode){
        paymentModes.add(paymentMode);
    }

    public void removePaymentMode(PaymentMode paymentMode){
        paymentModes.remove(paymentMode);
    }


}
