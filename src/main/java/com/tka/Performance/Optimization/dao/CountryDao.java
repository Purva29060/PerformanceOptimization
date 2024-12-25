package com.tka.Performance.Optimization.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Performance.Optimization.entity.Country;
import com.tka.Performance.Optimization.entity.Employee;

@Repository
public class CountryDao {

	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		session.persist(c);
		tx.commit();
		msg="Country Added Successfully...";
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String updateCountry(Country c, int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Country country=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		country=session.get(Country.class, id);
		country.setCname(c.getCname());
		session.merge(country);
		
		tx.commit();
		msg="Country Updated Successfully...";
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String deleteCountry(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Country country=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		country=session.get(Country.class, id);
		session.remove(country);
		tx.commit();
		msg="Country Deleted Successfully...";
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public List<Country> getAllCountry() {
		
		Session session=null;
		Transaction tx=null;
		List<Country> list=null;
		String hqlQuery="from Country";
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		Query<Country> query=session.createQuery(hqlQuery,Country.class);
		list=query.list();
		tx.commit();
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		
		return list;
	}

	public Country getParticularCountryById(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Country country=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		country=session.get(Country.class, id);
		
		tx.commit();
		
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		
		return country;
	}

	
	}
	
	
	
	

	

