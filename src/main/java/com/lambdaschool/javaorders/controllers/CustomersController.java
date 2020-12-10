package com.lambdaschool.javaorders.controllers;


import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomersRepository;
import com.lambdaschool.javaorders.services.CustomersService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController
{

    @Autowired
    CustomersRepository customersrepos;
    @Autowired
    CustomersService customersService;

    @GetMapping(value = "/customer/{custcode}")
    public ResponseEntity<?> getCustomerById(@PathVariable long custcode)
    {
        Customer c = customersService.findCustomerById(custcode);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping(value = "/namelike/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(@PathVariable String letter)
    {
        List customers = customersService.findCustomerByCustname(letter);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> getCustomersOrders()
    {

        List ordersList = customersService.findCustomersOrders();

        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    @GetMapping(value = "/orders/count", produces = {"application/json"})
    public ResponseEntity<?> getCustomersOrdersCount()
    {

        List ordersList = customersService.getCustNameCountOrders();

        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }
}
