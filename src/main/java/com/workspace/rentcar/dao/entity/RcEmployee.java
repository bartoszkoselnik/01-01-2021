package com.workspace.rentcar.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class RcEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_rc_employee_sequence")
    @SequenceGenerator(name = "id_rc_employee_sequence", sequenceName = "RC_EMPLOYEE_SEQ1", allocationSize = 0)
    @Column(name = "ID_RC_EMPLOYEE")
    private Long idRcEmployee;

    @Column
    private String position;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Integer age;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String permissions;

    @OneToMany(mappedBy = "rcEmployee")
    private List<RcOrder> rcOrders;

    public RcEmployee() {
    }

    public RcEmployee(Long idRcEmployee, String position, String name, String surname, Integer age, String login, String password, String permissions, List<RcOrder> rcOrders) {
        this.idRcEmployee = idRcEmployee;
        this.position = position;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
        this.permissions = permissions;
        this.rcOrders = rcOrders;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public List<RcOrder> getRcOrders() {
        return rcOrders;
    }

    public void setRcOrders(List<RcOrder> rcOrders) {
        this.rcOrders = rcOrders;
    }
}
