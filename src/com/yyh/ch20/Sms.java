package com.yyh.ch20;

import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sms {
	
public static  void save(Student student)
	{try{
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=ConnectFactory.getconn();
			String sql="insert into t_student(name,age) values(?,?)";
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1, student.getName());
		    pstmt.setInt(2, student.getAge());
		    pstmt.executeUpdate();
		}finally{
			ConnectFactory.close(null, pstmt, conn);
		}
	}catch(Exception e){
		e.printStackTrace();
	}

}
public List<Student> queryAll()
	{  
	List<Student> list=new ArrayList<Student>();
	try{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=ConnectFactory.getconn();
			String sql = "select * from t_student";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				long  id=rs.getLong("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				Student stu=new Student(id,name, age);
				list.add(stu);
			}		
		}finally{
			ConnectFactory.close(rs, pstmt, conn);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return list;
	
}
public Student  queryById(long id){
	Student stu=new Student();
	try{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=ConnectFactory.getconn();
			String sql="select * from t_student where id= ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				int age=rs.getInt("age");
				 stu=new Student(id, name, age);
			}
			
		}finally{
			ConnectFactory.close(rs, pstmt, conn);
		}
	}catch(Exception e){e.printStackTrace();}
	
	return stu;

}


public void deleteById(long id)
{ 
	try{
		Connection conn=null;
		PreparedStatement pstmt=null;
	try{
		conn=ConnectFactory.getconn();
		String sql="delete from t_student where id= ?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setLong(1, id);
		pstmt.executeUpdate();
	}finally{
		ConnectFactory.close(null, pstmt, conn);
	}
}catch(Exception e){
	e.printStackTrace();
}
   
}
public void Update(Student student)
	{
	try{
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=ConnectFactory.getconn();
			String sql="update t_student set name=?,age=? where id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getAge());
			pstmt.setLong(3, student.getId());
			pstmt.executeUpdate();
		}finally{
			ConnectFactory.close(null, pstmt, conn);
		}
	}catch(Exception e){
		e.printStackTrace();
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
			     List<Student> stus=sms.queryAll();
			    for(Student  stu:stus){
			    	 System.out.println(stu);
			     }
			    System.out.println("总共查询到"+stus.size()+"个学生");
				 break;
			 case"2":
				 while(true){
					 try{
			        System.out.println("请输入学生信息【name#age】或者输入break返回上一层");
		         String stustr=sc.nextLine();
				 if(stustr.equals("break"))
				 {
					 break;
				 }
				 String[] stuArr=stustr.split("#");
				 String name=stuArr[0];
				 int age=Integer.parseInt(stuArr[1]);
				 Student stu=new Student(null,name,age);
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
             			 if(stu.getId()==null){
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
				 System.out.println(stu1.getId()==null?"sorry!Not found":stu1);
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
				 if(stu.getId()==null){
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

