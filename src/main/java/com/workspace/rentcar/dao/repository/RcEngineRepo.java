package com.workspace.rentcar.dao.repository;

import com.workspace.rentcar.dao.entity.RcEngine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RcEngineRepo extends CrudRepository <RcEngine, Long>{ }
