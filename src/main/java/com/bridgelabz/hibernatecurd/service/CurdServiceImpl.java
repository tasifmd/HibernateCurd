package com.bridgelabz.hibernatecurd.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Query;

import com.bridgelabz.hibernatecurd.model.Employee;
import com.bridgelabz.hibernatecurd.util.Utility;

@SuppressWarnings("deprecation")
public class CurdServiceImpl implements CrudService {

	private Scanner scanner = new Scanner(System.in);
	private static Session session = Utility.getSession();

	public Employee create() {

		Employee employee = new Employee();

		System.out.println("Enter the employee name ");
		String employeeName = scanner.nextLine();
		employee.setEmployeeName(employeeName);

		System.out.println("Enter the employee email ");
		String employeeEmail = scanner.nextLine();
		employee.setEmployeeEmail(employeeEmail);

		System.out.println("Enter the employee mobile number ");
		long employeeMobile = scanner.nextLong();
		employee.setEmployeeMobile(employeeMobile);

		System.out.println("Enter the employee designation ");
		String designation = scanner.nextLine();
		employee.setDesignation(designation);

		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		System.out.println("Employee added successfully");
		return employee;
	}

	public Employee update() {

		boolean flag = false;

		System.out.println("Enter the employee id ");
		int employeeId = scanner.nextInt();
		Employee employee = (Employee) session.get(Employee.class, employeeId);
		System.out.println("Enter your choice for update \n1.Name\t2.Email\t3.Mobile number\t4.Designation\t5.Exit");
		int choice = scanner.nextInt();

		do {
			switch (choice) {
			case 1:
				System.out.println("Enter the employee name ");
				String employeeName = scanner.nextLine();
				employee.setEmployeeName(employeeName);

				session.beginTransaction();
				session.save(employee);
				session.getTransaction().commit();
				break;
			case 2:
				System.out.println("Enter the employee email ");
				String employeeEmail = scanner.nextLine();
				employee.setEmployeeEmail(employeeEmail);

				session.beginTransaction();
				session.save(employee);
				session.getTransaction().commit();
				break;

			case 3:
				System.out.println("Enter the employee mobile number ");
				long employeeMobile = scanner.nextLong();
				employee.setEmployeeMobile(employeeMobile);

				session.beginTransaction();
				session.save(employee);
				session.getTransaction().commit();
				break;

			case 4:
				System.out.println("Enter the employee designation ");
				String designation = scanner.nextLine();
				employee.setDesignation(designation);

				session.beginTransaction();
				session.save(employee);
				session.getTransaction().commit();
				break;

			case 5:
				flag = true;
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (flag == true);
		System.out.println("Employee updated ");
		return employee;
	}

	public Employee delete() {

		System.out.println("Enter the employee id ");
		int employeeId = scanner.nextInt();

		Employee employee = (Employee) session.load(Employee.class, employeeId);
		session.delete(employee);
		session.getTransaction().commit();
		System.out.println("Employee deleted");
		return employee;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getEmployees() {

		Query query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		if (employees.isEmpty())
			System.out.println("No employee exist");
		else
			System.out.println("Employee deatils");
		for (Employee employee : employees) {
			System.out.println("Name\t" + employee.getEmployeeName() + "\tEmail\t" + employee.getEmployeeEmail()
					+ "\tMobile Number\t" + employee.getEmployeeMobile() + "\tDesignation\t"
					+ employee.getDesignation());
		}
	}

}
