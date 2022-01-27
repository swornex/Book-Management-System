package org.iims.controller;

import org.iims.dao.BookDao;
import org.iims.dao.CustomerDao;
import org.iims.dao.IssueBookDao;
import org.iims.dao.impl.BookDaoImpl;
import org.iims.dao.impl.CustomerDaoImpl;
import org.iims.dao.impl.IssueBookDaoImpl;
import org.iims.model.Book;
import org.iims.model.Customer;
import org.iims.model.IssueBook;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="issue-form", urlPatterns = "/issue-form")
public class BookIssued extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        req.setAttribute("bookId", id) ;
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("issued.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result= 0;
        BookDao bookDao = new BookDaoImpl();
        CustomerDao customerDao = new CustomerDaoImpl();

        int bookId = Integer.parseInt(req.getParameter("book-Id"));
        int customerId = Integer.parseInt(req.getParameter("customer-Id"));
        IssueBook issue = new IssueBook(bookId, customerId);
        IssueBookDao issueBookDao = new IssueBookDaoImpl();
        try {
            if(bookId == bookDao.findOne(bookId).getId() && customerId == customerDao.findOne(customerId).getId()){
                result= issueBookDao.save(issue);
                if(result>0){
                    Book book = bookDao.findOne(bookId);
                    int newStock = book.getStock()-1;
                    book.setStock(newStock);
                    result = bookDao.update(book);
                }
            }

      //      System.out.println(result);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
      //  if (result > 0) {
            resp.sendRedirect("view-issued-book");
      //  }
    }
}
