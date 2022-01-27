package org.iims.model;

public class IssueBook {
    int customerId;
    int bookId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public IssueBook(){}

    public IssueBook(int bookId, int customerId){
        this.bookId= bookId;
        this.customerId = customerId;
    }
}
