package org.example;

import org.example.model.Bank;
import org.example.model.Client;
import org.example.model.enums.PaymentMode;
import org.example.repository.BankRepository;
import org.example.repository.ClientRepository;
import org.example.service.DefaultDistributionService;
import org.example.service.DefaultRoutingService;
import org.example.service.DistributionService;
import org.example.service.RoutingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentGateway {
    private ClientRepository clientRepository = new ClientRepository();
    private BankRepository bankRepository = new BankRepository();
    private List<PaymentMode> paymentModes = new ArrayList<>(); //To do convert to repo

    private Map<Bank, Float> distributionMap = new HashMap<>();

    RoutingService routingService = new DefaultRoutingService();

    DistributionService distributionService = new DefaultDistributionService();

    public PaymentGateway() {
       bankRepository.addBank(new Bank("HDFC"));
       bankRepository.addBank(new Bank("ICICI"));
       bankRepository.addBank(new Bank("CITI"));
       distributionService.distribute(this);
       System.out.println("PaymentGateway created!!!");
       showDistribution();
    }

    public void addBankAndDistributionInMap(Bank bank, Float percentage){
        distributionMap.put(bank, percentage);
    }

    public Map<Bank, Float> showDistribution() {
        System.out.println("Distribution percentage is as follows");
        for(Bank b : distributionMap.keySet()) {
            System.out.println("Bank: " + b.getName() + "     Percentage:" + distributionMap.get(b));
        }
        return distributionMap;
    }


    public int addClient(String name, List<PaymentMode> paymentModes) {
        Client c = new Client(name, paymentModes);
        clientRepository.addClient(c);
        return c.getId();
    }


    public void removeClient(int client3Id) {
        clientRepository.removeClient(client3Id);

    }

    public boolean hasClient(int clientId) {
        return clientRepository.hasClient(clientId);
    }

    public List<PaymentMode> listSupportedPaymentMode() {
        System.out.println("Supported Payment Modes");
        displayPaymentModes(paymentModes);
        return paymentModes;
    }

    public List<PaymentMode> listSupportedPaymentMode(int clientId) {
        Client client = clientRepository.getClient(clientId);
        List<PaymentMode> paymentModes = new ArrayList<>(client.getPaymentModes());
        System.out.println("Supported Payment Modes for client: " + client.getName());
        displayPaymentModes(paymentModes);
        return paymentModes;
    }

    private void displayPaymentModes(List<PaymentMode> paymentModes) {

        for(PaymentMode p : paymentModes){
            System.out.println(p.toString());
        }
    }

    public void addSupportForPaymentMode(PaymentMode paymentMode) {
        paymentModes.add(paymentMode);
        System.out.println("Added support for payment gateway for payment mode:"  +  paymentMode);
    }

    public void addSupportForPaymentMode(PaymentMode paymentMode, int clientId) {
        Client client = clientRepository.getClient(clientId);
        client.addPaymentMode(paymentMode);
        System.out.println("Added support for client for payment mode:"  +  paymentMode);
    }

    public void removePaymode(PaymentMode paymentMode) {
        paymentModes.remove(paymentMode);
        System.out.println("Removed support for payment gateway for payment mode:"  +  paymentMode);

    }

    public void removePaymode(PaymentMode paymentMode, int clientId) {
        Client client = clientRepository.getClient(clientId);
        client.removePaymentMode(paymentMode);
        System.out.println("Added support for client for payment mode:"  +  paymentMode);

    }

    public List<Bank> getALlBanks() {
        return bankRepository.getAllBanks();
    }

    public void makePayment(String username, String password, double amount) {
       makeCommonPayment(PaymentMode.NET_BANKING, amount);
    }

    public void makePayment(String upi, double amount) {
        makeCommonPayment(PaymentMode.UPI, amount);
    }

    public void makeCommonPayment(PaymentMode paymentMode, double amount){
        Bank bank = routingService.getBank(this, PaymentMode.NET_BANKING);
        bank.makePayment(amount);
    }


    public void makePayment(String cardNumber, String expiry_date, String vcc, double amount) {
        makeCommonPayment(PaymentMode.CARD, amount);
    }
}
