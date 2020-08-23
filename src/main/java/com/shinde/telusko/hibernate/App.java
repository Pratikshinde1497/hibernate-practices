/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shinde.telusko.hibernate;

import com.shinde.telusko.hibernate.operations.FetchData;
import com.shinde.telusko.hibernate.operations.PushData;

/**
 *
 * @author pratik
 */
public class App {
    
    public static void main(String[] args) {
        System.out.println("com.shinde.telusko.hibernate.App.main()");
        System.out.println("Hello world!");

        PushData.main(args);
        FetchData.main(args);
        
    }
}
