package com.example.bookshop.publisher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactEmail;
    private String countryName;
    private int yearFounded;

    public Publisher(){}
    public Publisher(Long id, String name, String contactEmail, String countryName, int yearFounded) {
        this.id = id;
        this.name = name;
        this.contactEmail = contactEmail;
        this.countryName = countryName;
        this.yearFounded = yearFounded;
    }


    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
    public String getContactEmail() {return this.contactEmail;}
    public void setContactEmail(String contactEmail) {this.contactEmail = contactEmail;}
    public String getCountryName() {return this.countryName;}
    public void setCountryName(String countryName) {this.countryName = countryName;}
    public int getYearFounded() {return this.yearFounded;}
    public void setYearFounded(int yearFounded) {this.yearFounded = yearFounded;}

}
