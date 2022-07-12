package com.ms.hrpayroll.services;

import com.ms.hrpayroll.model.Payment;
import com.ms.hrpayroll.model.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String host;
    private final RestTemplate restTemplate;

    public PaymentService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Payment getPayment(UUID workerId, int days) {
        Map<String, UUID> uriVariables = new HashMap<>();

        uriVariables.put("id", workerId);
        Worker worker = this.restTemplate.getForObject(this.host + "/api/workers/{id}", Worker.class, uriVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}

