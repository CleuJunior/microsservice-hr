package com.ms.hrpayroll.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private Double dailyIncome;
}
