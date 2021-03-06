// s3 : program to create table in db

import java.sql.*;

class jdbc_3_create_table_inDB
{
	public static void main(String args[])
	{
		Connection con = null;
		try
		{
			// s1: load the driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			// s2: connect
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "abc123");
			System.out.println("connected");

			// s3: ddl/dml
			String sql = "create table student(rno int primary key, name varchar(20))";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("table created");
		}
		catch(SQLException e)
		{
			System.out.println("sqle --> "+e);
		}	
		finally
		{
			// s4: disconnect
			if (con != null)
			{
				try
				{
					con.close();
					System.out.println("dis connected");
				}
				catch(SQLException e)
				{
					System.out.println("sqle "+e);
				}
			}	
		}
	}
}