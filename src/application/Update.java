package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Update {

	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
						"update seller "
						+ "set BaseSalary = BaseSalary + ? "
						+ "where (DepartmentId = ?)"
					);
			st.setDouble(1, 200);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("done: "+rowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}
