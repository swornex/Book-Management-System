package org.iims.dao;

import org.iims.model.Book;
import org.iims.model.IssueBook;

import java.sql.SQLException;
import java.util.List;

public interface IssueBookDao {
    int save(IssueBook issue) throws ClassNotFoundException, SQLException;
    List<IssueBook> findAll() throws ClassNotFoundException, SQLException;

}
