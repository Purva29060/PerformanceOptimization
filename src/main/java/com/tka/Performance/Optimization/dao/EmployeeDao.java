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
public class EmployeeDao {

	@Autowired
	SessionFactory factory;
	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg="Employee Added Successfully...";
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
	public String updateEmployee(Employee emp, long id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employee employee = null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			employee=session.get(Employee.class, id);
			employee.setName(emp.getName());
			employee.setEmailid(emp.getEmailid());
			session.merge(employee);
			
			tx.commit();
			msg="Employee Updated Successfully...";
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
	public String deleteEmployee(long id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Employee employee=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		employee=session.get(Employee.class, id);
		session.remove(employee);
		tx.commit();
		msg="Employee Deleted Successfully...";
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
	public List<Employee> getAllEmployee() {
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee";
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
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
	public Employee getParticularEmployeeById(long id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Employee employee=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		employee=session.get(Employee.class, id);
		
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
		
		return employee;
	}
//	public Employee login(Employee emp) {
//		Session session=null;
//		Transaction tx=null;
//		Employee employee=null;
//		String hqlQuery="from Employee where emailid=:emailid and mobileno=:mobileno";
//		try {
//			session=factory.openSession();
//			tx=session.beginTransaction();
//			
//			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
////			query.setParameter("emailid", emp.getEmailid());
////			query.setParameter("mobileno", emp.getMobileno());
//			employee = query.uniqueResult();
//			tx.commit();
//			
//		}catch (Exception e) {
//			if(tx!=null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}finally {
//			if (session!=null) {
//				session.close();
//			}
//		}
//		
//		return employee;
//		
//	}
	}


