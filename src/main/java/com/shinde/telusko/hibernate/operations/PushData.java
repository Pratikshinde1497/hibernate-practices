package com.shinde.telusko.hibernate.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shinde.telusko.hibernate.HibernateConfigUtil;
import com.shinde.telusko.hibernate.models.FoodItems;
import com.shinde.telusko.hibernate.models.Laptop;
import com.shinde.telusko.hibernate.models.Student;

public class PushData {

	public static void main(String[] args) {
      /*
       * here we are pushing only a class value
       * */
		
//      FoodItems fis = new FoodItems();
//      fis.setFid(7);
//      fis.setFname("Fish curry");
//      fis.setDetails("good fresh fish: hot & spicy : full plate");
//      fis.setPrice(250);
//      fis.setQuantity(1);
//
//      SessionFactory sf = HibernateConfigUtil.getSessionFactory(FoodItems.class);
//      
//      Session session = sf.openSession();
//      
//      Transaction tx = session.beginTransaction();
//      
//      session.save(fis); 
//  
//      tx.commit();
//      
//      System.out.println("saved");
		
	/*
	 * Many to Many relation between student and laptop
	 * we have used mappedBy property of annotation Many to many in student class,
	 * if we not do this student class will also create Student_Laptop table (third)
	 * and laptop class also create laptop_student table 
	 * the problem is we are getting a table extra for ManyToMany relation. 
	 * so, its kind of necessary to use this mappedBy property
	 * 
	 * 
	 * here we havent used our util class because this example is having relation,
	 * and we need to pass two classes to the addAnnotatedClass method
	 * 
	 * */
		
	Student stud = new Student();
	stud.setRno(101);
	stud.setSname("pratik");
	stud.setMarks(89);
	
	Laptop lap = new Laptop();
	lap.setLid(5603);
	lap.setLname("lenovo");
	lap.getStudent().add(stud);				// get list and then add 
	
	stud.getLaptop().add(lap);				// same here
	
	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	session.save(lap);
	session.save(stud);
	tx.commit();
	
	}
}
