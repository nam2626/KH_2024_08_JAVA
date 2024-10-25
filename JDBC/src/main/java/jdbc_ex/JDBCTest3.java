package jdbc_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest3 {
    public static void main(String[] args) {
        //Person 데이터 한건을 사용자로 부터 입력받아서
        //데이터 베이스 Person 테이블에 추가
        //pid, pname, age 입력받아서 테이블 추가
        Scanner sc = new Scanner(System.in);
        System.out.println("pid를 입력하세요");
        String pid = sc.nextLine();
        System.out.println("pname을 입력하세요");
        String pname = sc.nextLine();
        System.out.println("age를 입력하세요");
        int age = sc.nextInt();

        try(Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "C##SCOTT", "TIGER")) {
            //String sql = "insert into person values('"+pid+"', '"+pname+"', "+age+")";
            String sql = String.format("insert into person values('%s','%s',%d)",
                                                                    pid, pname, age);
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("몇건 적용" + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
