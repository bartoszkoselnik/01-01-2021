package com.workspace.rentcar.dao.repository;

import com.workspace.rentcar.dao.entity.RcCustomer;
import com.workspace.rentcar.dto.customer.GetByPeselRcCustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RcCustomerRepo extends JpaRepository<RcCustomer, Long> {

        @Query(value = "Select new com.workspace.rentcar.dto.customer.GetByPeselRcCustomerDTO " +
                "(c.idRcCustomer, c.name, c.surname, c.pesel, c.idCard, c.address, c.drivingLicence, c.telephone, c.email) " +
                "FROM RcCustomer c WHERE c.pesel = :pesel")
        GetByPeselRcCustomerDTO getCustomerByPesel(@Param("pesel") Long pesel);


        @Query("SELECT CASE WHEN count(c)>0 THEN true ELSE false END FROM RcCustomer c WHERE c.pesel = :pesel")
        boolean checkCustomerExistInDB(@Param("pesel") Long pesel);

        @Query("FROM RcCustomer c WHERE c.idRcCustomer = :id")
        RcCustomer findCustomerById(@Param("id") Long id);
}
