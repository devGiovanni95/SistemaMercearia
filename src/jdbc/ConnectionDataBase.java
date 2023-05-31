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

	/** The prepared statement. */
	public PreparedStatement preparedStatement;

	/** The result set. */
	public ResultSet resultSet;

	/** The con. */
	public Connection con;

	/** The driver. */
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	/** The databasename. */
	private final String DATABASENAME = "mercearia";

	/** The url. */
	private final String URL = "jdbc:sqlserver://localhost:1433;databasename=" + DATABASENAME;

	/** The login. */
	private final String LOGIN = "giovanni";

	/** The senha. */
	private final String SENHA = "123456";

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public boolean getConnection() {
		try {
			// Carregar o driver durante a execução
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou...");
			return true;
		} catch (ClassNotFoundException erro) {
			System.out.println("Driver não encontrado!!");
		} catch (SQLException erro) {
			System.out.println("Falha " + erro);
		}
		return false;
	}

	/**
	 * Close.
	 */
	public void close() {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException erro) {
		}

		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException erro) {
		}

		try {
			if (con != null) {
				con.close();
				System.out.println("Desconectou...");
			}
		} catch (SQLException erro) {
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ConnectionDataBase bd = new ConnectionDataBase();
		bd.getConnection();
		bd.close();
	}
}
