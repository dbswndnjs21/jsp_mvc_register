package test.dao;

import test.db.JdbcUtil;
import test.dto.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {

    public int insert(Member vo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "insert into member values (?, ?, ?, ?, sysdate)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPwd());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());
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
