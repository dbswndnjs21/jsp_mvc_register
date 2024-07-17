package test.dao;

import test.db.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginDao {

    public boolean isMember(HashMap<String, String> map) {
        String id = map.get("id");
        String pwd = map.get("pwd");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getCon();
            String sql = "select * from member where id = ? and pwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            JdbcUtil.close(conn,pstmt,rs);
        }

    }
}
