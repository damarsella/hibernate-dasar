package com.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tutor.Student;

public class HQLExample {	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		//HQL
		//Syntax :
		//
//		String query = "from Student";
//		String query = "from Student where city='Tegal'";
//		String query = "from Student where city=:x";
		
		String query = "from Student as s where s.city=:x and s.name=:n";
		
		Query q = s.createQuery(query);
		
		q.setParameter("x", "Tegal");
		q.setParameter("n", "Irfan");
		
		// single - (unique)
		//multiple-list
		
		List<Student> list = q.list();
		
		for (Student student : list) {
			System.out.println(student.getName()+" : "+student.getCerti().getCourse());
		}
		
		
		s.close();
		factory.close();
		
	}
}
