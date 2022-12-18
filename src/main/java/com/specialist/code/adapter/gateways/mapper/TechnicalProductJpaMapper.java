package com.specialist.code.adapter.gateways.mapper;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

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
