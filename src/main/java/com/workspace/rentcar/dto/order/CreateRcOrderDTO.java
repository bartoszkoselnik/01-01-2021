package com.workspace.rentcar.dto.order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CreateRcOrderDTO {

    private Long idRcOrder;
    private Long idRcCustomer;
    private Long idRcEmployee;
    private List<Long> idRcCars;
    private BigDecimal contractPrice;
    private LocalDate orderDate;
    private LocalDate startDate;
    private LocalDate endDate;


    public CreateRcOrderDTO() {
    }

    public CreateRcOrderDTO(Long idRcOrder, Long idRcCustomer) {
        this.idRcOrder = idRcOrder;
        this.idRcCustomer = idRcCustomer;
    }

    public CreateRcOrderDTO(Long idRcOrder) {
        this.idRcOrder = idRcOrder;
    }


    public Long getIdRcOrder() {
        return idRcOrder;
    }

    public void setIdRcOrder(Long idRcOrder) {
        this.idRcOrder = idRcOrder;
    }

    public Long getIdRcCustomer() {
        return idRcCustomer;
    }

    public void setIdRcCustomer(Long idRcCustomer) {
        this.idRcCustomer = idRcCustomer;
    }

    public Long getIdRcEmployee() {
        return idRcEmployee;
    }

    public void setIdRcEmployee(Long idRcEmployee) {
        this.idRcEmployee = idRcEmployee;
    }

    public List<Long> getIdRcCars() {
        return idRcCars;
    }

    public void setIdRcCars(List<Long> idRcCars) {
        this.idRcCars = idRcCars;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
