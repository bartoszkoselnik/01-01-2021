package com.workspace.rentcar.controller;

import com.workspace.rentcar.dao.entity.RcOrder;
import com.workspace.rentcar.dto.order.CreateRcOrderDTO;
import com.workspace.rentcar.dto.order.GetRcOrderDTO;
import com.workspace.rentcar.exception.RcCarNotAvailableException;
import com.workspace.rentcar.service.RcOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    private RcOrderService rcOrderService;

    @Autowired
    public OrderApi(RcOrderService rcOrderService) {
        this.rcOrderService = rcOrderService;
    }

//  http://localhost:9040/api/orders/all
    @GetMapping("/all")
    public List<GetRcOrderDTO> getAllOrdersMapper() {
        List<GetRcOrderDTO> order = rcOrderService.getAllOrdersMapper();
        return order;
    }

//  http://localhost:9040/api/orders/2
    @GetMapping("/{index}")
    public Optional<GetRcOrderDTO> getOrderById(@PathVariable Long index) {
        Optional<GetRcOrderDTO> order = rcOrderService.getOrderByIdMapper(index);
        return order;
    }

//    http://localhost:9060/api/orders
//    {
//        "idRcCustomer": 4,
//            "idRcEmployee": 3,
//            "idRcCars": [9],
//        "contractPrice": 800.00,
//            "orderDate": "2020-12-29",
//            "startDate": "2020-12-29",
//            "endDate": "2021-01-15"
//    }
    @PostMapping("create-order")
    public void createOrder(@RequestBody CreateRcOrderDTO createRcOrderDTO) {
        try {
            rcOrderService.createOrder(createRcOrderDTO);
        } catch(RcCarNotAvailableException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car/s not available", ex);
        }
    }

    @PutMapping("update-order")
    public RcOrder updateOrder(@RequestBody RcOrder rcOrder) {
        return rcOrderService.updateOrder(rcOrder);
    }
}
