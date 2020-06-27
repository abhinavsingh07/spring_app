package com.study.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.error.ErrorResponse;
import com.study.error.ResolveResultErrors;
import com.study.model.Employee;
import com.study.services.EmployeeService;

@RestController // by applying this we dont need @responsebody annotaion for controller method
public class Employee_Rest_Controller {
	@Autowired
	private EmployeeService empService;

	public EmployeeService getEmpService() {
		return empService;
	}

	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getStudentList() {

		List<Employee> al = this.empService.getEmployees();
		return new ResponseEntity<List<Employee>>(al, HttpStatus.OK);

	} 

	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertEmployee(@Valid @RequestBody Employee emp, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			//validation errors         
			List<String> list = ResolveResultErrors.resolveBindingResultErrors(bindingResult);
			ErrorResponse error = new ErrorResponse("BAD_REQUEST", list);
			System.out.println(error);
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}

		int id = this.empService.insertEmployee(emp);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);

	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateEmployee(@RequestBody Employee emp) {
		int id = this.empService.updateEmployee(emp);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);

	}

	@RequestMapping(value = "/employeeSpecific/{empId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateEmployeeSpecific(@PathVariable("empId") int empId, @RequestBody Employee emp) {
		int id = this.empService.updateEmployeeSpecific(empId, emp);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);

	}

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") int empId) {
		Employee emp = this.empService.getEmployee(empId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	@RequestMapping(value = "/testEmployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> testEmployee(@RequestBody Employee emp) {
		int id = this.empService.testEmployee(emp);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
			
	}

	
}
