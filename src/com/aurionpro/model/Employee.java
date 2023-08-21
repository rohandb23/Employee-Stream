package com.aurionpro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Employee implements Serializable {
	private int id;
	private String name;
	private String role;
	private int manager;
	private String dateOfBirth;
	private double salary;
	private double commission;
	private int department;
	public Employee(int id, String name, String role, int manager, String dateOfBirth, double salary, double commission,
			int department) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.manager = manager;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.commission = commission;
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", manager=" + manager + ", dateOfBirth="
				+ dateOfBirth + ", salary=" + salary + ", commission=" + commission + ", department=" + department
				+ "]";
	}
}
