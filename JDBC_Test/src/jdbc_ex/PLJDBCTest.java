package jdbc_ex;

import java.sql.*;

import oracle.jdbc.OracleTypes;

public class PLJDBCTest {
    public static void main(String[] args) {
        // Oracle DB 연결 정보
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // JDBC URL
        String user = "C##SCOTT"; // 사용자 계정
        String password = "TIGER"; // 비밀번호

        // DB 연결 및 프로시저 호출
        try (Connection conn = DriverManager.getConnection(url, user, password);
             CallableStatement stmt = conn.prepareCall("{call get_students_by_major(?, ?)}")) {

            // 입력 파라미터 설정 (MAJOR_NO)
            stmt.setString(1, "01");

            // 출력 파라미터 등록 (REF CURSOR)
            stmt.registerOutParameter(2, OracleTypes.CURSOR);

            // 프로시저 실행
            stmt.execute();

            // REF CURSOR 가져오기
            ResultSet rs = (ResultSet) stmt.getObject(2);

            // 결과 출력
            while (rs.next()) {
                String stdNo = rs.getString("STD_NO");
                String stdName = rs.getString("STD_NAME");
                double stdScore = rs.getDouble("STD_SCORE");
                String stdGender = rs.getString("STD_GENDER");

                System.out.println("STD_NO: " + stdNo + 
                                   ", Name: " + stdName + 
                                   ", Score: " + stdScore + 
                                   ", Gender: " + stdGender);
            }

            // ResultSet 닫기
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
