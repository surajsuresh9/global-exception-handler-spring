package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.exception.EmptyInputException;
import com.repo.EmployeeRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		if (employee.getName().isEmpty() || employee.getName().length() == 0) {
			throw new EmptyInputException("601", "Input Name is Empty");
		}
		Employee savedEmployee = crudRepo.save(employee);
		return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return crudRepo.findAll();
	}

	@Override
	public Employee getEmpById(Long empidL) {
		return crudRepo.findById(empidL).get();
	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
	}

}
