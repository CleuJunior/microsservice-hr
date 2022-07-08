package com.microservice.course.controller;

import com.microservice.course.model.Worker;
import com.microservice.course.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/workers")
@AllArgsConstructor
public class WorkerController {

    private final WorkerRepository workerRepository;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Worker> listWorkers() {
        return this.workerRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Worker findWorkByID(@PathVariable UUID id) {
        return this.workerRepository.getById(id);
    }

}
