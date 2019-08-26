package com.itf.leistungskontrolle.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itf.leistungskontrolle.entity.Employee;
import com.itf.leistungskontrolle.repository.EmployeeRepository;

@Controller
@RequestMapping("/api")
public class EmployeeController {
	
	EmployeeRepository employeerepository;
	
	@GetMapping("/employees")
	public ResponseEntity<Iterable<Employee>>getEmployees() {
		return new ResponseEntity<>(employeerepository.findAll(), HttpStatus.OK);
	}
	
	 @PostMapping("/employees")     
	 public ResponseEntity<Employee>create(@Valid @RequestBody Employee employee){      
		 return new ResponseEntity<>(employeerepository.save(employee),HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/employees/{id}")
	 public ResponseEntity<Employee> delete(@PathVariable Integer id) { 
		 if(employeerepository.existsById(id)) 
		 employeerepository.deleteById(id);
		 return ResponseEntity.status(HttpStatus.OK).build(); 
		 
	 }
	 
}




