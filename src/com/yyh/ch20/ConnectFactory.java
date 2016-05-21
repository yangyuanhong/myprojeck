package com.yyh.ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectFactory {
	
private static 	String driver="com.mysql.jdbc.Driver";
private static 	String url ="jdbc:mysql://127.0.0.1:3306/test";
private static 	String user="root";
private static 	String password="root";
public static Connection getconn() throws Exception{
	Class.forName(driver);
	return DriverManager.getConnection(url, user, password);
}
public static void close(ResultSet rs,PreparedStatement pstmt,Connection  conn) throws Exception
{
	if(rs!=null){rs.close();}
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
	}
}
