package com.workspace.rentcar.service;

import com.workspace.rentcar.dao.entity.RcCar;
import com.workspace.rentcar.dao.entity.RcCustomer;
import com.workspace.rentcar.dao.entity.RcEmployee;
import com.workspace.rentcar.dao.repository.RcOrderRepo;
import com.workspace.rentcar.dao.entity.RcOrder;
import com.workspace.rentcar.dto.car.ReturnCarRcCarDTO;
import com.workspace.rentcar.dto.order.CreateRcOrderDTO;
import com.workspace.rentcar.dto.order.GetRcOrderDTO;
import com.workspace.rentcar.exception.RcCarNotAvailableException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RcOrderService {

    private RcOrderRepo rcOrderRepo;
    @Autowired
    private RcCarService rcCarService;
    @Autowired
    private RcCustomerService rcCustomerService;
    @Autowired
    private RcEmployeeService rcEmployeeService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public RcOrderService(RcOrderRepo rcOrderRepo) {
        this.rcOrderRepo = rcOrderRepo;
    }

    public Iterable<RcOrder> getAll() {
        return rcOrderRepo.findAll();
    }

    public Optional<RcOrder> findById(Long id) {
        return rcOrderRepo.findById(id);
    }

    public RcOrder updateOrder(RcOrder rcOrder) {
        return  rcOrderRepo.save(rcOrder);
    }

    public Optional<GetRcOrderDTO> getOrderByIdMapper(Long id) {
        return ((Optional<RcOrder>) rcOrderRepo.findById(id)).map(this::convertToRcOrderDTO);
    }

    public List<GetRcOrderDTO> getAllOrdersMapper() {
        return ((List<RcOrder>) rcOrderRepo.findAll()).stream().map(this::convertToRcOrderDTO)
                .collect(Collectors.toList());
    }

    private GetRcOrderDTO convertToRcOrderDTO(RcOrder rcOrder) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        GetRcOrderDTO getRcOrderDTO = modelMapper.map(rcOrder, GetRcOrderDTO.class);
        return getRcOrderDTO;
    }

    @Transactional
    public RcOrder createOrder(CreateRcOrderDTO createRcOrderDTO) throws RcCarNotAvailableException {

        if (checkStatus(createRcOrderDTO.getIdRcCars())) {
                ModelMapper modelMapper1 = new ModelMapper();
                RcOrder rcOrder = modelMapper.map(createRcOrderDTO, RcOrder.class);

                RcCustomer rcCustomer = rcCustomerService.getRcCustomerById(createRcOrderDTO.getIdRcCustomer());
                rcOrder.setRcCustomer(rcCustomer);

                RcEmployee rcEmployee = rcEmployeeService.getRcEmployeeById(createRcOrderDTO.getIdRcEmployee());
                rcOrder.setRcEmployee(rcEmployee);

                Set<RcCar> rcCar = rcCarService.getRcCarById(createRcOrderDTO.getIdRcCars());
                rcOrder.setIdRcCars(rcCar);

                rcCarService.updateCarStatus(rcCar);

                return rcOrderRepo.save(rcOrder);
        } else throw new RcCarNotAvailableException("Car is not available");
    }

    @Transactional
    public boolean checkStatus(List<Long> idRcCars) {
        return rcCarService.checkCarStatus(idRcCars);
    }

    public Long getCustomerActiveOrder(Long idRcCustomer) {
        return rcOrderRepo.getActiveCustomerOrder(idRcCustomer);
    }

    public List<Long> getCustomerRentedCars(Long idRcOrder) {

        return rcOrderRepo.getCustomerRentedCars(idRcOrder);
    }

    @Transactional
    public void setFinalOrderPriceAndReturnDate(ReturnCarRcCarDTO returnCarRcCarDTO) {
        List<Long> carIds = returnCarRcCarDTO.getIdsOfReturnCars();
        Optional<Long> carId = carIds.stream().findFirst();
        RcOrder rcOrder = rcOrderRepo.getOrder(carId);
        rcOrder.setFinalPrice(returnCarRcCarDTO.getFinalPrice());
        rcOrder.setReturnDate(returnCarRcCarDTO.getReturnDate());
        rcOrderRepo.save(rcOrder);
    }
}

