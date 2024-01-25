package com.ohgiraffers.model.service;

import com.ohgiraffers.mapper.MemberMapper;
import com.ohgiraffers.model.DTO.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

import static com.ohgiraffers.common.MemberTemplate.getMemberSqlSession;

public class MemberService {
    private MemberMapper memberMapper;

    public void insertMember(MemberDTO memberDTO) {
        SqlSession sqlSession = getMemberSqlSession();

        memberMapper = sqlSession.getMapper(MemberMapper.class);
        int result = memberMapper.insertMember(memberDTO);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public void insertNonMember(MemberDTO memberDTO) {
        SqlSession sqlSession = getMemberSqlSession();

        memberMapper = sqlSession.getMapper(MemberMapper.class);
        int result = memberMapper.insertNonMember(memberDTO);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public boolean signUpIdCheck(String id) {
        SqlSession sqlSession = getMemberSqlSession();

        memberMapper = sqlSession.getMapper(MemberMapper.class);

        boolean check = false;

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        MemberDTO memberDTO = memberMapper.signUpIdCheck(map);

        if (memberDTO != null) {
            check = true;
        }
        sqlSession.close();
        return check;
    }

    public boolean loginCheck(String id, String password) {
        SqlSession sqlSession = getMemberSqlSession();

        memberMapper = sqlSession.getMapper(MemberMapper.class);

        boolean check = false;

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("password", password);
        MemberDTO memberDTO = memberMapper.loginCheck(map);
        if (memberDTO != null) {
             check = true;
        }
        sqlSession.close();
        return check;
    }

    public MemberDTO nowLoginMember(String id) {
        SqlSession sqlSession = getMemberSqlSession();

        memberMapper = sqlSession.getMapper(MemberMapper.class);

        MemberDTO md = memberMapper.nowLoginMember(id);

        sqlSession.close();
        return md;
    }

    public void updateMileage(MemberDTO memberDTO) {
        SqlSession sqlSession = getMemberSqlSession();

        memberMapper = sqlSession.getMapper(MemberMapper.class);

        int result = memberMapper.updateMileage(memberDTO);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

    }
}
