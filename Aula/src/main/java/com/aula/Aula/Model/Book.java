package com.aula.Aula.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 180)
    private String author;

    @Column(name = "Launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Launchdate;

    @Column(nullable = false, length = 100)
    private Double Price;

    @Column(nullable = false, length = 250)
    private String title;


    public Book(Long id, String author, Date launchdate, Double price, String title) {
        this.id = id;
        this.author = author;
        Launchdate = launchdate;
        Price = price;
        this.title = title;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLauncdate() {
        return Launchdate;
    }

    public void setLauncdate(Date launcdate) {
        Launchdate = launcdate;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getId(), book.getId()) && Objects.equals(author, book.author) && Objects.equals(Launchdate, book.Launchdate) && Objects.equals(Price, book.Price) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), author, Launchdate, Price, title);
    }
}
