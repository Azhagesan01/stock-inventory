package com.azhagesan.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.azhagesan.assessment.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long>{

	List<StockEntity> findByStockNumber(@Param("stockNumber") String stockNumber);

}
