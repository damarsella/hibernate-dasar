package com.hql;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		
		System.out.println("________________________________________");
		
		Transaction tx = s.beginTransaction();
		
//		Query q2 = s.createQuery("delete from Student s where s.city=:c");
		//delete query
//		q2.setParameter("c", "Palu");		
//		int r = q2.executeUpdate();
//		System.out.println("Deleted :");
//		System.out.println(r);
		
		//update query
		Query q2 = s.createQuery("update Student set city=:c where name=:n");
		q2.setParameter("c", "Malang");
		q2.setParameter("n", "Irfan");
		int r = q2.executeUpdate();
		System.out.println(r + " objects updated");
		
		tx.commit();
		
		//bagaimana mengeksekusi join query
		Query q3 = 
				s.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answers as a");
	 	
		List<Object[]> list3 = q3.getResultList();
	 	
	 	for (Object[] arr : list3) {
	 		System.out.println(Arrays.toString(arr));
	 	}
		
		s.close();
		factory.close();
		
	}
}
