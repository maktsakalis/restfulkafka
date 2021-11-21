package com.example.restfulkafka;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

//    public ResponseEntity<Customer> addNewCustomer(Customer){
//        return customerRepository.save()
//    }
}
