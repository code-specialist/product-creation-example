package com.specialist.code.adapter.repositories;

import com.specialist.code.adapter.gateways.mapper.CommonProductJpaMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommonProductRepository extends JpaRepository<CommonProductJpaMapper, String> {
}
