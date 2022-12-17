package com.specialist.code.adapter.gateways.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
