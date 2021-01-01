package com.workspace.rentcar.dao.repository;

import com.workspace.rentcar.dao.entity.RcCar;
import com.workspace.rentcar.dao.entity.RcEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RcCarRepo extends JpaRepository<RcCar, Long> {

    @Query("FROM RcCar c WHERE c.availability = false")
    List<RcCar> getAllRentCars();

    @Query("FROM RcCar c WHERE c.availability = true")
    List<RcCar> getAllAvailableCars();

    @Query("FROM RcCar e WHERE e.idRcCar IN :id")
    Set<RcCar> findRcCarById(@Param("id") List<Long> id);

    @Query("SELECT CASE WHEN count(c)>0 THEN false ELSE true END FROM RcCar c WHERE c.idRcCar IN :id AND c.availability = false")
    boolean checkStatus(@Param("id") List<Long> id);
}

