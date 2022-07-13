package com.ms.hrpayroll.services;

import com.ms.hrpayroll.feingclients.WorkerFeignClient;
import com.ms.hrpayroll.model.Payment;
import com.ms.hrpayroll.model.Worker;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    private final WorkerFeignClient workerFeignClient;

    public PaymentService(final WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }
    public Payment getPayment(UUID workerId, int days) {
        Worker worker = this.workerFeignClient.findWorkByID(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}

