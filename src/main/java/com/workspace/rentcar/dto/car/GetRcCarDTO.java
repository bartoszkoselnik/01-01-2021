package com.workspace.rentcar.dto.car;


import com.workspace.rentcar.dao.entity.RcEngine;

public class GetRcCarDTO {

    private Long idRcCar;

    private String mark;

    private String model;

    private String color;

    private String bodyType;

    private RcEngine rcEngine;


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

    public RcEngine getRcEngine() {
        return rcEngine;
    }

    public void setRcEngine(RcEngine rcEngine) {
        this.rcEngine = rcEngine;
    }
}
