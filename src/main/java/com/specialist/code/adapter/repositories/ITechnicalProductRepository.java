package com.specialist.code.adapter.repositories;

import com.specialist.code.adapter.gateways.mapper.TechnicalProductJpaMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITechnicalProductRepository extends JpaRepository<TechnicalProductJpaMapper, String> {
}
