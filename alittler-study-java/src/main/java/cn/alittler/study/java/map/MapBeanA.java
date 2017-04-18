package cn.alittler.study.java.map;

import java.util.Date;

public class MapBeanA {

	private Integer id;
	private String name;
	private int age;
	private Date birthday;

	private String address;
	private String description;
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "MapBeanA [id=" + id + ", name=" + name + ", age=" + age
				+ ", birthday=" + birthday + ", address=" + address
				+ ", description=" + description + ", createTime=" + createTime
				+ "]";
	}

}
