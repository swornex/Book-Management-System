package org.iims.controller;

import org.iims.dao.BookDao;
import org.iims.dao.impl.BookDaoImpl;
import org.iims.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Books-Form", urlPatterns = "/books-form")
public class AddAndUpdateBooks extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            req.setAttribute("action", "Update");
        } else {
            req.setAttribute("action", "Save");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Books-form.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String id= req.getParameter("id");
        if(id != null){

        }else{
            int result=0;
            String bookName = req.getParameter("book-name");
            String author = req.getParameter("author");
            int page = Integer.parseInt(req.getParameter("page"));
            String genre= req.getParameter("genre");
            int stock = Integer.parseInt(req.getParameter("stock"));
            Book book= new Book(bookName, author, page, genre, stock);
            BookDao bookDao= new BookDaoImpl();
            try {
                result = bookDao.save(book);
                System.out.println(result);
                if(result > 0){
                    resp.sendRedirect("/BookManagementSystem");
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
