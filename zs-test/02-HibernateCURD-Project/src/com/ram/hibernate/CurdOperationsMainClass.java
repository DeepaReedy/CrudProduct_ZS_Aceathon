package com.ram.hibernate;
//import org.hibernate.cfg.*;
//import org.hibernate.*;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class CurdOperationsMainClass {
	private SessionFactory factory;

	public void create(Product pro){
		System.out.println("About to create Products");;

		Session session = null;
		Transaction tx = null;

			try {
				session = factory.openSession();
				       System.out.println("here is the session object created " + session);
				      tx=session.beginTransaction();
				    session.save(pro);
				tx.commit();
				System.out.println("Products Created with empno: " + pro.getProductnumber());
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				tx.rollback();
				System.out.println("exception while creating products " + e);
				 e.printStackTrace();
			}
			finally{
				session.close();
			}
	}

	public Product load(int empno){
		Session session = null;
		Transaction tx = null;

		  try {
			session = factory.openSession();
			Product pro = (Product) session.load(Product.class, new Integer(empno));

			  return pro;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
	       System.out.println("Product not found");
	       e.printStackTrace();
	       return null;
		}finally{
			session.close();
		} 
	}

	public void update(Product pro){
		Session session = null;
		Transaction tx = null;

		 try {
			session = factory.openSession();
			 tx = session.beginTransaction();
			 
			 pro.setProductname("Laptop");// Laptop product name is updated(because session is not closed)
			 session.update(pro);
			 tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("exception while updating the object");
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void remove(Product pro){

		Session session = null;
		Transaction tx = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.delete(pro);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while removing the object");
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public static void main(String arr[]) throws Exception{
		CurdOperationsMainClass test = new CurdOperationsMainClass();
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		test.factory = cfg.buildSessionFactory();
		
		Product pro1 = new Product();
		
		
		pro1.setProductname("Laptop");
		pro1.setImgurl("laptop image");
		pro1.setDetails("SSD I5 CORE GENERATION ");
		pro1.setPrice(60000.00);
		
		test.create(pro1);
		
		
		
		Product pro2 = new Product();
		
		pro2.setProductname("HP");
		pro2.setImgurl("Dell image");
		pro2.setDetails("SSD I10TH CORE GENERATION ");
		pro2.setPrice(75000.00);
		
		test.create(pro2);

		Product emp = test.load(1);
		
		emp = test.load(2);
		if(emp!=null){
			System.out.println("Product name: " + emp.getProductname());
			System.out.println("Product Image url: " + emp.getImgurl());
			System.out.println("Product Price: " + emp.getPrice());
			System.out.println("Product Details: " + emp.getDetails());
		}
		
		
	}

}
