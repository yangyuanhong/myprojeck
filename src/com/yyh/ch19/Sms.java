package com.yyh.ch19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Sms {
	private List<Student> list=new ArrayList<Student>() ;
	
public void save(Student student)
	{
	list.add(student);
}
public void queryAll()
	{   
	Iterator<Student> iter=list.iterator();
	while(iter.hasNext())
	{
		System.out.println(iter.next());
	}
	System.out.println("共查询到"+list.size()+"个学生信息");
}
public Student  queryById(long id){
	for(Student stu:list)
	{
     if(stu.getId()==id)
     {
		return stu;
     }
	}
	return null;

}


public void deleteById(long id)
{
    Iterator<Student> iter=list.iterator();
    while(iter.hasNext())
    {
    	if(iter.next().getId()==id)
    	{
    		iter.remove();
    		break;
    	}
    }
}
public void Update(Student student)
	{
	for(Student stu:list)
	{
		if(stu.getId()==student.getId())
		{
			stu.setName(student.getName());
			stu.setAge(student.getAge());
		}
	}
	}
public void menu()
	{
	System.out.println("********学生信息管理系统********");
    System.out.println("*1 查询学生信息");
	System.out.println("*2 录入学生信息");
    System.out.println("*3 删除学生信息");
	System.out.println("*4 通过id查找学生信息");
	System.out.println("*5 修改学生信息");
	System.out.println("*exit 退出系统!");
	System.out.println("*help 获取帮助");
	System.out.println("********************************");

}




	public static void main(String[] args)
		{
		Sms sms=new Sms();
		sms.menu();
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("*请输入对应指令");
		 String num=sc.nextLine();
		 switch(num)
			 {
			 case"1":
				 System.out.println("以下是所有学生信息:");
			     sms.queryAll();
				 break;
			 case"2":
				 while(true){
					 try{
			        System.out.println("请输入学生信息【id#name#age】或者输入break返回上一层");
		         String stustr=sc.nextLine();
				 if(stustr.equals("break"))
				 {
					 break;
				 }
				 String[] stuArr=stustr.split("#");
                 long id=Long.parseLong(stuArr[0]);
				 String name=stuArr[1];
				 int age=Integer.parseInt(stuArr[2]);
				 Student stu=new Student(id,name,age);
				 sms.save(stu);
				 System.out.println("保存成功!");
				}catch(Exception e)
 				 {
 					 System.out.println("您的输入有误，请再次输入");
 					 continue;
 				 }
				 }
				 break;
			case"3":
                 while(true){
                	 try{
                		 
             		        System.out.println("请输入要删除的学生id或者输入break返回上一层");
             	         String idstr=sc.nextLine();
             			 if(idstr.equals("break"))
             			 {
             				 break;
             			 }
             			 long id =Long.parseLong(idstr);
             			 Student stu=sms.queryById(id);
             			 if(stu==null){
             			     System.out.println("您要删除的学生信息不存在!");
             				 continue;
             			 }
             			 sms.deleteById(id);
             			 System.out.println("删除成功!");
			 }catch(Exception e)
				 {
					 System.out.println("您的输入有误，请再次输入");
					 continue;
				 }
                 }
				 break;
			case"4":
				while(true){
					try{
			        System.out.println("请输入要查找的学生id或者输入break返回上一层");
		         String idstr=sc.nextLine();
				 if(idstr.equals("break"))
				 {
					 break;
				 }
				 long id =Long.parseLong(idstr);
				 Student stu1=sms.queryById(id);
				 System.out.println(stu1==null?"sorry!Not found":stu1);
					}catch(Exception e)
					{
						System.out.println("您的输入有误，请再次输入！");
					}
			 }
				  
				 break;
			case"5":
				 while(true){
					 try{
			        System.out.println("请输入要修改的学生id或者输入break返回上一层");
		         String idstr=sc.nextLine();
				 if(idstr.equals("break"))
				 {
					 break;
				 }
				 long id =Long.parseLong(idstr);
				 Student stu=sms.queryById(id);
				 if(stu==null){
				     System.out.println("您要修改的学生信息不存在!");
					 continue;
				 }
				 System.out.println("原信息为:"+stu);
				 System.out.println("请输入新信息【name#age】:");
				 String str=sc.nextLine();
				 String[] stuArr=str.split("#");
				 String name=stuArr[0];
				 int age =Integer.parseInt(stuArr[1]);
				 Student newstu=new Student(id,name,age);
				 sms.Update(newstu);
				 System.out.println("修改成功!");
					 }catch(Exception e)
					 {
						 System.out.println("您的输入有误，请再次输入！");
					 }
			 }
				 break;
			 case"exit":
				 System.out.println("拜拜!欢迎下次使用,");
				 System.exit(0);
			 default:
				 sms.menu();
                 break;
	 }
		}
	}
}
