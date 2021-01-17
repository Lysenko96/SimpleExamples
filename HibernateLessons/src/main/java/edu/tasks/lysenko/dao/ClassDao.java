package edu.tasks.lysenko.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class ClassDao {

	public List<Object> getList(Session session, Class className) {
		session.get(className, 1);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = builder.createQuery(className);
		Root<Object> root = criteriaQuery.from(className);
		criteriaQuery.select(root);
		Query query = session.createQuery(criteriaQuery);
		List<Object> objects = query.getResultList();
		return objects;
	}
}
