package com.workspace.rentcar.service;

import com.workspace.rentcar.dao.entity.RcEmployee;
import com.workspace.rentcar.dao.repository.RcEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RcEmployeeService {

    private RcEmployeeRepo rcEmployeeRepo;

    @Autowired
    public RcEmployeeService(RcEmployeeRepo rcEmployeeRepo) {
        this.rcEmployeeRepo = rcEmployeeRepo;
    }

    @Transactional
    public RcEmployee getRcEmployeeById(Long idRcEmployee) {
        return rcEmployeeRepo.findEmployeeById(idRcEmployee);
    }
}
