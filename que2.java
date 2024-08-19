package com.task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class que2 {

	public static void main(String[] args) {
		        //database information
		
				String db_url="jdbc:mysql://localhost:3306/";
				String username="root";
				String password="1819";
				
				//establish the connection
				try {
				     Connection conn=DriverManager.getConnection(db_url, username, password);
					
					//validate connection is success
					if(conn!=null) {
						System.out.println(conn);
						System.out.println("the database connection is successful..");				
					}else {
						System.out.println("the database connection is nor successful..");
					}
					
					//create reference to statement ->create,insert
					Statement stmt=conn.createStatement();
					
					//create statement ->create,insert
					String createDB="create database jatjdbc1";
					String use="use jatjdbc1";
					String createtable="create table empinfo(empcode int,empname varchar(9),empage int,empsalary int)";
					String insert="insert into empinfo values(101,'jenny',25,10000),"+ "(102,'jacky',30,20000),"+ "(103,'joe',20,40000),"+ "(104,'john',40,80000),"+ "(105,'shameer',25,90000)";
					String select="select * from empinfo";
					
					stmt.execute(createDB);   //create the database
					stmt.execute(use);        //start using that database
				    stmt.execute(createtable);
				    stmt.execute(insert);
				    
				    //result set
				    ResultSet rs=stmt.executeQuery(select);
				    
				    System.out.println("==================================");
				    
				    while(rs.next()) {
				    	System.out.println(rs.getInt("empcode")+" "+rs.getString("empname")+" "+rs.getInt("empage")+" "+rs.getInt("empsalary"));
				    }
				    
				    //close the conncection object
				    conn.close();
				    	
				
			    }catch (SQLException e) {
			    	e.printStackTrace();
			    }
			    	
			}
			

	}


