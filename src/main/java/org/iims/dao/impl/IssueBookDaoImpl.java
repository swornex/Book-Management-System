package org.iims.dao.impl;

import org.iims.dao.IssueBookDao;
import org.iims.database.DatabaseConnect;
import org.iims.model.Customer;
import org.iims.model.IssueBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IssueBookDaoImpl implements IssueBookDao {
    Connection connection;

    @Override
    public int save(IssueBook issue) throws ClassNotFoundException, SQLException{
        final String QUERY = "INSERT INTO issuebook (Book_Id, Customer_Id) VALUES (?,?)";
        connection = DatabaseConnect.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, issue.getBookId());
        preparedStatement.setInt(2,issue.getCustomerId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<IssueBook> findAll() throws ClassNotFoundException, SQLException{
        final List<IssueBook> issues = new ArrayList<>();
        final String QUERY = "SELECT *FROM issuebook";
        connection = DatabaseConnect.getConnection();
        ResultSet resultSet = connection.prepareStatement(QUERY).executeQuery();
        while (resultSet.next()) {
            IssueBook issue = new IssueBook();
            issue.setBookId(resultSet.getInt("Book_Id"));
            issue.setCustomerId(resultSet.getInt("Customer_Id"));
            issues.add(issue);
        }
        return issues;
    }
}
