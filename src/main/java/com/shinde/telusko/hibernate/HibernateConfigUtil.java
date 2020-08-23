package com.shinde.telusko.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shinde.telusko.hibernate.model.FoodItems;

public class HibernateConfigUtil {
	
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory(Class<FoodItems> class1) {

		if(sf == null) {
			Configuration conf = new Configuration()
	                .configure()
	                .addAnnotatedClass(class1);
	    
			sf = conf.buildSessionFactory();

			return sf;
		}
		return sf;
	}
}
