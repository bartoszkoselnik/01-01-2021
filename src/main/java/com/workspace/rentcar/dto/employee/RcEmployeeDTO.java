package com.workspace.rentcar.dto.employee;

import com.workspace.rentcar.dao.entity.RcOrder;

import java.util.List;

public class RcEmployeeDTO {

    private Long idRcEmployee;
    private String position;
    private String name;
    private String surname;

//    private List<GetRcOrderDTO> rcOrders;



    public Long getIdRcEmployee() {
        return idRcEmployee;
    }

    public void setIdRcEmployee(Long idRcEmployee) {
        this.idRcEmployee = idRcEmployee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
}
