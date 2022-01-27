package org.iims.controller;

import org.iims.dao.BookDao;
import org.iims.dao.impl.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="delete-book", urlPatterns="/delete-book")
public class DeleteBooks extends HttpServlet {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id= req.getParameter("id");
            try {
                if(id != null) {
                    bookDao.delete(Integer.parseInt(id));
                    req.setAttribute("books", bookDao.findAll());
                }
                resp.sendRedirect("./");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
    }
}
