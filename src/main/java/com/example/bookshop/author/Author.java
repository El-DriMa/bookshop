package com.example.bookshop.author;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String shortBio;

    public Author(){}
    public Author(String firstName, String lastName, Date birthDate, String shortBio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.shortBio = shortBio;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    public String getFirstName(){ return this.firstName; }
    public void setFirstName(String firstName){this.firstName=firstName;}
    public String getLastName(){ return this.lastName; }
    public void setLastName(String lastName){this.lastName=lastName;}
    public Date getBirthDate(){ return this.birthDate; }
    public void setBirthDate(Date birthDate){this.birthDate=birthDate;}
    public String getShortBio(){ return this.shortBio; }
    public void setShortBio(String shortBio){this.shortBio=shortBio;}
}
