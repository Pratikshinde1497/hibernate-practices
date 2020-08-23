package com.shinde.telusko.hibernate.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shinde.telusko.hibernate.HibernateConfigUtil;
import com.shinde.telusko.hibernate.model.FoodItems;

public class FetchData {

	public static void main(String[] args) {
		
		FoodItems fis = new FoodItems();
		
		SessionFactory sf = HibernateConfigUtil.getSessionFactory(FoodItems.class);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		fis = session.get(FoodItems.class, 7);
		
		tx.commit();
		
		System.out.println(fis.toString());
		
		
	}
}
