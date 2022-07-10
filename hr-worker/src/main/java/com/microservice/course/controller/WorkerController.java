package com.microservice.course.controller;

import com.microservice.course.dto.WorkerDTO;
import com.microservice.course.model.Worker;
import com.microservice.course.services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/workers")
@AllArgsConstructor
public class WorkerController {
    private final WorkerService workerService;

    @GetMapping("/list")
    public List<WorkerDTO> listWorkers() {
        List<Worker> listOfAllWorkers = this.workerService.listOfWorkers();

        return listOfAllWorkers.stream()
                .map(WorkerDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> findWorkByID(@PathVariable UUID id) {
        Worker workerEntity = this.workerService.findWorkerByID(id);

        if(workerEntity == null)
           return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new WorkerDTO(workerEntity));
    }

}
