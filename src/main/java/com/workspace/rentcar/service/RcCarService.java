package com.workspace.rentcar.service;

import com.sun.istack.NotNull;
import com.workspace.rentcar.dao.repository.RcCarRepo;
import com.workspace.rentcar.dao.entity.RcCar;
import com.workspace.rentcar.dto.car.GetRcCarDTO;
import com.workspace.rentcar.dto.car.GetStatusRcCarDTO;
import com.workspace.rentcar.dto.car.ReturnCarRcCarDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RcCarService {
    @Autowired
    private ModelMapper modelMapper;

    private RcCarRepo rcCarRepo;
    @Autowired
    private RcOrderService rcOrderService;

    @Autowired
    public RcCarService(RcCarRepo rcCarRepo) {
        this.rcCarRepo = rcCarRepo;
    }


    public Iterable<RcCar> findAll() {
        return rcCarRepo.findAll();
    }

    public Optional<RcCar> findById(Long id) {
        return rcCarRepo.findById(id);
    }

    public Optional<GetRcCarDTO> getCarsByIdMapper(Long id) {
        return ((Optional<RcCar>) rcCarRepo.findById(id)).map(this::convertToRcCarDTO);
    }

    @Transactional
    public Set<RcCar> getRcCarById(List<Long> id) {
        return rcCarRepo.findRcCarById(id);
    }

    @Transactional(rollbackFor = { RuntimeException.class, Error.class})
    public RcCar save(RcCar rcCar) {
        return rcCarRepo.save(rcCar);
    }

    @Transactional(rollbackFor = { RuntimeException.class, Error.class, DataAccessException.class })
    public RcCar updateCar(RcCar rcCar) {
        return rcCarRepo.save(rcCar);
    }

    @Transactional
    public void updateCarStatus(Set<RcCar> rcCar) {
        for(RcCar item : rcCar) {
             item.setAvailability(false);
        }
        rcCarRepo.saveAll(rcCar);
    }

    public void deleteById(Long id) {
        rcCarRepo.deleteById(id);
    }

    public List<GetRcCarDTO> getAllCarsMapper() {
        return ((List<RcCar>) rcCarRepo.findAll()).stream().map(this::convertToRcCarDTO).collect(Collectors.toList());
    }

    public List<GetRcCarDTO> getAllRentCarsMapper() {
        return ((List<RcCar>) rcCarRepo.getAllRentCars()).stream().map(this::convertToRcCarDTO).collect(Collectors.toList());
    }

    public List<GetRcCarDTO> getAllAvailableCarsMapper() {
        return ((List<RcCar>) rcCarRepo.getAllAvailableCars()).stream().map(this::convertToRcCarDTO).collect(Collectors.toList());
    }

    private GetRcCarDTO convertToRcCarDTO(RcCar rcCar) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        GetRcCarDTO getRcCarDTO = modelMapper.map(rcCar, GetRcCarDTO.class);
        return getRcCarDTO;
    }


    public boolean checkCarStatus(List<Long> idRcCars) {
        return rcCarRepo.checkStatus(idRcCars);
    }

    @Transactional
    public void returnCar(ReturnCarRcCarDTO returnCarRcCarDTO) {

       Set<RcCar> carList = rcCarRepo.findRcCarById(returnCarRcCarDTO.getIdsOfReturnCars());
       for(RcCar rcCar: carList) {
           rcCar.setAvailability(true);
       }
       rcCarRepo.saveAll(carList);
       rcOrderService.setFinalOrderPriceAndReturnDate(returnCarRcCarDTO);
    }
}
