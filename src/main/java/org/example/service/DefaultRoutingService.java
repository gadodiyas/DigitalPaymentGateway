package org.example.service;

import org.example.PaymentGateway;
import org.example.model.Bank;
import org.example.model.enums.PaymentMode;

import java.util.List;

public class DefaultRoutingService implements RoutingService {

    @Override
    public Bank getBank(PaymentGateway paymentGateway, PaymentMode paymentMode) {

        List<Bank> banks = paymentGateway.getALlBanks();
        switch (paymentMode) {
            case UPI:
                return banks.get(0);
            case CARD:
                return banks.get(1);
            case NET_BANKING:
                return banks.get(2);
            default:
                return null;
        }
    }
}
