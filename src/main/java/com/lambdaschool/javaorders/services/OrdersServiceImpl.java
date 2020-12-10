package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "ordersService")
public class OrdersServiceImpl implements OrdersService
{
    @Autowired
    OrdersRepository ordersrepos;


    @Override
    public Order findOrdersById(long id) throws EntityNotFoundException
    {
        return ordersrepos.findById(id)
            .orElseThrow( () ->  new EntityNotFoundException("Order " + id + " Not found"));
    }
}
