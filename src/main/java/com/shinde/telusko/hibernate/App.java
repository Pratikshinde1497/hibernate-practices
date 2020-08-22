/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shinde.telusko.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author pratik
 */
public class App {
    
    public static void main(String[] args) {
        System.out.println("com.shinde.telusko.hibernate.App.main()");
        System.out.println("Hello world!");
        
        FoodItems fis = new FoodItems();
        fis.setFid(2);
        fis.setFname("burger-veg");
        fis.setDetails("cheesy burger with lots of meonees and kechup");
        fis.setPrice(90);
        fis.setQuantity(1);
        
//        System.out.println(fis.toString());

        Configuration conf = new Configuration()
                    .configure()
                    .addAnnotatedClass(FoodItems.class);
        
        SessionFactory sf = conf.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(fis); 
    
        tx.commit();
    }
}
