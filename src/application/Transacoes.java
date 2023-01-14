package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Transacoes {

	public static void main(String[] args){
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			int rows1 = st.executeUpdate("update seller set basesalary = 2090 where departmentid = 1");
			if(false) {
				throw new SQLException("fake error");
			}
			int rows2 = st.executeUpdate("update seller set basesalary = 3090 where departmentid = 2");
			conn.commit();
			System.out.println("rows1 "+rows1);
			System.out.println("rows2 "+rows2);
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("transaction rolled back, "+e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("error trying to rollback, "+e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}
