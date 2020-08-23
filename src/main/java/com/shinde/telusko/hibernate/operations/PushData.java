package com.shinde.telusko.hibernate.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shinde.telusko.hibernate.HibernateConfigUtil;
import com.shinde.telusko.hibernate.model.FoodItems;

public class PushData {

	public static void main(String[] args) {
      
      FoodItems fis = new FoodItems();
      fis.setFid(7);
      fis.setFname("Fish curry");
      fis.setDetails("good fresh fish: hot & spicy : full plate");
      fis.setPrice(250);
      fis.setQuantity(1);

      SessionFactory sf = HibernateConfigUtil.getSessionFactory(FoodItems.class);
      
      Session session = sf.openSession();
      
      Transaction tx = session.beginTransaction();
      
      session.save(fis); 
  
      tx.commit();
      
      System.out.println("saved");
	}
}
