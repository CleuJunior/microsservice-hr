package com.microservice.course.repositories;

import com.microservice.course.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> {

    @Query("select c from Worker c where c.id = :id")
    Optional<Worker> findByUUID(UUID id);

}
