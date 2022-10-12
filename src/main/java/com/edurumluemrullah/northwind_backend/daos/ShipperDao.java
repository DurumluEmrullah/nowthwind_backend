package com.edurumluemrullah.northwind_backend.daos;

import com.edurumluemrullah.northwind_backend.models.pojos.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperDao extends JpaRepository<Shipper,Integer> {
}
