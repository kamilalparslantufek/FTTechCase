package com.patikacase.firstcase.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "User")
public class User {

    public User(){

    }
    public User(String Id,String Name, String Surname, String Email, String Phone){
        this.setId(Id);
        this.setName(Name);
        this.setSurname(Surname);
        this.setEmail(Email);
        this.setPhone(Phone);
    }
    @javax.persistence.Id
    @Column(name = "Id", updatable = false,nullable = false, columnDefinition = "VARCHAR(36)", length = 36)
    private String Id;
    @Column(name = "Name", nullable = false, length = 50)
    private String Name;
    @Column(name = "Surname", nullable = false, length = 50)
    private String Surname;
    @Column(name = "Email", nullable = false, length = 50)
    private String Email;
    @Column(name = "Phone", nullable = false, length = 15)
    private String Phone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "UserId")
    @JsonIgnore
    private List<Comment> Comments;



    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getSurname() {
        return Surname;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public List<Comment> getComments() {
        return Comments;
    }
}