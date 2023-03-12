package org.example.repository;

import org.example.exception.BankNotFoundException;
import org.example.exception.ClientNotFoundException;
import org.example.model.Bank;
import org.example.model.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRepository {
    private Map<Integer, Bank> banks = new HashMap<>();

    public Bank getBank(int id) {
        Bank bank = banks.get(id);
        if(bank == null)
            throw new BankNotFoundException();
        return bank;
    }

    public void addBank(Bank bank){
        banks.put(bank.getId(), bank);
    }

    public List<Bank> getAllBanks() {
        return new ArrayList<>(banks.values());
    }
}
