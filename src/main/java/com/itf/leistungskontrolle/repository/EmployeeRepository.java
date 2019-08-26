package com.itf.leistungskontrolle.repository;

import org.springframework.data.repository.CrudRepository;

import com.itf.leistungskontrolle.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
