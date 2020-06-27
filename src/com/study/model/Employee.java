package com.study.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "EMPLOYEE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY, region="employee")
public class Employee {
	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	// user.fname.invalid is in properties file it must be in classpath
	@Size(max = 20, min = 3, message = "{user.fname.invalid}")
	@NotEmpty(message = "Please enter First Name")
	@Column(name = "EMP_FNAME")
	private String emp_fname;
	@Column(name = "EMP_LNAME")
	private String emp_lname;
	@Column(name = "EMP_SALARY")
	private int emp_salary;
	// right way to do one to many get and post
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_EMP_ID", referencedColumnName = "emp_id")
	@JsonProperty(value = "address_list")
	List<Address> addressList;

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_fname() {
		return emp_fname;
	}

	public void setEmp_fname(String emp_fname) {
		this.emp_fname = emp_fname;
	}

	public String getEmp_lname() {
		return emp_lname;
	}

	public void setEmp_lname(String emp_lname) {
		this.emp_lname = emp_lname;
	}

	public int getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(int emp_salary) {
		this.emp_salary = emp_salary;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_fname=" + emp_fname + ", emp_lname=" + emp_lname + ", emp_salary="
				+ emp_salary + "]";
	}
}
