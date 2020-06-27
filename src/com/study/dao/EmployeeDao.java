package com.study.dao;

import java.util.List;

import com.study.model.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees();

	public int insertEmployee(Employee emp);

	public int updateEmployee(Employee emp);

	public int updateEmployeeSpecific(int id, Employee emp);

	public Employee getEmployee(int id);

	public int testEmployee(Employee emp);
}
