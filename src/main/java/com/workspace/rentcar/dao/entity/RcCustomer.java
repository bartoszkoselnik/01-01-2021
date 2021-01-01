package com.workspace.rentcar.dao.entity;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class RcCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_rc_customer_sequence")
    @SequenceGenerator(name = "id_rc_customer_sequence", sequenceName = "RC_CUSTOMER_SEQ1", allocationSize = 0)
    @Column(name = "ID_RC_CUSTOMER")
    private Long idRcCustomer;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Long pesel;

    @Column
    private String idCard;

    @Column
    private String address;

    @Column
    private String drivingLicence;

    @Column
    private Integer telephone;

    @Column
    private String email;

    @OneToMany(mappedBy = "rcCustomer")
    private List<RcOrder> rcOrders;

    public RcCustomer() {
    }


    public RcCustomer(Long idRcCustomer, String name, String surname, Long pesel, String idCard, String address, String drivingLicence, Integer telephone, String email, List<RcOrder> rcOrders) {
        this.idRcCustomer = idRcCustomer;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.idCard = idCard;
        this.address = address;
        this.drivingLicence = drivingLicence;
        this.telephone = telephone;
        this.email = email;
        this.rcOrders = rcOrders;
    }



    public Long getIdRcCustomer() {
        return idRcCustomer;
    }

    public void setIdRcCustomer(Long idRcCustomer) {
        this.idRcCustomer = idRcCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RcOrder> getRcOrders() {
        return rcOrders;
    }

    public void setRcOrders(List<RcOrder> rcOrders) {
        this.rcOrders = rcOrders;
    }
}
