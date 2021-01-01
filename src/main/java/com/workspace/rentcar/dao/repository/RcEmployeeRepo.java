package com.workspace.rentcar.dao.repository;

import com.workspace.rentcar.dao.entity.RcEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RcEmployeeRepo extends JpaRepository<RcEmployee, Long> {

    @Query("FROM RcEmployee e WHERE e.idRcEmployee = :id")
    RcEmployee findEmployeeById(@Param("id") Long idRcEmployee);
}
