package com.workspace.rentcar.dto.order;

import com.workspace.rentcar.dto.car.GetRcCarDTO;
import com.workspace.rentcar.dto.customer.GetByPeselRcCustomerDTO;
import com.workspace.rentcar.dto.employee.RcEmployeeDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class GetRcOrderDTO {
    private Long idRcOrder;
    private RcEmployeeDTO rcEmployee;
    private GetByPeselRcCustomerDTO rcCustomer;
    private BigDecimal finalPrice;
    private BigDecimal contractPrice;
    private LocalDate orderDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate returnDate;
    private Set<GetRcCarDTO> idRcCars;

    public Long getIdRcOrder() {
        return idRcOrder;
    }

    public void setIdRcOrder(Long idRcOrder) {
        this.idRcOrder = idRcOrder;
    }

    public RcEmployeeDTO getRcEmployee() {
        return rcEmployee;
    }

    public void setRcEmployee(RcEmployeeDTO rcEmployee) {
        this.rcEmployee = rcEmployee;
    }

    public GetByPeselRcCustomerDTO getRcCustomer() {
        return rcCustomer;
    }

    public void setRcCustomer(GetByPeselRcCustomerDTO rcCustomer) {
        this.rcCustomer = rcCustomer;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Set<GetRcCarDTO> getIdRcCars() {
        return idRcCars;
    }

    public void setIdRcCars(Set<GetRcCarDTO> idRcCars) {
        this.idRcCars = idRcCars;
    }
}
