package com.tka.Performance.Optimization.controller;

import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.tka.Performance.Optimization.entity.Employee;
import com.tka.Performance.Optimization.service.EmployeeService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class EmployeeController {


	@Autowired
	EmployeeService service;
	
	@PostMapping("addemp")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
		String msg = service.addEmployee(emp);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("updateEmployee/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp, @PathVariable long id ){
		String msg = service.updateEmployee(emp,id);
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id){
		String msg = service.deleteEmployee(id);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list = service.getAllEmployee();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("getEmployeeById/{id}")
	public ResponseEntity<Employee> getParticularEmployeeById(@PathVariable long id){
		Employee emp = service.getParticularEmployeeById(id);
		return ResponseEntity.ok(emp);
	}
	
//	@PostMapping("login")
//	public ResponseEntity<Map> login(@RequestBody Employee emp) {
//		Map map = service.login(emp);
//		return ResponseEntity.ok(map);
//	}
}
