package com.example.demo.customers;

import java.util.List;

public interface CustomerService {

    List<Customer> sortDueTimeOldToNewWithStream(List<Customer> customers);

}
