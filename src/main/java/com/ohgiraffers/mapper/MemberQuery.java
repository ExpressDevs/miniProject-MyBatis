package com.ohgiraffers.mapper;

import com.ohgiraffers.model.DTO.MemberDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.close;

public class MemberQuery {



    public void updateMileage(int mileage, String nowLoginMemberId) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result =0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/member-query.xml"));
            String query = prop.getProperty("updateMileage");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, mileage);
            pstmt.setString(2, nowLoginMemberId);

            pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginCheck(String id, String password) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        Boolean check = false;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT id, password FROM tbl_member");

            while (rset.next()) {
                if (rset.getString("id").equals(id) && rset.getString("password").equals(password)) {
                    check = true;
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }

        return check;
    }

    public MemberDTO nowLoginMember(String id) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        MemberDTO member = new MemberDTO();

        String query = "SELECT * FROM tbl_member WHERE id = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rset = pstmt.executeQuery();
            System.out.println();
            while (rset.next()) {
                if (rset.getString("id").equals(id)) {
                    member.setName(rset.getString("member_name"));
                    member.setAge(rset.getInt("member_age"));
                    member.setId(rset.getString("id"));
                    member.setPwd(rset.getString("password"));
                    member.setMileage(rset.getInt("member_mileage"));
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        return member;
    }

    public boolean signUpIdCheck(String id) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Boolean check = false;

        String query = "SELECT id FROM tbl_member WHERE id = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                if (rset.getString("id").equals(id)) {
                    check = true;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
        return check;
    }
}
