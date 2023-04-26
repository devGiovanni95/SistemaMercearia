package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Connection objects.
 */
public class ConnectionFactory {

	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		//Class.forName("com.mygetConnectionsql.cj.jdbc.Driver");
		Connection connection = null;
		
		try {
			
			return connection =  DriverManager.getConnection("jdbc:mysql://aws.connect.psdb.cloud/sistemamercado?sslMode=VERIFY_IDENTITY",
					  "d8nsy4zm8bacaeu2d0k2",
					  "pscale_pw_e5AZ0CuPPdOCst6cRRXM5KLKm5zaSwn4K6k04JfY6bR");
			
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}
		
	}
}
