package org.example;

public class AutomaticPaymentMachine {
    public boolean processPayment(String licensePlate, double amount, String paymentMethod) {
        System.out.println("Processing payment for " + licensePlate + ": " + amount + " using " + paymentMethod);
        return true;
    }
}
