package com.edurumluemrullah.northwind_backend.daos;

import com.edurumluemrullah.northwind_backend.models.pojos.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail,Integer> {
}
