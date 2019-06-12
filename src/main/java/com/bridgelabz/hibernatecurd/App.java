package com.bridgelabz.hibernatecurd;

import java.util.Scanner;

import com.bridgelabz.hibernatecurd.model.Employee;
import com.bridgelabz.hibernatecurd.service.CrudService;
import com.bridgelabz.hibernatecurd.service.CurdServiceImpl;
import com.bridgelabz.hibernatecurd.util.Utility;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner scanner = new Scanner(System.in);
	private static CrudService crudService = new CurdServiceImpl();

	public static void main(String[] args) {
		boolean flag = false;
		do {
			System.out.println("Enter your operation 1.Create\t2.Update\t3.Delete\t4.Retrive\t5.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Employee employeeCreate = crudService.create();
				System.out.println("Employee added is " + employeeCreate.getEmployeeName());
				break;
			case 2:
				Employee employeeUpdate = crudService.update();
				System.out.println("Employee updated is " + employeeUpdate.getEmployeeName());
				break;
			case 3:
				Employee employeeDelete = crudService.delete();
				System.out.println("Employee deleted is " + employeeDelete.getEmployeeName());
				break;
			case 4:
				crudService.getEmployees();
				break;
			case 5:
				flag = true;
				Utility.closeSession();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (flag == true);
	}
}
