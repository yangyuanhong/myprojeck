package com.yyh.ch15;

public class Test {
           public static void main(String[] args) {
	                      Test  test=new Test();
	                      test.test1();
}
           public void test1()
           {
        	   Dog dog=new Dog("黑色",2,"小黑");
        	   
        	   System.out.println(dog);
        	   System.out.println(dog instanceof Animal);
        	   System.out.println(dog instanceof Dog);
        	   System.out.println(dog instanceof Object);
           }
}