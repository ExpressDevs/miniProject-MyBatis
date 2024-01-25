package com.ohgiraffers.model.service;

import com.ohgiraffers.mapper.MemberMapper;
import com.ohgiraffers.model.DTO.MemberDTO;
import org.apache.ibatis.session.SqlSession;

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

        String checkId = memberMapper.signUpIdCheck(id);


        boolean check = false;

        if (checkId.equals(id)) {
            check = true;
        }


        return check;
    }
}
