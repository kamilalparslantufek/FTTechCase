package com.patikacase.firstcase.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product{

    public Product(){
        new Comment();

    }
    public Product(String id, String name, Double price, @Nullable Date expirationDate){
        this.Id = id;
        this.Name = name;
        this.Price = price;
        this.ExpirationDate = expirationDate;
        new Comment();
    }
    public Product(String id, String name, Double price){
        this.Id = id;
        this.Name = name;
        this.Price = price;
        new Comment();
    }
    @Id
    @Column(name = "Id", updatable = false,nullable = false, columnDefinition = "VARCHAR(36)", length = 36)
    private String Id;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Price")
    private Double Price;
    @Nullable
    @Column(name = "ExpirationDate", nullable = true)
    private Date ExpirationDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ProductId")
    @JsonIgnore
    private List<Comment> Comments;

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Double getPrice() {
        return Price;
    }
    public void setPrice(Double price) {
        Price = price;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public Date getExpirationDate() {
        return ExpirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        ExpirationDate = expirationDate;
    }
    public List<Comment> getComments() {
        return Comments;
    }


}
