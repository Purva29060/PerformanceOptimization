package com.tka.Performance.Optimization.service;


import java.util.List;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Performance.Optimization.dao.EmployeeDao;
import com.tka.Performance.Optimization.entity.Country;
import com.tka.Performance.Optimization.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if (Objects.isNull(msg)) {
			msg = "Employee Addedd Successfully";
		}
		return msg;
	}
	
	public String updateEmployee(Employee emp, long id) {
		String msg = dao.updateEmployee(emp,id);
		if (Objects.isNull(msg)) {
			msg="Employee is Not Updated";
		}
		return msg;
	}
	
	public String deleteEmployee(long id) {
		String msg = dao.deleteEmployee(id);
		if (Objects.isNull(msg)) {
			msg="Employee is Not Deleted";
		}
		return msg;
	}
	public List<Employee> getAllEmployee() {
		List<Employee> list = dao.getAllEmployee();
		return list;
	}
	
	public Employee getParticularEmployeeById(long id) {
		Employee emp= dao.getParticularEmployeeById(id);
		return emp;
	}
	
//	public Map login(Employee emp) {
//		Employee obj = dao.login(emp);
//		Map map = new HashMap();
//		if (Objects.isNull(obj)) {
//			map.put("msg", "Invalid User");
//			map.put("user", obj);
//		}
//		else {
//			map.put("msg", "Valid User");
//			map.put("user", obj);
//		}
//		return map;
	

}

