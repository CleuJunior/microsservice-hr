package com.ms.hrpayroll.services;

import com.ms.hrpayroll.model.Payment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    public Payment getPayment(UUID workerId, int days) {
        return new Payment("Bob", 2000.0, days);
    }
}
