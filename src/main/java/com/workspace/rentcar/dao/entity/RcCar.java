package com.workspace.rentcar.dao.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class RcCar {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_sequence_car")
    @SequenceGenerator(name = "id_sequence_car", sequenceName = "RC_CAR_SEQ1", allocationSize = 0)
    @Column(name = "ID_RC_CAR")
    private Long idRcCar;

    @Column
    private String mark;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private String bodyType;

    @Column
    private Integer milAge;

    @Column
    private LocalDate productionDate;

    @Column
    private String vin;

    @Column
    private Boolean availability;

    @ManyToMany(mappedBy = "idRcCars")
    private Set<RcOrder> rcOrders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RC_ENGINE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idRcEngineToRcCar")
    @SequenceGenerator(name = "idRcEngineToRcCar", sequenceName = "RC_CAR_TO_RC_ENGINE_SEQ1", allocationSize = 0)
    private RcEngine rcEngine;

    public RcCar() {
    }

    public RcCar(Long idRcCar, String mark, String model, String color, String bodyType, Integer milAge, LocalDate productionDate, String vin, Boolean availability, RcEngine rcEngine) {
        this.idRcCar = idRcCar;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.bodyType = bodyType;
        this.milAge = milAge;
        this.productionDate = productionDate;
        this.vin = vin;
        this.availability = availability;
        this.rcEngine = rcEngine;
        this.rcOrders = new HashSet<>();
    }

    //    public RcCar(String mark, String model, String color, String bodyType, Integer milAge, Date productionDate, RcEngine rcEngine) {
//        this.mark = mark;
//        this.model = model;
//        this.color = color;
//        this.bodyType = bodyType;
//        this.milAge = milAge;
//        this.productionDate = productionDate;
//        this.rcEngine = rcEngine;
//    }


    public Long getIdRcCar() {
        return idRcCar;
    }

    public void setIdRcCar(Long idRcCar) {
        this.idRcCar = idRcCar;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Integer getMilAge() {
        return milAge;
    }

    public void setMilAge(Integer milAge) {
        this.milAge = milAge;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public RcEngine getRcEngine() {
        return rcEngine;
    }

    public void setRcEngine(RcEngine rcEngine) {
        this.rcEngine = rcEngine;
    }

    public Set<RcOrder> getRcOrders() {
        return rcOrders;
    }

    public void setRcOrders(Set<RcOrder> rcOrders) {
        this.rcOrders = rcOrders;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "RcCar{" +
                "idRcCar=" + idRcCar +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", milAge=" + milAge +
                ", productionDate=" + productionDate +
                ", vin='" + vin + '\'' +
                ", availability=" + availability +
                ", rcEngine=" + rcEngine +
                '}';
    }
}
