package com.workspace.rentcar.controller;

import com.workspace.rentcar.dao.entity.RcCar;
import com.workspace.rentcar.dto.car.GetRcCarDTO;
import com.workspace.rentcar.dto.car.ReturnCarRcCarDTO;
import com.workspace.rentcar.service.RcCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarApi {

    private RcCarService rcCarService;

    @Autowired
    public CarApi(RcCarService rcCar) {
        this.rcCarService = rcCar;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<GetRcCarDTO> getAllMapper() {
        List<GetRcCarDTO> car = rcCarService.getAllCarsMapper();
        return car;
    }

    @GetMapping("/get-all-rent-cars")
    public List<GetRcCarDTO> getAllRentCar() {
        List<GetRcCarDTO> cars = rcCarService.getAllRentCarsMapper();
        return cars;
    }

    @GetMapping("/get-all-available-cars")
    public List<GetRcCarDTO> getAllAvailableCars() {
        List<GetRcCarDTO> availableCars = rcCarService.getAllAvailableCarsMapper();
        return availableCars;
    }

//    http://localhost:9060/api/cars?index=2
    @GetMapping
    public Optional<GetRcCarDTO> getById(@RequestParam Long index) {
        Optional<GetRcCarDTO> carDTO = rcCarService.getCarsByIdMapper(index);
        return carDTO;
    }

//    http://localhost:9060/api/cars/add-car
//    {
//        "mark": "SEAT",
//            "model": "CUPRA",
//            "color": "BLACK",
//            "bodyType": "Heatchback",
//            "milAge": 200100,
//            "productionDate": "2005-11-12",
//            "vin": "XXD393879",
//            "availability": true,
//            "rcEngine": {
//        "serialNumber": "DHDG737",
//                "fuelType": "DIESEL",
//                "capacity": 2.9,
//                "power": 150,
//                "turbine": "T",
//                "gearbox": "Manual",
//                "typeOfDrive": "FWD"
//    }
//    }
    @PostMapping("add-car")
    public void addCar(@RequestBody RcCar rcCar) {
        rcCarService.save(rcCar);
    }


//    http://localhost:9060/api/cars/update-car
//    {
//        "idRcCar": 12,
//            "mark": "SEAT",
//            "model": "CUPRA",
//            "color": "BLACK",
//            "bodyType": "Heatchback",
//            "milAge": 200100,
//            "productionDate": "2005-11-12",
//            "vin": "XXD393880",
//            "availability": true,
//            "rcEngine": {
//        "idRcEngine": 12,
//                "serialNumber": "DHDG780",
//                "fuelType": "DIESEL",
//                "capacity": 2.9,
//                "power": 150,
//                "turbine": "T",
//                "gearbox": "Manual",
//                "typeOfDrive": "FWD"
//    }
//    }
    @PutMapping("update-car")
    public void updateCar(@RequestBody RcCar rcCar) {
        rcCarService.updateCar(rcCar);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long index) {
        rcCarService.deleteById(index);
    }


//    http://localhost:9060/api/cars/return
//    {
//        "idsOfReturnCars": [6,2,3],
//        "finalPrice": "2000.50",
//            "returnDate": "2020-12-29"
//    }
    @PostMapping("return")
    public void returnCar(@RequestBody ReturnCarRcCarDTO returnCarRcCarDTO) {
        rcCarService.returnCar(returnCarRcCarDTO);
    }
}
