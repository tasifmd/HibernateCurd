package com.bridgelabz.hibernatecurd.service;

import com.bridgelabz.hibernatecurd.model.Employee;

public interface CrudService {

	public Employee create();

	public Employee update();

	public Employee delete();

	public void getEmployees();
}
