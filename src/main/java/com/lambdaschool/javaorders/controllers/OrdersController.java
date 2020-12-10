package com.lambdaschool.javaorders.controllers;


import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController
{

    /**
     * The entry point for orders to access Order data
     */
    @Autowired
    OrdersService ordersService;
    // http://localhost:2019/orders/order/7
    @GetMapping(value = "/order/{ordernum}", produces = {"application/json"})
    public ResponseEntity<?> listOrderById(@PathVariable long ordernum)
    {
       Order o = ordersService.findOrdersById(ordernum);
       return new ResponseEntity<>(o, HttpStatus.OK);
    }


}
