package com.workspace.rentcar.dto.customer;

import com.workspace.rentcar.dao.entity.RcOrder;

import javax.persistence.*;
import java.util.List;

public class GetByPeselRcCustomerDTO {

    private Long idRcCustomer;
    private String name;
    private String surname;
    private Long pesel;
    private String idCard;
    private String address;
    private String drivingLicence;
    private Integer telephone;
    private String email;

    public GetByPeselRcCustomerDTO() {
    }

    public GetByPeselRcCustomerDTO(Long idRcCustomer, String name, String surname, Long pesel, String idCard, String address, String drivingLicence, Integer telephone, String email) {
        this.idRcCustomer = idRcCustomer;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.idCard = idCard;
        this.address = address;
        this.drivingLicence = drivingLicence;
        this.telephone = telephone;
        this.email = email;
    }

    public GetByPeselRcCustomerDTO(String surname, Long pesel) {
        this.surname = surname;
        this.pesel = pesel;
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

    @Override
    public String toString() {
        return "GetByPeselRcCustomerDTO{" +
                "idRcCustomer=" + idRcCustomer +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel=" + pesel +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", drivingLicence='" + drivingLicence + '\'' +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                '}';
    }
}
