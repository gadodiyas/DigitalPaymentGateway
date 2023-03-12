package org.example;

import org.example.model.enums.PaymentMode;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PaymentGateway pg = new PaymentGateway();
        pg.addSupportForPaymentMode(PaymentMode.UPI);
        pg.addSupportForPaymentMode(PaymentMode.CARD);
        pg.addSupportForPaymentMode(PaymentMode.NET_BANKING);

        List<PaymentMode> paymentModes = pg.listSupportedPaymentMode();

        int client1Id = pg.addClient("Flipkart", Arrays.asList(PaymentMode.UPI, PaymentMode.CARD));
        int client2Id = pg.addClient("Amazon", Arrays.asList(PaymentMode.NET_BANKING, PaymentMode.CARD));
        int client3Id = pg.addClient("Snapdeal", Arrays.asList(PaymentMode.CARD));

        pg.removeClient(client3Id);

        pg.hasClient(client3Id);
        pg.hasClient(client2Id);



        List<PaymentMode> paymentModes1 = pg.listSupportedPaymentMode(client1Id);
        pg.addSupportForPaymentMode(PaymentMode.NET_BANKING, client1Id);
        pg.listSupportedPaymentMode(client1Id);

        pg.removePaymode(PaymentMode.CARD);
        pg.listSupportedPaymentMode();
        pg.removePaymode(PaymentMode.NET_BANKING, client1Id);
        pg.listSupportedPaymentMode(client1Id);

        pg.showDistribution();
        pg.makePayment("username", "password", 100);
        pg.makePayment("upi", 100);
        pg.makePayment("cardNumber", "expiry date", "vcc",  100);

    }
}