package com.anteastra.DAO;

import com.anteastra.DAOImpl.ProductDAOImpl;

public class Factory {
    
    private static ProductDAO productDAO = null;
    private static Factory instance = null;
    private static Object syncObj = new Object();

    public static Factory getInstance(){
    	  synchronized (syncObj){
    		  if (instance == null){
    			  instance = new Factory();
    		  }
    	  }
          return instance;
    }

    public ProductDAO getProductDAO(){
          if (productDAO == null){
            productDAO = new ProductDAOImpl();
          }
          return productDAO;
    }   
}