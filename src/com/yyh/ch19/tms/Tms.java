package com.yyh.ch19.tms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Tms {
 private  List<Teacher> tus=new ArrayList<Teacher>();
    
public List<Teacher> queryAll(){
	return tus;
}
public  void  Input(Teacher teacher)
{
	tus.add(teacher);
	}
public void delete(long id)
{
	Iterator<Teacher> iter=tus.iterator();
	while(true)
	{
		if(iter.next().getId()==id)
		{
		     iter.remove();
		      break;
		}
	}
}
public Teacher   queryById(long id){
	for( Teacher tuu:tus)
	{
		if(tuu.getId()==id)
		{
			return tuu;
		}
	}
	return null;

	
}
public void AmendById(Teacher teacher)
{
	for(Teacher tuu:tus)
	{
		if(tuu.getId()==teacher.getId())
		{
			tuu.setName(teacher.getName());
			tuu.setAddress(teacher.getAddress());
			tuu.setWorkerage(teacher.getWorkerage());
			tuu.setQQ(teacher.getQQ());
		}
	}
	}
 
 public void Menu()
 {
	 System.out.println("********欢迎进入教师管理系统********");
	 System.out.println("*1 查询所有教师信息*****************");
	 System.out.println("*2  录入教师信息*********************");
	 System.out.println("*3  删除教师信息*********************");
	 System.out.println("*4  通过id查找教师信息***************");
	 System.out.println("*5  修改教师信息*********************");
	 System.out.println("*help 获取帮助***********************");
	 System.out.println("*exit  退出系统***********************");
 }
 
 public static void main(String[] args) {
	 Tms tms=new Tms();
	 tms.Menu();
	 Scanner sc =new Scanner(System.in);
	 while(true)
	 {
		 System.out.println("*请输入指令");
		String  num=sc.nextLine();	
		 switch(num)
		 {
		 case "1":
			 List<Teacher> tu=tms.queryAll();
			 Iterator<Teacher> iter=tu.iterator();
			 System.out.println("以下是所有教师信息");
			 while(iter.hasNext()	){
				 System.out.println(iter.next());
			 }
			 System.out.println("共查询到"+tu.size()+"个老师;");
			 break ;
		 case "2":
			 while(true)
			 {
				 try{
				 System.out.println("*请输入教师信息格式[id&name*&age*&address*&QQ]或输入break返回上一目录");
				String  data=sc.nextLine();
				if(data.equals("break"))
				{
					break;
				}
				String[] arr =data.split("&");
				long  id=Long.parseLong(arr[0]);
				String name=arr[1];
				int workerage=Integer.parseInt(arr[2]);
				String address=arr[3];
				long QQ=Long.parseLong(arr[4]);
               Teacher tuu=new Teacher(id,name,workerage,address,QQ);
				tms.Input(tuu);
				System.out.println("录入成功！");
				 }catch(Exception e)
				 {
					 System.out.println("输入有误，请再次输入！");
					 continue;
				 }
			 }
			 break ;
		 case "3":
			 while(true){
				 try{
			 System.out.println("*请输入要删除的教师id或输入break返回上一目录");
				String data =sc.nextLine();
				
				if(data.equals("break"))
				{
					break;
				}
				long  id=Long.parseLong(data);
			  Teacher  tuu= tms.queryById(id);
			  System.out.println(tuu==null?"对不起，你要删除的老师不存在!":"你要删除的教师信息如下:"+tuu);
			  tms.delete(id);
			  System.out.println("删除成功！");
				
			 }catch(Exception e)
			 {
				 System.out.println("输入有误，请再次输入！");
				 continue;
			 }
			 }
			 break ;
		 case "4":
			 while(true){
				 try{
			 System.out.println("*请输入要查询的教师id或输入break返回上一目录");
				String data =sc.nextLine();
				if(data.equals("break"))
				{
					break;
				}
				long  id=Long.parseLong(data);
			  Teacher  tuu= tms.queryById(id);
			  System.out.println(tuu==null?"对不起，没有找到!":"你要查询的教师信息如下:"+tuu);	
			 }catch(Exception e)
			 {
				 System.out.println("输入有误，请再次输入！");
				 continue;
			 }
			 }
			 break ;
		 case "5":
			 while(true){
				 try{
				 System.out.println("*请输入要修改的教师id或输入break返回上一目录");
					String data =sc.nextLine();
					if(data.equals("break"))
					{
						break;
					}
					long  id=Long.parseLong(data);
				  Teacher  tuu= tms.queryById(id);
				  System.out.println(tuu==null?"您要修改的教师不存在":"你要修改的教师原信息如下:"+tuu);	
			 System.out.println("请输入新的信息【name&workerage&address&QQ】");
			 String tue=sc.nextLine();
			 String arr[]=tue.split("&");
			 String name=arr[0];
			 int workerage =Integer.parseInt(arr[1]);
			 String address=arr[2];
			 long QQ=Long.parseLong(arr[3]);
			Teacher trr=new Teacher(id,name,workerage,address,QQ);
			 tms.AmendById(trr);
			 System.out.println("修改成功！");
			 }catch(Exception e)
			 {
				 System.out.println("输入有误，请再次输入！");
				 continue;
			 }
		 }
			 break ;
		 case "exit":
			 System.out.println("拜拜!欢迎下次使用。。。");
			 System.exit(0);
			 break ;
		default :
			 tms.Menu();
			 break ;
		 
		 }
				
	 }
	}
}
