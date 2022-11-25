package com.tutor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(1234);
		student1.setName("Fikram");
		student1.setCity("Palu");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Java");
		certificate.setDuration("2 month");		
		student1.setCerti(certificate);
		
		Student student2 = new Student();
		student2.setId(2234);
		student2.setName("Andre");
		student2.setCity("Tual");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("1.5 month");		
		student2.setCerti(certificate1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		//objects save
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		s.close();
		factory.close();
	}

}
