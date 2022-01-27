package org.iims.dao;


import org.iims.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    int save(Customer customer) throws ClassNotFoundException, SQLException;

    List<Customer> findAll() throws ClassNotFoundException, SQLException;

    public Customer findOne(int id) throws ClassNotFoundException, SQLException;
}
