package com.javatpoint.model;

import jakarta.persistence.*;


//defining class name as Table name

@Entity
public class Books {
    //Defining book id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
  private Long  id;
    @Column
    private String bookname;
    @Column
    private String author;
    @Column
    private int price;


    public String getBookname()
    {
        return bookname;
    }
    public void setBookname(String bookname)
    {
        this.bookname = bookname;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
