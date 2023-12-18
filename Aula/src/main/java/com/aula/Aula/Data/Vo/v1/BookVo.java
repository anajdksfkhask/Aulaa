package com.aula.Aula.Data.Vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@JsonPropertyOrder({"key","author","Launchdate", "Price", "title"})
public class BookVo extends RepresentationModel<BookVo> implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("id")
    private Long key;

    @Column(nullable = false, length = 180)
    private String author;

    @Column(name = "Launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Launchdate;

    @Column(nullable = false, length = 100)
    private Double Price;

    @Column(nullable = false, length = 250)
    private String title;


    public BookVo(Long id, String author, Date launchdate, Double price, String title) {
        this.key = id;
        this.author = author;
        Launchdate = launchdate;
        Price = price;
        this.title = title;
    }
    public BookVo() {
    }
    public Long getKey() {
        return key;
    }
    public void setKey(Long id) {
        this.key = id;
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
        if (!(o instanceof BookVo book)) return false;
        return Objects.equals(key, book.key) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(Launchdate, book.Launchdate) && Objects.equals(getPrice(), book.getPrice()) && Objects.equals(getTitle(), book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, getAuthor(), Launchdate, getPrice(), getTitle());
    }
}