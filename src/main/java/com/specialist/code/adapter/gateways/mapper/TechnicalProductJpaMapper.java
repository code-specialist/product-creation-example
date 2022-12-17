package com.specialist.code.adapter.gateways.mapper;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TechnicalProduct")
@Data
@AllArgsConstructor
public class TechnicalProductJpaMapper {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private long createdAt;
    private String technicalInformation;
    private String instructionManual;
}
