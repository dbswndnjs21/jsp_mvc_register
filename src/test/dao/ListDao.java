package test.dao;

import test.db.JdbcUtil;
import test.dto.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListDao {

    public ArrayList<Member> select() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "select * from member";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            ArrayList<Member> lists = new ArrayList<Member>();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("id"));
                member.setPwd(rs.getString("pwd"));
                member.setEmail(rs.getString("email"));
                member.setAge(rs.getInt("age"));
                member.setRegdate(rs.getDate("regdate"));
                lists.add(member);
            }
            return lists;
        } catch (SQLException e) {
            e.getMessage();
            return null;
        } finally {
            JdbcUtil.close(con, pstmt, rs);
        }
    }
}
