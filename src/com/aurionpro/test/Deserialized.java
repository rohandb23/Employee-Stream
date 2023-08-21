package com.aurionpro.test;
import com.aurionpro.model.Employee;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserialized {

	public static void main(String[] args) throws Exception{
		FileInputStream file = new FileInputStream("D:\\14-08-23\\15-Test\\Employee.txt");
		ObjectInputStream out = new ObjectInputStream(file);
		List<Employee> employeesList = (List<Employee>)out.readObject();
		for (Employee employee : employeesList) {
			System.out.println(employee);
		}
	}

}
