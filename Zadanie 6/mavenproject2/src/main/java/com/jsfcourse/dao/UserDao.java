package com.jsfcourse.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsfcourse.entities.User;

//DAO - Data Access Object for User entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class UserDao {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(User User) {
		em.persist(User);
	}

	public User merge(User User) {
		return em.merge(User);
	}

	public void remove(User User) {
		em.remove(em.merge(User));
	}

	public User find(Object id) {
		return em.find(User.class, id);
	}

	public List<User> getFullList() {
		List<User> list = null;

		Query query = em.createQuery("select p from User p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<User> getList(Map<String, Object> searchParams) {
		List<User> list = null;

		// 1. Build query string with parameters
		String select = "select p ";
		String from = "from User p ";
		String where = "";
		String orderby = "order by p.surname asc, p.name";

		// search for surname
		String surname = (String) searchParams.get("surname");
		if (surname != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.surname like :surname ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (surname != null) {
			query.setParameter("surname", surname+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of User objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
