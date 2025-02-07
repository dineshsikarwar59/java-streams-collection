package com.dss.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSortingList {
	public static void main(String[] args) {
		List<Employee> empList=new ArrayList<>();
		empList.add(new Employee(Integer.valueOf(101), "G", Double.valueOf(15000)));
		empList.add(new Employee(Integer.valueOf(101), "Z", Double.valueOf(45000)));
		empList.add(new Employee(Integer.valueOf(101), "K", Double.valueOf(65000)));
		empList.add(new Employee(Integer.valueOf(101), "Y", Double.valueOf(25000)));
		empList.add(new Employee(Integer.valueOf(101), "T", Double.valueOf(35000)));
		System.out.println("Brfore Sorting:"+empList);
		
		//sort by employee name
		Collections.sort(empList, (e1,e2)->e1.getName().compareTo(e2.getName()));
		System.out.println("Sorting by Employee Name:"+empList);
		
		//sort by employee salary
		Collections.sort(empList, (e1,e2)->e1.getSallary().compareTo(e2.getSallary()));
		System.out.println("Sorting by Employee salary"+empList);
		
		//Employee max salary
		Double maxSalary= Collections.max(empList.stream().map(Employee::getSallary).toList());
		System.out.println("Employee max Salary:"+maxSalary);
		//Employee max Salary:65000.0
	}

}
