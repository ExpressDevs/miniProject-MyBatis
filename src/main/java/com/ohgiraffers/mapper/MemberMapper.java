package com.ohgiraffers.mapper;

import com.ohgiraffers.model.DTO.MemberDTO;

import java.util.List;

public interface MemberMapper {

    int insertMember(MemberDTO memberDTO);
    int insertNonMember(MemberDTO memberDTO);
    boolean signUpIdCheck(String id);

    boolean loginCheck(String id, String pwd);

    MemberDTO nowLoginMember(String id);


}
