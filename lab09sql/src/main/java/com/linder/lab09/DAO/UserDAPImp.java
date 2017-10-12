package com.linder.lab09.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.linder.lab09.DAO.UserDAO;
import com.linder.lab09.db.ConnectionDB;
import com.linder.lab09.bean.User;

public class UserDAPImp implements UserDAO {
	@Override
	public ArrayList<User> findAll() {

		System.out.println("getEmployees()");

		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = ConnectionDB.getConnection();
		String stm = "Select employee_id, first_name, last_name, salary from employees_2 order by employee_id";
		ArrayList<User> records = new ArrayList<User>();
		
		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				User emp = new User();
				emp.setId(rs.getInt(1));
				emp.setFirstname(rs.getString(2));
				emp.setLastname(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				records.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return records;
	}

}
