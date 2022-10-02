package com.edurumluemrullah.northwind_backend.daos;

import com.edurumluemrullah.northwind_backend.models.pojos.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category,Integer> {
}
