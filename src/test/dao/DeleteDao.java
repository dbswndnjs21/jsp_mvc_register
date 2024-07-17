package test.dao;

import test.db.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {

    public int delete(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "Delete member where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            JdbcUtil.close(con, pstmt, null);
        }
    }
}
