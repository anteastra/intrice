package com.anteastra.dataBase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;

public class DB {
	public static Connection dbconn = null;
	
	public static boolean createDbInMem(){
		JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:test", "sa", "sa");
		try {
			dbconn = cp.getConnection();
			if (!fillDatabase()){
				return false;	
			}
			System.out.println("Testing database--->");
			if (!testDatabase()){
				System.out.println();
				System.out.println("----------------");
				System.out.println("Database not filled!!!");
				return false;
			}else{
				System.out.println();
				System.out.println("----------------");
				System.out.println("Database filled");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		return true;
	}
	
	private static boolean testDatabase() {
		
		try {
			Statement st = dbconn.createStatement();
			ResultSet rs;
			String sql = "select * from product";
			
			rs = st.executeQuery(sql);
			while (rs.next()){
				System.out.println(rs.getString(1)+"; "+ rs.getString(2));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static boolean fillDatabase(){
		try {
			Statement st = dbconn.createStatement();
			ResultSet rs;
			BufferedReader reader = new BufferedReader(new FileReader("assets/database_sample.sql"));			
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			st.execute(sb.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
}
