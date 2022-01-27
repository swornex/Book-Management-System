package org.iims.controller;

import org.iims.dao.CustomerDao;
import org.iims.dao.impl.CustomerDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "view-customer-records", urlPatterns = "/view-customer-records")
public class DisplayCustomerRecords extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao customerDao = new CustomerDaoImpl();
        try {
            req.setAttribute("customers", customerDao.findAll());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("customer-record.jsp");
        requestDispatcher.forward(req, resp);
    }
}
