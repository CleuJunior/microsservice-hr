package com.microservice.course.services;

import com.microservice.course.model.Worker;
import com.microservice.course.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;

    public List<Worker> listOfWorkers() {
        return this.workerRepository.findAll();
    }

    public Worker findWorkerByID(UUID id) {
        return this.workerRepository.findById(id).orElse(null);
    }
}
