package jdbc_ex;

import java.sql.*;

public class JDBCTest1 {
    public static void main(String[] args) {
        try {
            //1. JDBC 드라이버 클래스 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 완료");
            //2. 데이터베이스 접속
            try(Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "C##SCOTT", "TIGER")) {
                System.out.println("데이터베이스 접속 완료");
            //3. SQL문 작성
                String sql = "SELECT * FROM PERSON";
            //4. SQL문 실행 - Statement 객체 생성
                Statement stmt = conn.createStatement();
            //5. SQL문 실행 - SQL문 실행 및 결과 얻기 - Statement 사용
                ResultSet rs = stmt.executeQuery(sql);
            //6. 결과를 받아서 출력
                while(rs.next()){
                    System.out.println(rs.getString(2));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
