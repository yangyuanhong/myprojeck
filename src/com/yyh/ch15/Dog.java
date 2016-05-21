package com.yyh.ch15;

public class Dog  extends Animal{
public   String  color;

		public   Dog() {
			super();
			System.out.println("调用Dog的无参构造函数");}
public Dog(String color,int age,String name)
   {
	this();
	super.setAge(age);
	super.setName(name);
	this.color=color;
	}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
}
		@Override
		public String toString() {
			return "Dog [name:"+super.getName()+",age:"+super.getAge()+",color:" + color + "]";
		}
		
}