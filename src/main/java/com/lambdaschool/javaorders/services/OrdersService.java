package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;

public interface OrdersService
{
    /**
     * Returns the order with the given primary key.
     *
     * @param id The primary key (long) of the order you seek.
     * @return The given order or throws an exception if not found.
     */
    Order findOrdersById(long id);
}
