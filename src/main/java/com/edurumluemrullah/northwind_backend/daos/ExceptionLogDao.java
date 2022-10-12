package com.edurumluemrullah.northwind_backend.daos;

import com.edurumluemrullah.northwind_backend.models.pojos.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExceptionLogDao extends JpaRepository<ExceptionLog,Integer> {

    Optional<ExceptionLog> findByLogId(int logId);
}
