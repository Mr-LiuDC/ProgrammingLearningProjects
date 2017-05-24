package cn.alittler.study.springboot.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Cacheable
@Table(name = "demo_departments")
@Entity
public class Department {

	private Integer id;
	private String departmentName;

	@Id
	@GeneratedValue(generator = "xxx")
	@GenericGenerator(name = "xxx", strategy = "native")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
