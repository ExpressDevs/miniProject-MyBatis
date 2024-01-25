package com.ohgiraffers.model.DTO;

public class MemberDTO {

    private String member_name;
    private int member_age;
    private String id;
    private String password;
    private int member_mileage =0;
    private int member_login = 1;
    public MemberDTO() {
    }

    public MemberDTO(String member_name, int member_age, String id, String password, int member_mileage) {
        this.member_name = member_name;
        this.member_age = member_age;
        this.id = id;
        this.password = password;
        this.member_mileage = member_mileage;
    }

    public MemberDTO(String id, String password, int member_login) {
        this.id = id;
        this.password = password;
        this.member_login = 0;
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

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public int getMember_age() {
        return member_age;
    }

    public void setMember_age(int member_age) {
        this.member_age = member_age;
    }

    public int getMember_mileage() {
        return member_mileage;
    }

    public void setMember_mileage(int member_mileage) {
        this.member_mileage = member_mileage;
    }

    public void addMileage(int mileage) {
        this.member_mileage += mileage;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + member_name + '\'' +
                ", age=" + member_age +
                ", id='" + id + '\'' +
                ", pwd='" + password + '\'' +
                ", mileage=" + member_mileage +
                '}';
    }
}

