package com.shinde.telusko.hibernate.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.shinde.telusko.hibernate.HibernateConfigUtil;
import com.shinde.telusko.hibernate.models.FoodItems;
import com.shinde.telusko.hibernate.models.Laptop;
import com.shinde.telusko.hibernate.models.Student;

public class FetchData {

	public static void main(String[] args) {

	
//	  example: simple fetching from table
	  
//	  FoodItems fis = new FoodItems();
//	  
//	  SessionFactory sf = HibernateConfigUtil.getSessionFactory(FoodItems.class);
//	  
//	  Session session = sf.openSession();
//	  
//	  Transaction tx = session.beginTransaction();
//	  
//	  fis = session.get(FoodItems.class, 7);
//	  
//	  tx.commit();
//	  
//	  System.out.println(fis.toString()); 
//	 
	
		
		
//	  example: hibernate caching: first level and second level
	  
//	  Student l = null;
//	  
//	  Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class); 
//	  SessionFactory sf = con.buildSessionFactory(); 
//	  Session session = sf.openSession(); 
//	  l = session.get(Student.class, 101); // check for first level cache
//	  session.get(Student.class, 101); 
//	  System.out.println(l); // commit only if tx still hasn't been committed yet (by hibernate)
//	  
//	  if(session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
//		  session.getTransaction().commit(); 
//	  session.close();
//	  
//	  // second session
//	  
//	  Session session1 = sf.openSession(); 
//	  l = session1.get(Student.class, 101);
//	  System.out.println(l); 
//	  // commit only if tx still hasn't been committed yet(by hibernate)
//	  if(session1.getTransaction().getStatus().equals(TransactionStatus.ACTIVE))
//		  session1.getTransaction().commit(); session1.close();
	 

	
//	  example : query caching
	  
	  
	  Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class); 
	  SessionFactory sf = con.buildSessionFactory(); Session session = sf.openSession();
	  session.beginTransaction(); 
	  Query q = session.createQuery("from Student where rno = 101"); 
	  q.setCacheable(true); 
	  //make query result cacheable or future use
	  
	  Student l = (Student)q.uniqueResult(); 
	  System.out.println(l);
	  
	  session.getTransaction().commit(); 
	  session.close();
	  
	  
	  Session session1 = sf.openSession(); 
	  session1.beginTransaction(); 
	  Query q2 = session1.createQuery("from Student where rno = 101"); 
	  q2.setCacheable(true);
	  // make query result cacheable or future use 
	  Student l1 = (Student)q2.uniqueResult(); 
	  System.out.println(l1);
	  session1.getTransaction().commit(); 
	  session1.close();
	 

		
	}
}
