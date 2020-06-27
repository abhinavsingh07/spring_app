package com.study.services;

import java.util.List;

import javax.transaction.Transactional;

import com.study.dao.EmployeeDao;
import com.study.model.Employee;

public class EmployeeSeviceImpl implements EmployeeService {

	private EmployeeDao empDao;

	public EmployeeDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return empDao.getEmployees();
	}

	@Override
	public int insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.insertEmployee(emp);
	}

	@Override
	public int updateEmployeeSpecific(int id, Employee emp) {
		// TODO Auto-generated method stub
		return empDao.updateEmployeeSpecific(id, emp);
	}

	@Override
	public int updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.updateEmployee(emp);
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return empDao.getEmployee(id);
	}

	@Override
	@Transactional
	public int testEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.testEmployee(emp);
	}

}
