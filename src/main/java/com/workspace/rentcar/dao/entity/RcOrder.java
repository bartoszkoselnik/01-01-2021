package com.workspace.rentcar.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class RcOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_rc_order_sequence")
    @SequenceGenerator(name = "id_rc_order_sequence", sequenceName = "RC_ORDER_SEQ1", allocationSize = 0)
    @Column(name = "ID_RC_ORDER")
    private Long idRcOrder;

    @JoinColumn(name = "ID_RC_CUSTOMER")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private RcCustomer rcCustomer;

    @JoinColumn(name = "ID_RC_EMPLOYEE")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private RcEmployee rcEmployee;

    @Column
    private BigDecimal contractPrice;

    @Column
    private BigDecimal finalPrice;

    @Column
    private LocalDate orderDate;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private LocalDate returnDate;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "RC_ORDER_RC_CAR", joinColumns = @JoinColumn(name = "ID_RC_ORDER"), inverseJoinColumns = @JoinColumn(name = "ID_RC_CAR"))
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_order_car")
    @SequenceGenerator(name = "id_sequence_order_car", sequenceName = "RC_ORDER_TO_RC_CAR_SEQ1",allocationSize = 0)
    private Set<RcCar> idRcCars;


    private RcOrder() {
    }

    public RcOrder(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public RcOrder(Long idRcOrder) {
        this.idRcOrder = idRcOrder;
    }

    public RcOrder(Long idRcOrder, RcCustomer rcCustomer, RcEmployee rcEmployee, BigDecimal contractPrice, BigDecimal finalPrice, LocalDate orderDate, LocalDate startDate, LocalDate endDate, LocalDate returnDate, Set<RcCar> idRcCars) {
        this.idRcOrder = idRcOrder;
        this.rcCustomer = rcCustomer;
        this.rcEmployee = rcEmployee;
        this.contractPrice = contractPrice;
        this.finalPrice = finalPrice;
        this.orderDate = orderDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.idRcCars = idRcCars;
    }



    public Long getIdRcOrder() {
        return idRcOrder;
    }

    public void setIdRcOrder(Long idRcOrder) {
        this.idRcOrder = idRcOrder;
    }

    public RcCustomer getRcCustomer() {
        return rcCustomer;
    }

    public void setRcCustomer(RcCustomer rcCustomer) {
        this.rcCustomer = rcCustomer;
    }

    public void setIdRcCustomer(RcCustomer rcCustomer) {
        this.rcCustomer = rcCustomer;
    }

    public RcEmployee getRcEmployee() {
        return rcEmployee;
    }

    public void setRcEmployee(RcEmployee rcEmployee) {
        this.rcEmployee = rcEmployee;
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

    public Set<RcCar> getIdRcCars(List<RcCar> rcCar) {
        return idRcCars;
    }

    public void setIdRcCars(Set<RcCar> idRcCars) {
        this.idRcCars = idRcCars;
    }

    @Override
    public String toString() {
        return "RcOrder{" +
                "idRcOrder=" + idRcOrder +
                ", rcCustomer=" + rcCustomer +
                ", rcEmployee=" + rcEmployee +
                ", contractPrice=" + contractPrice +
                ", finalPrice=" + finalPrice +
                ", orderDate=" + orderDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", returnDate=" + returnDate +
                ", idRcCars=" + idRcCars +
                '}';
    }
}