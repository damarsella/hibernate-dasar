package com.tutor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Test project........." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //create student
        Student st = new Student();
        st.setId(103);
        st.setName("WAWAN GUSUNG");
        st.setCity("MASOHI");
        System.out.println(st);
        
        //creating object of address class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("JAKARTA");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        //reading image
        FileInputStream fis = new FileInputStream("src/main/java/user.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);        
        Session session = factory.openSession();        
        Transaction tx = session.beginTransaction();        
        
        session.save(st);  
        session.save(ad);
        
        tx.commit();        
        session.close();        
        System.out.println("Done.......");
        
        
    }
}
