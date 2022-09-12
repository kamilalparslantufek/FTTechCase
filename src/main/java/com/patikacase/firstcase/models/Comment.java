package com.patikacase.firstcase.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table( name = "Product.Comment")
public class Comment {

    public Comment(){
    }

    public Comment(String id, java.util.Date date, String comment, String UserId, String ProductId){
        setComment(comment);
        setId(id);
        setDate(date);
        setUserId(UserId);
        setProductId(ProductId);
    }
    @javax.persistence.Id
    @Column(name = "Id", updatable = false,nullable = false, columnDefinition = "VARCHAR(36)", length = 36)
    private String Id;
    @Column(name = "Date", nullable = false)
    private Date Date;
    @Column(name = "Comment", nullable = false, length = 500)
    private String Comment;
    @Column(name = "UserId", nullable = false, columnDefinition = "VARCHAR(36)",length = 36)
    private String UserId;
    @Column(name = "ProductId", nullable = false, columnDefinition = "VARCHAR(36)", length = 36)
    private String ProductId;


    public String getComment() {
        return Comment;
    }
    public void setComment(String comment) {
        Comment = comment;
    }
    public String getUserId() {
        return UserId;
    }
    public void setUserId(String userId) {
        UserId = userId;
    }
    public String getProductId() {
        return ProductId;
    }
    public void setProductId(String productId) {
        ProductId = productId;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public java.util.Date getDate() {
        return Date;
    }
    public void setDate(java.util.Date date) {
        Date = date;
    }
}