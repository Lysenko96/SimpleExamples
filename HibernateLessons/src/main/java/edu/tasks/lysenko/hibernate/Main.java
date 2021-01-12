package edu.tasks.lysenko.hibernate;

import org.hibernate.Session;

import edu.tasks.lysenko.dao.CarDao;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(session);
		System.out.println(new CarDao().getCars());
	}
}
