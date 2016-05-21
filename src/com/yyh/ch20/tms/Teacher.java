package com.yyh.ch20.tms;

public class Teacher {
private Long id;
private String name;
private Integer  workage;
private String address;
private Long QQ;
public Teacher() {
	super();
}

public Teacher(Long id, String name, Integer workage, String address, Long qQ) {
	super();
	this.id = id;
	this.name = name;
	this.workage = workage;
	this.address = address;
	QQ = qQ;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getWorkage() {
	return workage;
}
public void setWorkage(Integer workage) {
	this.workage = workage;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Long getQQ() {
	return QQ;
}
public void setQQ(Long qQ) {
	QQ = qQ;
}
@Override
public String toString() {
	return "Teacher [id=" + id + ", name=" + name + ", workage=" + workage
			+ ", address=" + address + ", QQ=" + QQ + "]";
}



}
