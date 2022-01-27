package org.iims.dao.impl;

import org.iims.dao.BookDao;
import org.iims.database.DatabaseConnect;
import org.iims.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    Connection connection;
    @Override
    public int save(Book book) throws ClassNotFoundException, SQLException {
        final String QUERY = "INSERT INTO book (Book, Author, Page, Genre, Stock) VALUES (?,?,?,?,?)";
        connection = DatabaseConnect.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, book.getBook());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setInt(3, book.getPage());
        preparedStatement.setString(4, book.getGenre());
        preparedStatement.setInt(5, book.getStock());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Book book) throws ClassNotFoundException, SQLException {
        final String QUERY = "UPDATE book set book = ?, author = ?, page = ?, genre = ?, stock=? WHERE id = ?";
        connection = DatabaseConnect.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, book.getBook());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setInt(3, book.getPage());
        preparedStatement.setString(4, book.getGenre());
        preparedStatement.setInt(5, book.getStock());
        preparedStatement.setInt(6, book.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        if(findOne(id).getStock()==0) {
            final String QUERY = "DELETE FROM book where id = ?";
            connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        }
        return 0;
    }

    @Override
    public List<Book> findAll() throws ClassNotFoundException, SQLException {
        final List<Book> books = new ArrayList<>();
        final String QUERY = "SELECT *FROM book";
        connection = DatabaseConnect.getConnection();
        ResultSet resultSet = connection.prepareStatement(QUERY).executeQuery();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("Id"));
            book.setBook(resultSet.getString("Book"));
            book.setAuthor(resultSet.getString("Author"));
            book.setPage(resultSet.getInt("Page"));
            book.setGenre(resultSet.getString("Genre"));
            book.setStock(resultSet.getInt("Stock"));
            books.add(book);
        }
        return books;
    }

    @Override
    public Book findOne(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "SELECT *FROM book where id = ?";
        connection = DatabaseConnect.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Book book = new Book();
        while (resultSet.next()) {
            book.setId(resultSet.getInt("id"));
            book.setBook(resultSet.getString("Book"));
            book.setAuthor(resultSet.getString("Author"));
            book.setPage(resultSet.getInt("Page"));
            book.setGenre(resultSet.getString("Genre"));
            book.setStock(resultSet.getInt("Stock"));
        }
        return book;
    }
}
