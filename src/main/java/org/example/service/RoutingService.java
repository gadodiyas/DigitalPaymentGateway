package org.example.service;

import org.example.PaymentGateway;
import org.example.model.Bank;
import org.example.model.enums.PaymentMode;

public interface RoutingService {
    Bank getBank(PaymentGateway paymentGateway, PaymentMode netBanking);
}
