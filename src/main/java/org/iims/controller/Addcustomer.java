package org.iims.controller;

import org.iims.dao.CustomerDao;
import org.iims.dao.impl.CustomerDaoImpl;
import org.iims.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="add-customer", urlPatterns = "/add-customer")
public class Addcustomer extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("customer-form.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result= 0;
        String customerName = req.getParameter("customer-name");
        long contact = Long.parseLong(req.getParameter("contact"));
        Customer customer = new Customer(customerName, contact);
        CustomerDao customerDao = new CustomerDaoImpl();
        try {
            result= customerDao.save(customer);
            System.out.println(result);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if (result > 0) {
            resp.sendRedirect("view-customer-records");
        }
    }
}
