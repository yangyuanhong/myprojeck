package com.yyh.ch19.tms;

public class Teacher {
private long id;
private String name;
private int  workerage;
private String address;
private long QQ;
public Teacher() {
	
}

public Teacher(long id, String name, int workerage, String address, long qQ) {
	super();
	this.id = id;
	this.name = name;
	this.workerage = workerage;
	this.address = address;
	QQ = qQ;
}

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getQQ() {
	return QQ;
}
public void setQQ(long qQ) {
	QQ = qQ;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getWorkerage() {
	return workerage;
}
public void setWorkerage(int workerage) {
	this.workerage = workerage;
}
@Override
public String toString() {
	return "Teacher [id:" + id + ", name:" + name + ", workerage:" + workerage
			+ ", address:" + address + ", QQ:" + QQ + "]";
}


}
