package com.test.entity;

import java.util.Date;

public class Employee {
	private int empId;
	private String empName;
	private String empSalary;
	private Date date;

	public Employee() {
	}

	public Employee(int empId, String empName, String empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee Id:=" + empId + " Employee Name:=" + empName + " Employee Salary:=" + empSalary;
	}
}