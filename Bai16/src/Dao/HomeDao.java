package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Emp;
import DB.DBConnection;

public class HomeDao {
	public static List<Emp> displayEmp(int start, int count, Connection conn) {

		List<Emp> listemp = new ArrayList<Emp>();
		String sql = "select * from emp limit "+(start-1)+", "+count+"";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Float salary = rs.getFloat("salary");
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				listemp.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listemp;

	}
	public  static int countRow(Connection conn){
		int count =0;
		String sql = "select count (*) from emp";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}