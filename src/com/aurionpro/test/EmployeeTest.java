package com.aurionpro.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.aurionpro.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) throws Exception{
		List<Employee> listOfEmployees;
		FileReader fr;
		BufferedReader br;
		String line;
		listOfEmployees = new ArrayList<>();
		Scanner sc = new Scanner(new File("C:\\Users\\rohan.bhise\\Downloads\\emp.txt"));
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			String[] data = line.replace("\'", "").split(",");
			if(data.length == 8) {
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				String role = data[2];
				int manager;
				if(data[3].equals("NULL")) {
					manager = 0;
				}
				else {
					manager = Integer.parseInt(data[3]);
				}
				String dateOfBirth = data[4];
				double salary = Double.parseDouble(data[5]);
				double commission;
				if(data[6].equals("NULL")) {
					commission = 0;
				}
				else {
					commission = Double.parseDouble(data[6]);
				}
				int department = Integer.parseInt(data[7]);
				Employee obj = new Employee(id, name, role, manager, dateOfBirth, salary, commission, department);
				listOfEmployees.add(obj);
			}	
		}
		
//		listOfEmployees.forEach(x->System.out.println(x));
		Employee obj1 = new Employee(1, "rohan", "developer", 10, "23-aug-01", 3500, 0, 15);
		listOfEmployees.add(obj1);
		Map<Integer, List<Employee>> departWiseEmployees = listOfEmployees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		
		for (Map.Entry<Integer, List<Employee>> entry : departWiseEmployees.entrySet()) {
			int i=0;
			int department = entry.getKey();
			System.out.println("department : "+department);
			List<Employee> deprtamentEmployees = entry.getValue();
			for (Employee employee : deprtamentEmployees) {
				System.out.println(employee);
				i++;
			}
			System.out.println("total employees in department : "+i);
			Employee emp = deprtamentEmployees.get(0);
			for (Employee employee : deprtamentEmployees) {
				if(emp.getSalary() < employee.getSalary()) {
					emp = employee;
				}
			}
			System.out.println("highest paid employee : "+emp);
			System.out.println("----------------------------");
		}
		
		FileOutputStream file = new FileOutputStream("D:\\14-08-23\\15-Test\\Employee.txt");
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(listOfEmployees);
		file.close();
		out.close();
		
		Map<Integer, List<Employee>> managerList = listOfEmployees.stream().collect(Collectors.groupingBy(Employee::getManager));
		for (Map.Entry<Integer, List<Employee>> entry : managerList.entrySet()) {
			int manager = entry.getKey();
			System.out.println("manager : "+manager);
			List<Employee> managerEmployee = entry.getValue();
			for (Employee employee : managerEmployee) {
				System.out.println(employee);
			}
			System.out.println("----------------------------");
		}
		
		Employee emp = listOfEmployees.get(0);
		for (Employee employee : listOfEmployees) {
			if(emp.getCommission() < employee.getCommission()) {
				emp = employee;
			}
		}
		System.out.println("salesman with highest commission : "+emp);
		
		double totalSalary = listOfEmployees.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println("total salary of all employees is : "+totalSalary);
	}
}
