package com.specialist.code.adapter.gateways.mapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "CommonProduct")
@Data
@AllArgsConstructor
public class CommonProductJpaMapper {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private long createdAt;
}
