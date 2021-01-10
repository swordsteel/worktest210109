package com.example.demo.customers;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> sortDueTimeOldToNewWithStream(List<Customer> customers) {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getDuetime))
                .collect(Collectors.toList());
    }

}