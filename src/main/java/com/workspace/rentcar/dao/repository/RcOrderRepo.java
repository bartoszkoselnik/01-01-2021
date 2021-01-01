package com.workspace.rentcar.dao.repository;

import com.workspace.rentcar.dao.entity.RcCar;
import com.workspace.rentcar.dao.entity.RcOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RcOrderRepo extends JpaRepository<RcOrder, Long> {


//    @Query(value = "insert into RC_ORDER (id_Rc_Customer) VALUES (:idRcCustomer)", nativeQuery = true)
//    RcOrder createOrder(@Param("idRcCustomer") Long idRcCustomer);


    @Query(value = "SELECT id_rc_order FROM rc_order r WHERE r.return_date is NULL AND r.id_rc_customer = :id", nativeQuery = true)
    Long getActiveCustomerOrder(@Param("id") Long idRcCustomer);


//    @Query(value = "SELECT DISTINCT c.idRcCar FROM RcCar c JOIN c.rcOrders cr WHERE cr.idRcOrder = :id AND cr.finalPrice = 1001")
    @Query(value = "SELECT DISTINCT c.idRcCar FROM RcCar c JOIN c.rcOrders cr WHERE cr.idRcOrder = :id")
    List<Long> getCustomerRentedCars(@Param("id") Long idRcOrder);

    @Query("FROM RcOrder r JOIN r.idRcCars ro WHERE ro.idRcCar = :id")
    RcOrder getOrder(@Param("id") Optional<Long> id);

}
