package com.dss.streams;

public class Employee {
	
	private Integer empId;
	private String name;
	private Double salary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer empId, String name, Double sallary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = sallary;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSallary() {
		return salary;
	}
	public void setSallary(Double sallary) {
		this.salary = sallary;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", sallary=" + salary + "]";
	}


}
