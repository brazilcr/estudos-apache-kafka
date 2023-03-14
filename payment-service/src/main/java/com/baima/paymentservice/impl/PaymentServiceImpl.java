package com.baima.paymentservice.impl;

import com.baima.paymentservice.model.Payment;
import com.baima.paymentservice.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;
    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento {}", payment);
        Thread.sleep(1000);
        log.info("enviando pagamento ...");
        kafkaTemplate.send("payment-topic", payment);
    }
}
