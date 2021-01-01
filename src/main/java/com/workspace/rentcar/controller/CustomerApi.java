package com.workspace.rentcar.controller;

import com.workspace.rentcar.dto.customer.CreateCustomerDTO;
import com.workspace.rentcar.dto.customer.GetByPeselRcCustomerDTO;
import com.workspace.rentcar.exception.RcCustomerNotFoundException;
import com.workspace.rentcar.service.RcCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerApi {

    private RcCustomerService rcCustomerService;

    @Autowired
    public CustomerApi(RcCustomerService rcCustomerService) {
        this.rcCustomerService = rcCustomerService;
    }

//    http://localhost:9060/api/customer?surname=STANEK&pesel=96112701500
//    @GetMapping
//    public List<GetByPeselRcCustomerDTO> checkCustomerExist(@RequestParam String surname, @RequestParam Long pesel) {
//
//        return rcCustomerService.findCustomer(surname, pesel);
//    }

//  http://localhost:9060/api/customer/STANEK/96112701500
//    @GetMapping("/{surname}/{pesel}")
//    public List<GetByPeselRcCustomerDTO> checkCustomerExist(@PathVariable String surname, @PathVariable Long pesel) {
//
//        return rcCustomerService.findCustomer(surname, pesel);
//    }

    //  http://localhost:9060/api/customer/96112701500
    @GetMapping("/{pesel}")
    public GetByPeselRcCustomerDTO getCustomerByPesel(@PathVariable Long pesel) {
        try {
            return rcCustomerService.findCustomer(pesel);
        } catch (RcCustomerNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found by PESEL: " + pesel, ex);
        }
    }
//    http://localhost:9060/api/customer/cars-rented/96112701500
    @GetMapping("/cars-rented/{pesel}")
    public List<Long> getCurrentlyRentedCarListByRcCustomerUsePesel(@PathVariable Long pesel) throws RcCustomerNotFoundException {
        return rcCustomerService.getCurrentlyRentedCar(pesel);
    }

//    http://localhost:9060/api/customer/add-customer
//    {
//        "name" : "GRZEGORZ",
//            "surname": "JESIEŃ",
//            "pesel": 77090752694,
//            "idCard": "ABJ323800",
//            "address": "DWORCOWA 3, 29-190 ZAMOŚĆ",
//            "drivingLicence": "SSP999",
//            "telephone": 500222999,
//            "email": "GRZEGORZ.JESIEN@GMAIL.COM"
//    }
    @PostMapping("/add-customer")
    public void addCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        rcCustomerService.addCustomer(createCustomerDTO);
    }
}
