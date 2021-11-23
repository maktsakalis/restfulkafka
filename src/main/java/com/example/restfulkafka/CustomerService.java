package com.example.restfulkafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ObjectMapper objectMapper;

    public CustomerService(CustomerRepository customerRepository, ObjectMapper objectMapper) {
        this.customerRepository = customerRepository;
        this.objectMapper = objectMapper;
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addNewCustomer(CustomerDto customerDto) {
        Customer customer = objectMapper.convertValue(customerDto, Customer.class);
        return customerRepository.save(customer);
    }

    public Customer updateCustomerName(CustomerDto newCustomerDto, Long id) {

        return customerRepository.findById(id).map(customer -> {
            customer.setFirstName(newCustomerDto.getFirstName());
            customer.setLastName(newCustomerDto.getLastName());
            return customerRepository.save(customer);
        }).orElseGet(() -> {
            Customer newCustomer = objectMapper.convertValue(newCustomerDto, Customer.class);
            return customerRepository.save(newCustomer);
        });
    }

}
