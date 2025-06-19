package com.dss.streams;

import java.util.Arrays;
import java.util.List;

/*
 * Intermediate operation with Employee object
 */
public class IntermediateOperationEmployee {
	
	public static void main(String[] args) {
		
		List<Employee> employees=Arrays.asList(new Employee(105,"Aman",new Double(25000))
				,new Employee(108,"Rahul",new Double(45000)),new Employee(104,"Zoya",new Double(38000))
				,new Employee(103,"Deepak",new Double(11000)),new Employee(106,"Aman",new Double(28000))
				,new Employee(107,"Kartik",new Double(18000)),new Employee(109,"Mohit",new Double(15000))
				,new Employee(102,"Twinkle",new Double(22000)),new Employee(101,"Dhriti",new Double(65000)));
		
		//1. sorted()
		List<Employee> sortByNmae=employees.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).toList();
		List<String> empNames=sortByNmae.stream().map(Employee::getName).toList();
		System.out.println("Employee Names in assending order:"+empNames);
		List<Employee> sortByNameDesc=employees.stream().sorted((e1,e2)->e2.getName().compareTo(e1.getName())).toList();
		List<String> empNamesDesc=sortByNameDesc.stream().map(Employee::getName).toList();
		System.out.println("Employee Names in desending:"+empNamesDesc);
				
		
		List<Employee> sortById=employees.stream().sorted((e1,e2)->e1.getEmpId().compareTo(e2.getEmpId())).toList();
		List<Integer> empIds=sortById.stream().map(Employee::getEmpId).toList();
		System.out.println("Employee Ids In assending order:"+empIds);
		
		List<Employee> sortBySalary=employees.stream().sorted((e1,e2)->e1.getSallary().compareTo(e2.getSallary())).toList();
		List<Double> empSalaryAce=sortBySalary.stream().map(Employee::getSallary).toList();
		System.out.println("Employee Salary in ace:"+empSalaryAce);
		
		//Question 1.sort employees in accending order only names
		List<String> sortEmpNames=employees.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).map(Employee::getName).toList();
		System.out.println("Sort Emp names in one line:"+sortEmpNames);
				
		
	}

}
