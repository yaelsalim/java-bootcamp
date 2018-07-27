package com.globant.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.globant.database.DbConnection;

public class Demo {

	public static void main(String[] args) {
		String sql = "SELECT CONCAT(t.first_name,' ', t.last_name) AS   'Teacher :',''   AS 'Schedule :',CONCAT(s.day_of_the_week,' ',s.start_time,' ',s.finish_time , ':', c.name) AS ''FROM `high-school`.`course` c JOIN `high-school`.`teacher` t ON (c.assigned_teacher = t.id_teacher) JOIN  `high-school`.`assigned_schedule` asg ON (c.id_course = asg.id_schedule)	JOIN `high-school`.`schedule` s ON (asg.id_schedule = s.id_schedule)GROUP BY t.id_teacher ;";
		Connection conn = null;

		try {
			conn = DbConnection.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(rs.getRow()));
			}
			rs.close();
			ps.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
