package com.pagination;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tutor.Student;

public class HQLPagination {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Query query = s.createQuery("from Student");
		
		// implementasi pagination menggunakan hibernate
		
		query.setFirstResult(5);
		query.setMaxResults(6);
		
		List<Student> list = query.list();
		
		for(Student st : list) {
			System.out.println(st.getId() + " : " + st.getName() + " : " + st.getCity());
		}
		
		
		s.close();
		factory.close();
		
	}
	
}
