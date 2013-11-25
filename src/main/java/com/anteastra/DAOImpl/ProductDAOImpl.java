package com.anteastra.DAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

import com.anteastra.model.Product;

import com.anteastra.DAO.ProductDAO;
import com.anteastra.dataBase.*;

public class ProductDAOImpl implements ProductDAO {
    
    public void addProduct(Product product) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(product);
                session.getTransaction().commit();
            } catch (Exception e) {
            	e.printStackTrace();                
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public void updateProduct(Product product) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(product);
                session.getTransaction().commit();
            } catch (Exception e) {
            	e.printStackTrace();  
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public Product getProductById(Long id) throws SQLException {
            Session session = null;
            Product stud = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                stud = (Product) session.load(Product.class, id);
            } catch (Exception e) {
            	e.printStackTrace();  
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return stud;
      }

      public List<Product> getAllProducts() throws SQLException {
            Session session = null;
            List<Product> studs = new ArrayList<Product>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                studs = session.createCriteria(Product.class).list();
            } catch (Exception e) {
            	e.printStackTrace();  
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return studs;
      }

      public void deleteProduct(Product product) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(product);
                session.getTransaction().commit();
            } catch (Exception e) {
            	e.printStackTrace();  
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }  
}