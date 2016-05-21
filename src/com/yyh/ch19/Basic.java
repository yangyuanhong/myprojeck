package com.yyh.ch19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.xml.transform.Result;

@SuppressWarnings("unused")
public class Basic {
	public static void main(String[] args) {
		new Basic().queryById(3);
	}
	
	public void queryById(long id){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			try{
				conn=ConnectFactory.getconn();
				String sql="select * from t_student where id= ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					String name=rs.getString("name");
					int age=rs.getInt("age");
					System.out.println("您要查询的信息为;name="+name+"age="+age);
				}
			}finally{
				ConnectFactory.close(rs, pstmt, conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void queryAll(){
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
	try{
		try{
			
			conn=ConnectFactory.getconn();
			String sql = "select * from t_student";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();		
			while(rs.next()){
				long id=rs.getLong("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				System.out.println("stuend:id="+id+",name="+name+",age="+age);
				
			}
		}finally{ 
			ConnectFactory.close(rs, pstmt, conn);
			
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	public void deleteById(long id){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			try{
				conn=ConnectFactory.getconn();
				String sql="delete from t_student where id= ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				int num=pstmt.executeUpdate();
				System.out.println(num+"行被删除");
			}finally{
			ConnectFactory.close(null, pstmt, conn);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
        public void  update(long id,String name,int age)
        {
        	Connection conn=null;
        	PreparedStatement pstmt=null;
        	try{
        		try{
        			conn=ConnectFactory.getconn();
        			String sql="update t_student set name=?,age=? where id = ?";
        			pstmt=conn.prepareStatement( sql);
        			pstmt.setString(1, name );
        			pstmt.setInt(2, age);
        			pstmt.setLong(3, id);
        			int num=pstmt.executeUpdate();
        			System.out.println("行修改成功");
        		}finally{
        			ConnectFactory.close(null, pstmt, conn);
        		}
        	}catch(Exception e){
        		e.printStackTrace();
        		
        	}
        }
        public void  save(String name,int age)
        {
        	Connection conn=null;
        	PreparedStatement pstmt=null;
        	try {
        		try{
        			conn=ConnectFactory.getconn();
				String sql="insert into t_student(name,age) values(?,?)";
				 pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				int num=pstmt.executeUpdate();
				System.out.println(num+"行录入成功");
        	}finally{
        		ConnectFactory.close(null, pstmt, conn);
        		}
				
        	}catch (Exception e) {
				e.printStackTrace();
			}
        }
}

