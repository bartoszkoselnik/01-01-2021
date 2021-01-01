package com.workspace.rentcar.dto.customer;

import javax.persistence.*;

public class CreateCustomerDTO {

    private String name;
    private String surname;
    private Long pesel;
    private String idCard;
    private String address;
    private String drivingLicence;
    private Integer telephone;
    private String email;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getPesel() {
        return pesel;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getAddress() {
        return address;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
