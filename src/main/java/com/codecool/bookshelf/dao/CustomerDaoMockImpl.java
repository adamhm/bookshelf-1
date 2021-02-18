package com.codecool.bookshelf.dao;

import com.codecool.bookshelf.MyMockDatabase;
import com.codecool.bookshelf.model.books.Book;
import com.codecool.bookshelf.model.feedback.Opinion;
import com.codecool.bookshelf.model.user.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerDaoMockImpl implements CustomerDAO {
    MyMockDatabase database;
    
    CustomerDaoMockImpl(MyMockDatabase database) {
        this.database = database;
    }
    
    @Override
    public Optional<Customer> findById(long id) {
        return database.getCustomerList().stream()
            .filter(customer -> customer.getId() == id)
            .findFirst();
    }
    
    @Override
    public long addCustomer(Customer customer) {
        return 0;
    }
    
    @Override
    public Optional<Opinion> findOpinionOfBook(long customerId, long bookId) {
        Optional<Customer> customer = findById(customerId);
    
        return customer.flatMap(value -> value.getOpinions().stream()
            .filter(op -> op.getBookId() == bookId)
            .findFirst());
    
    }
    
    @Override
    public Customer findCustomerByCustomerNameAndEmail(String name, String email) {
        return null;
    }
    
    @Override
    public void updateCustomer(Customer customer) {
        Optional<Customer> existingCustomer = findById(customer.getId());
        
        existingCustomer.ifPresentOrElse(
            existing -> {
                int i = database.getCustomerList().indexOf(existing);
                database.getCustomerList().set(i, customer);
            },
            () -> {throw new IllegalArgumentException();}
        );
    }
}
