package com.edurumluemrullah.northwind_backend.daos;

import com.edurumluemrullah.northwind_backend.models.pojos.Territory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritoryDao extends JpaRepository<Territory,String > {
}
