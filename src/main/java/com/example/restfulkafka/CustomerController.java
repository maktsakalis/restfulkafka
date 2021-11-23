package com.example.restfulkafka;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    @ResponseBody
    ResponseEntity<List<Customer>> gatAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @PostMapping("/add")
    @ResponseBody
    ResponseEntity<Customer> addNewCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.addNewCustomer(customerDto));
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    ResponseEntity<Customer> addNewCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id) {
        return ResponseEntity.ok(customerService.updateCustomerName(customerDto, id));
    }
}

