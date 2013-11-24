package com.anteastra.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Product")
public class Product {
	private Long id;    
    private String name;
    
    public Product(){
        name = null;
    }
    
    public Product(Product s){
        name = s.getName();
    }   
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Long getId() {
        return id;
    }
    
    @Column(name="name")
    public String getName(){
        return name;
    }
        
    
    public void setId(Long i){
        id = i;     
    }
    
    public void setName(String s){
        name = s;
    }    
}
