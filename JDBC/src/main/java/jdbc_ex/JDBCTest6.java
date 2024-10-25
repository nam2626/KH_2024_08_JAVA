package jdbc_ex;

import config.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest6 {
    public static void main(String[] args) {
      try(Connection conn = DBManager.getInstance().getConnection()) {
                String sql = "SELECT * FROM PERSON";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(
                            rs.getString("PID") + "/"
                                    + rs.getString(2));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
