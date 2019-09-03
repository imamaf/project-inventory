package com.inventory.users.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.users.exception.ResourceNotFoundException;
import com.inventory.users.model.Customer;
import com.inventory.users.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1")
public class CustomerController{
    @Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customer")
	public List<Customer> getACustomer() {
		return customerRepository.findAll();
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
		return ResponseEntity.ok().body(customer);
	}

    @PostMapping("/customer")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
		@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
		.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

		customer.setNamaLengkap(customerDetails.getNamaLengkap());
		customer.setEmail(customerDetails.getEmail());
        customer.setNoTelepon(customerDetails.getNoTelepon());
        customer.setPassword(customerDetails.getPassword());
        customer.setKonfirmPassword(customerDetails.getKonfirmPassword());
		final Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customer/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
		throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
		.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}