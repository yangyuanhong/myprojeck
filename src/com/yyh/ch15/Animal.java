package com.yyh.ch15;

public class Animal {
	private int age;
private  String name;
public Animal(){
	System.out.println("调用Animal的无参构造函数");
};
public Animal(int age, String name) {
	super();
	this.age = age;
	this.name = name;
}

public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Animal [age=" + age + ", name=" + name + "]";
}



}
