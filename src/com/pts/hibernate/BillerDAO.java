package com.pts.hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pts.exception.BillerNotFoundException;
import com.pts.pojo.Biller;
import com.pts.util.HibernateUtil;

public class BillerDAO {
	
	/*
	 * this method does not require transaction as there is no associated object with this object
	 */
	public Biller createBiller(String billerName) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Biller biller = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			biller = new Biller();
			biller.setName(billerName);
			biller.setId((Integer) session.save(biller));
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
			throw he;
		} finally {
			session.close();
		}
		return biller;
	}
	
	public Biller getBiller(int billerId) throws BillerNotFoundException {
		SessionFactory sessionFactory = null;
		Session session = null;
		Biller biller = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			biller = (Biller) session.get(Biller.class, billerId);
			if (biller == null) {
				throw new BillerNotFoundException();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		return biller;
	}
	
	public Biller updateBiller(int billerId, String billerName) throws BillerNotFoundException {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Biller biller = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			biller = (Biller) session.get(Biller.class, billerId);
			if (biller == null) {
				throw new BillerNotFoundException();
			}
			biller.setName(billerName);
			session.update(biller);
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return biller;
	}
	
	public boolean deleteBiller(int billerId) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Biller biller = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			biller = (Biller) session.get(Biller.class, billerId);
			if (biller == null) {
				return true;
			}
			session.delete(biller);
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return true;
	}
	
}