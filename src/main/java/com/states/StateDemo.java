package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tutor.Certificate;
import com.tutor.Student;

public class StateDemo {
	
	public static void main(String[] args) {
		
		// Praktik States Object Hibernate
		// Transient
		// Persistent
		// Detached
		// Removed
		
		System.out.println("Contoh : ");
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		// Menabahkan object Student
		Student student =  new Student();
		student.setId(1414);
		student.setName("Dimas");
		student.setCity("ABCD");
		student.setCerti(new Certificate("Kursus Java Hibernate", "2 month"));
		//student : Transient
		
		Session s = f.openSession();	
		Transaction tx = s.beginTransaction();
		s.save(student);
		// Student : Persistent - session, data		
		
		student.setName("Irfan");		
		
		tx.commit();
		
		s.close();
		// Student detached
		student.setName("Zaky");
		System.out.println(student);
		
		f.close();
		
	}	
	

}
