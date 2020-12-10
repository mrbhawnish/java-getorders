package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomersRepository;
import com.lambdaschool.javaorders.views.CustNameCountOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService
{
  @Autowired
    CustomersRepository customersrepos;

  @Override
  public Customer findCustomerById(long custcode) throws EntityNotFoundException
  {
     return  customersrepos.findById(custcode)
                 .orElseThrow(() ->
                    new EntityNotFoundException("Customer " + custcode + " NOT FOUND"));
  }

  @Override
  public List<Customer> findCustomerByCustname(String custname)
      throws EntityNotFoundException
  {
    return customersrepos.findByCustnameContainingIgnoringCase(custname);
  }

  @Override
  public List<Customer> findCustomersOrders() throws
      EntityNotFoundException
  {
    List<Customer> customersList =  new ArrayList<>();
    customersrepos.findAll().iterator().forEachRemaining(customersList::add);
   return customersList;
  }

  @Override
  public List<CustNameCountOrders> getCustNameCountOrders()
  {
    return customersrepos.getCountCustOrders();
  }
}
