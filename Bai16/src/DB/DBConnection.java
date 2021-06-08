package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection creatConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/examplebai16";
		String username = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, pass);
			System.out.println("connection sucess");
		} catch (ClassNotFoundException e) {
			System.out.println("connect fail");
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
public static void main(String[] args) {
	DBConnection.creatConnection();
	
}
}


