package org.iims.model;

public class Customer {

    int id;
    String name;
    long contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public Customer(){}

    public Customer(String name, long contact) {
        this.name = name;
        this.contact = contact;
    }
}
