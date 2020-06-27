package com.study.services;

import java.util.List;

import com.study.model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public int insertEmployee(Employee emp);

	public int updateEmployee(Employee emp);

	public int updateEmployeeSpecific(int id, Employee emp);

	public Employee getEmployee(int id);

	public int testEmployee(Employee emp);
}
