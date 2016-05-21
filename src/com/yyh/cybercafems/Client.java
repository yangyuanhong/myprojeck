package com.yyh.cybercafems;

public class Client {
private Long id;
private String name;
private Integer age;
private  String  memberlevel;
private  Integer cut;
private Long phone;
private String password;
public Client() {
	super();
}
public Client(Long id, String name, Integer age, String memberlevel,Integer cut,
		Long phone, String password) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.memberlevel = memberlevel;
	this.cut = cut;
	this.phone = phone;
	this.password = password;
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
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getMemberlevel() {
	return memberlevel;
}
public void setMemberlevel(String memberlevel) {
	this.memberlevel = memberlevel;
}
public Integer getCut() {
	return cut;
}
public void setCut(Integer cut) {
	this.cut = cut;
}
public Long getPhone() {
	return phone;
}
public void setPhone(Long phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Client [id=" + id + ", name=" + name + ", age=" + age
			+ ", memberlevel=" + memberlevel + ", cut=" + cut + ", phone="
			+ phone + ", password=" + password + "]";
}


}
