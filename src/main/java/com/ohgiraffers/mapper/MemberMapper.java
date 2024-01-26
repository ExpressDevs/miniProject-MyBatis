package com.ohgiraffers.mapper;

import com.ohgiraffers.model.DTO.MemberDTO;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface MemberMapper {

    int insertMember(MemberDTO memberDTO);
    int insertNonMember(MemberDTO memberDTO);
    MemberDTO signUpIdCheck(Map<String, Object> map);



    MemberDTO nowLoginMember(String id);

    int updateMileage(MemberDTO memberDTO);


}
