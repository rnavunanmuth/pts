package com.pts.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pts.pojo.Biller;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().addAnnotatedClass(Biller.class).buildSessionFactory();
		} catch (Throwable t) {
			throw new ExceptionInInitializerError(t);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
