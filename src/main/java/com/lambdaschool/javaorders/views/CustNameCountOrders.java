package com.lambdaschool.javaorders.views;

public interface CustNameCountOrders
{
    String getCustname();  //  should match the custname in our custom query on customerRepository
    int getCount_orders();
}
