package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomersRepository;
import com.lambdaschool.javaorders.views.CustNameCountOrders;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CustomersService
{

    List<Customer> findCustomersOrders();

    Customer findCustomerById(long id);

   List<Customer> findCustomerByCustname(String name);

   List<CustNameCountOrders> getCustNameCountOrders();

}
