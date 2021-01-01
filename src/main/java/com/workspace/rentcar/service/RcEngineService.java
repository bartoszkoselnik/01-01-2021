package com.workspace.rentcar.service;

import com.workspace.rentcar.dao.entity.RcEngine;
import com.workspace.rentcar.dao.repository.RcEngineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RcEngineService {

    private RcEngineRepo rcEngineRepo;

    @Autowired
    public RcEngineService(RcEngineRepo rcEngineRepo) {
        this.rcEngineRepo = rcEngineRepo;
    }


    public RcEngine save(RcEngine rcEngine) {
        return rcEngineRepo.save(rcEngine);
    }
}
