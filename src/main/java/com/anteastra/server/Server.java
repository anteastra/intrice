package com.anteastra.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.SequenceInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;

import com.anteastra.DAO.Factory;
import com.anteastra.dataBase.DB;
import com.anteastra.model.Product;

public class Server {
	
	
	public static void main(String ...arg){
				
		System.out.println("Creating in-mem database");
		if (!DB.createDbInMem()){
			System.out.println("database wasn`t created");
		}			
		System.out.println("H2 database started");
		try {
			Class.forName("com.anteastra.dataBase.HibernateUtil");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Product p1 = new Product();
		Product p2 = new Product();
        
        //Проинициализируем их
        p1.setName("iron");
        p2.setName("cotton");
        
      //Сохраним их в бд, id будут сгенерированы автоматически
        try {
			Factory.getInstance().getProductDAO().addProduct(p1);
			Factory.getInstance().getProductDAO().addProduct(p2); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        List<Product> products;
		try {
			products = (List<Product>) Factory.getInstance().getProductDAO().getAllProducts();
			System.out.println("========Все продукты=========");
	        for(int i = 0; i < products.size(); ++i) {
	                System.out.println("Имя продукта : " + products.get(i).getName() + ",  id : " + products.get(i).getId());
	                System.out.println("=============================");              
	        }  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
              
	}
	
	
}
