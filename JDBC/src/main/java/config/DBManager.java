package config;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//싱글톤 패턴 적용
public class DBManager {
    //private static으로 인스턴스 생성
    private static DBManager instance = new DBManager();
    private OracleDataSource ods;
    //private 생성자
    private DBManager() {
        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:C##SCOTT/TIGER@localhost:1521:xe");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Connection 하나 생성해서 리턴
    public Connection getConnection() throws SQLException {
        return ods.getConnection();
    }

    //close 메서드
    public void close(Connection conn, Statement stmt, ResultSet rs) {
        try{
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //public static으로 외부에서 접근 가능한 get메서드 생성
    public static DBManager getInstance() {
        if(instance == null)
            instance = new DBManager();
        return instance;
    }

}
