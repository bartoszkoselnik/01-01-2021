package com.workspace.rentcar.service;


import com.workspace.rentcar.dao.entity.RcCustomer;
import com.workspace.rentcar.dao.entity.RcOrder;
import com.workspace.rentcar.dao.repository.RcCustomerRepo;
import com.workspace.rentcar.dto.customer.CreateCustomerDTO;
import com.workspace.rentcar.dto.customer.GetByPeselRcCustomerDTO;
import com.workspace.rentcar.dto.order.GetRcOrderDTO;
import com.workspace.rentcar.exception.RcCustomerNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RcCustomerService {

    private RcCustomerRepo rcCustomerRepo;
    @Autowired
    private RcOrderService rcOrderService;

    @Autowired
    public RcCustomerService(RcCustomerRepo rcCustomerRepo) {
        this.rcCustomerRepo = rcCustomerRepo;
    }

    public GetByPeselRcCustomerDTO findCustomer(Long pesel) throws RcCustomerNotFoundException{
            if (checkCustomerExistInDB(pesel)) {
                return rcCustomerRepo.getCustomerByPesel(pesel);
            } else
                throw new RcCustomerNotFoundException("Customer by PESEL number not found");
    }

    public boolean checkCustomerExistInDB(Long pesel) {
        return rcCustomerRepo.checkCustomerExistInDB(pesel);
    }

    @Transactional
    public RcCustomer getRcCustomerById(Long id) {
        return rcCustomerRepo.findCustomerById(id);
    }

    public List<Long> getCurrentlyRentedCar(Long pesel) throws RcCustomerNotFoundException {

        GetByPeselRcCustomerDTO getByPeselRcCustomerDTO = findCustomer(pesel);
        Long idRcCustomer = getByPeselRcCustomerDTO.getIdRcCustomer();
        Long idRcOrder = rcOrderService.getCustomerActiveOrder(idRcCustomer);
        List<Long> ids = rcOrderService.getCustomerRentedCars(idRcOrder);
        return ids;
    }

    public void addCustomer(CreateCustomerDTO createCustomerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        RcCustomer rcCustomer =  modelMapper.map(createCustomerDTO, RcCustomer.class);
        rcCustomerRepo.save(rcCustomer);
    }
}
