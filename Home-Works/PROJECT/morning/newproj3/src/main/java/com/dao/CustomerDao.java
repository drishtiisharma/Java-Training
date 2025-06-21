package com.dao;

import com.pojo.Customer;

public interface CustomerDao{
    // Update customer details (for profile editing)
    boolean updateCustomer(Customer customer);
    
    // Optional: Fetch customer by email (useful for pre-filling edit forms)
    Customer getCustomerByEmail(String email);
}