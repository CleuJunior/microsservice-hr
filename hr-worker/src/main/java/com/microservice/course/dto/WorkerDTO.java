package com.microservice.course.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservice.course.model.Worker;
import lombok.Data;

import java.util.UUID;

@Data
public class WorkerDTO {

    @JsonProperty("_id")
    private UUID id;
    private String name;
    private Double dailyIncome;

    public WorkerDTO(Worker worker) {
        this.id = worker.getId();
        this.name = worker.getName();
        this.dailyIncome = worker.getDailyIncome();
    }

}
