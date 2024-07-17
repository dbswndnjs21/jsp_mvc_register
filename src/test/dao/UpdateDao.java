package test.dao;

import test.db.JdbcUtil;
import test.dto.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateDao {

    public int update(Member vo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "update member set pwd = ?, email = ?, age = ? where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, vo.getPwd());
            pstmt.setString(2, vo.getEmail());
            pstmt.setInt(3, vo.getAge());
            pstmt.setString(4, vo.getId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            JdbcUtil.close(con, pstmt, null);
        }
    }

    public Member select(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "select * from member where id =?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) { // 한줄이 있으면
                Member member = new Member();
                member.setId(rs.getString("id"));
                member.setPwd(rs.getString("pwd"));
                member.setEmail(rs.getString("email"));
                member.setAge(rs.getInt("age"));
                member.setRegdate(rs.getDate("regdate"));
                return member;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.getMessage();
            return null;
        } finally {
            JdbcUtil.close(con, pstmt, rs);
        }
    }

}
