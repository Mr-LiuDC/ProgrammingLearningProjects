package cn.alittler.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.alittler.study.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee getByLastName(String lastName);
	
}
