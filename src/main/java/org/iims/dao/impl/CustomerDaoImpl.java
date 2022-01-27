package org.iims.dao.impl;

import org.iims.dao.CustomerDao;
import org.iims.database.DatabaseConnect;
import org.iims.model.Book;
import org.iims.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    Connection connection;

    @Override
    public int save(Customer customer) throws ClassNotFoundException, SQLException{
        final String QUERY = "INSERT INTO customer (Name, Contact) VALUES (?,?)";
        connection = DatabaseConnect.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setLong(2,customer.getContact());
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Customer> findAll() throws ClassNotFoundException, SQLException{
        final List<Customer> customers = new ArrayList<>();
        final String QUERY = "SELECT *FROM customer";
        connection = DatabaseConnect.getConnection();
        ResultSet resultSet = connection.prepareStatement(QUERY).executeQuery();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("Id"));
            customer.setName(resultSet.getString("Name"));
            customer.setContact(resultSet.getLong("Contact"));
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customer findOne(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "SELECT *FROM customer where id = ?";
        connection = DatabaseConnect.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Customer customer = new Customer();
        while (resultSet.next()) {
            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("Name"));
            customer.setContact(resultSet.getLong("Contact"));
        }
        return customer;
    }
}
