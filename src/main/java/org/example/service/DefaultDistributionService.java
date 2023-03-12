package org.example.service;

import org.example.PaymentGateway;
import org.example.model.Bank;

import java.util.List;

public class DefaultDistributionService implements DistributionService {

    public void distribute(PaymentGateway paymentGateway) {
        List<Bank> banks = paymentGateway.getALlBanks();
        Float factor = 100f/banks.size();
        for(Bank b : banks) {
            paymentGateway.addBankAndDistributionInMap(b, factor);
        }
    }
}
