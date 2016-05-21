package com.yyh.cybercafems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Cyms {
    
public List<Client> queryAll(){
	List<Client> cus=new ArrayList<Client>();
	try {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=ConnectFactory.getconn();
			String sql="select * from t_cms";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				long id=rs.getLong("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String memberlevel=rs.getString("memberlevel");
				int cut=rs.getInt("cut");
				long phone=rs.getLong("phone");
				String password=rs.getString("password");
				Client cli=new Client(id, name, age, memberlevel, cut, phone, password);
				cus.add(cli);
			}
			
		}finally{
			ConnectFactory.close(rs, pstmt, conn);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return cus;
}
public  void  Input(Client cus)
{
	try {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try
		{
			conn=ConnectFactory.getconn();
			String sql="insert into t_cms(name,age,memberlevel,cut,phone,password) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cus.getName());
			pstmt.setInt(2, cus.getAge());
			pstmt.setString(3, cus.getMemberlevel());
			pstmt.setInt(4, cus.getCut());
			pstmt.setLong(5, cus.getPhone());
			pstmt.setString(6, cus.getPassword());
			pstmt.executeUpdate();
		}finally{
			ConnectFactory.close(null, pstmt, conn);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
public void deleteById(long id)
{
	try {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=ConnectFactory.getconn();
			String sql="delete from t_cms where id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		
	}finally{ConnectFactory.close(null, pstmt, conn);}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public Client   queryById(long id){
	Client cus=null;
	try {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=ConnectFactory.getconn();
			String sql="select * from t_cms where id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String memberlevel=rs.getString("memberlevel");
				int cut=rs.getInt("cut");
				long phone=rs.getLong("phone");
				String password=rs.getString("password");
				 cus=new Client(id, name, age, memberlevel, cut, phone, password);
			}
		}finally{ConnectFactory.close(rs, pstmt, conn);}
		}catch(Exception e){e.printStackTrace();}
	return cus;

	
}
public void UpdateById(Client cus)
{
	try {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=ConnectFactory.getconn();
			String sql="update t_cms set name=?,age=?,memberlevel=?,cut=?,phone=?,password=? where id = ?";
		   pstmt=conn.prepareStatement(sql);
		   pstmt.setString(1, cus.getName());
		   pstmt.setInt(2, cus.getAge());
		   pstmt.setString(3, cus.getMemberlevel());
		   pstmt.setInt(4, cus.getCut());
		   pstmt.setLong(5, cus.getPhone());
		   pstmt.setString(6, cus.getPassword());
		   pstmt.setLong(7, cus.getId());
		   pstmt.executeUpdate();
	}finally{ConnectFactory.close(null, pstmt, conn);}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
 
 public void Menu()
 {
	 System.out.println("********欢迎来到网吧管理系统********");
		System.out.println("*1 *****录入用户信息****************");
		System.out.println("*2 *****查询所有用户信息************");
		System.out.println("*3 *****通过id查找该用户信息********");
		System.out.println("*4 *****删除用户信息****************");
		System.out.println("*5 *****通过id修改用户信息**********");
		System.out.println("*exit **退出管理信息****************");
		System.out.println("*help **获取帮助********************");
 }
 
 public static void main(String[] args) {
	 Cyms cyms=new Cyms();
	 cyms.Menu();
	 @SuppressWarnings("resource")
	Scanner sc =new Scanner(System.in);
	 while(true)
	 {
		 System.out.println("*请输入指令");
		String  num=sc.nextLine();	
		 switch(num)
		 {
		 case "1":
			 List<Client> tu=cyms.queryAll();
			 Iterator<Client> iter=tu.iterator();
			 System.out.println("以下是所有用户信息");
			 while(iter.hasNext()	){
				 System.out.println(iter.next());
			 }
			 System.out.println("共查询到"+tu.size()+"个用户;");
			 break ;
		 case "2":
			 while(true)
			 {
				 try{
				 System.out.println("*请输入用户信息格式[name&age&memberlevel&cut&phone&password]或输入break返回上一目录");
				String  data=sc.nextLine();
				if(data.equals("break"))
				{
					break;
				}
				String[] arr =data.split("&");
				String name=arr[0];
				int age=Integer.parseInt(arr[1]);
				String memberlevel=arr[2];
				int cut=Integer.parseInt(arr[3]);
				long phone=Long.parseLong(arr[4]);
				String password=arr[5];

				Client tuu=new Client(null, name, age, memberlevel,cut, phone, password);
				cyms.Input(tuu);
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
			 System.out.println("*请输入要删除的用户id或输入break返回上一目录");
				String data =sc.nextLine();
				
				if(data.equals("break"))
				{
					break;
				}
				long  id=Long.parseLong(data);
			  Client  tuu= cyms.queryById(id);
			  System.out.println(tuu==null?"对不起，你要删除的用户不存在!":"删除成功！");
			  cyms.deleteById(id);
				
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
			 System.out.println("*请输入要查询的用户id或输入break返回上一目录");
				String data =sc.nextLine();
				if(data.equals("break"))
				{
					break;
				}
				long  id=Long.parseLong(data);
			  Client  tuu= cyms.queryById(id);
			  System.out.println(tuu==null?"对不起，没有找到!":"你要查询的用户信息如下:"+tuu);	
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
				 System.out.println("*请输入要修改的用户id或输入break返回上一目录");
					String data =sc.nextLine();
					if(data.equals("break"))
					{
						break;
					}
					long  id=Long.parseLong(data);
				  Client  tuu= cyms.queryById(id);
				  System.out.println(tuu==null?"您要修改的用户不存在":"你要修改的用户原信息如下:"+tuu);	
			 System.out.println("请输入新的信息[name&age&memberlevel&cut&phone&password]");
			 String tue=sc.nextLine();
			 String arr[]=tue.split("&");
			 String name=arr[0];
			 int age =Integer.parseInt(arr[1]);
			 String memberlevel=arr[2];
			 int cut =Integer.parseInt(arr[3]);
			 long phone=Long.parseLong(arr[4]);
			 String password=arr[5];
	     	Client  cus=new Client(id, name, age, memberlevel, cut, phone, password);
			 cyms.UpdateById(cus);
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
			 cyms.Menu();
			 break ;
		 
		 }
				
	 }
	}
}
