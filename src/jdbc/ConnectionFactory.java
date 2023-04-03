package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public Connection getConnection() {
		Connection conn =null;
		
		try {
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario","root","admin");
			
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}
		
	}
}
