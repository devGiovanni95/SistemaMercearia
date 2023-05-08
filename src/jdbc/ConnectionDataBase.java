package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;



// TODO: Auto-generated Javadoc
/**
 * A factory for creating Connection objects.
 */
public class ConnectionDataBase {

	public PreparedStatement preparedStatement; 	
	public ResultSet resultSet; 
	public Connection con;
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String DATABASENAME = "mercearia";
	private final String URL = "jdbc:sqlserver://localhost:1433;databasename=" + DATABASENAME;
	private final String LOGIN = "giovanni";
	private final String SENHA = "123456";
	
	public boolean getConnection() {
		try {
			//Carregar o driver durante a execução
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,LOGIN,SENHA);
			System.out.println("Conectou...");
			return true;
		} catch (ClassNotFoundException erro) {
			System.out.println("Driver não encontrado!!");
		} catch (SQLException erro) {
			System.out.println("Falha " + erro);
		}
		return false;
	}
	
	public void close() {
		try {
			if(resultSet!=null) resultSet.close();
		} catch (SQLException erro) {}
		
		try {
			if(preparedStatement!=null) preparedStatement.close();
		} catch (SQLException erro) {}
		
		try {
			if(con!=null) { 
				con.close();
				System.out.println("Desconectou...");
			}
		} catch (SQLException erro) {}
}
	
	public static void main(String[] args) {
		ConnectionDataBase bd = new ConnectionDataBase();
		bd.getConnection();
		bd.close();
	}
}
