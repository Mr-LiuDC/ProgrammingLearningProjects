package cn.alittler.study.java.map;

import java.util.Date;

public class MapBean {

	Integer id;
	String name;
	Date date;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MapBean [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
