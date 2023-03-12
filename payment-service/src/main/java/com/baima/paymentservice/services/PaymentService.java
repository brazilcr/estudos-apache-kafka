package com.baima.paymentservice.services;

import com.baima.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
