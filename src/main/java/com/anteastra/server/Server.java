package com.anteastra.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.SequenceInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;

public class Server {
	public static Connection dbconn = null;
	
	public static void main(String ...arg){
				
		if (createDbInMem())
			System.out.println("server db started");
	}
	
	public static boolean createDbInMem(){
		JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:test", "sa", "sa");
		try {
			dbconn = cp.getConnection();
			if (!fillDatabase())
				return false;	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		return true;
	}
	
	public static boolean fillDatabase(){
		try {
			Statement st = dbconn.createStatement();
			ResultSet rs;
			BufferedReader reader = new BufferedReader(new FileReader("assets/database_sample.sql"));
			List<String> strings = new ArrayList<String>();
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
