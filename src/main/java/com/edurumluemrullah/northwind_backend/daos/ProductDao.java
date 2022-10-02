package com.edurumluemrullah.northwind_backend.daos;

import com.edurumluemrullah.northwind_backend.models.pojos.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
}
