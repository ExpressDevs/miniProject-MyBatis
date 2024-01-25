package com.ohgiraffers.model.DTO;

public class MemberDTO {

    private String memberName;
    private int memberAge;
    private String id;
    private String password;
    private int memberMileage =0;
    private int memberLogin = 1;
    public MemberDTO() {
    }

    public MemberDTO(String memberName, int memberAge, String id, String password, int memberMileage) {
        this.memberName = memberName;
        this.memberAge = memberAge;
        this.id = id;
        this.password = password;
        this.memberMileage = memberMileage;
    }

    public MemberDTO(String id, String password, int memberLogin) {
        this.id = id;
        this.password = password;
        this.memberLogin = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }

    public int getMemberMileage() {
        return memberMileage;
    }

    public void setMemberMileage(int memberMileage) {
        this.memberMileage = memberMileage;
    }

    public void addMileage(int mileage) {
        this.memberMileage += mileage;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + memberName + '\'' +
                ", age=" + memberAge +
                ", id='" + id + '\'' +
                ", pwd='" + password + '\'' +
                ", mileage=" + memberMileage +
                '}';
    }
}

