package org.iims.model;

public class Book {
    private int id;
    private String book;
    private String author;
    private int page;
    private String genre;
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Book(){}

    public Book(String book, String author, int page, String genre, int stock){
        this.book = book;
        this.author = author;
        this.page= page;
        this.genre = genre;
        this.stock=stock;
    }
}
