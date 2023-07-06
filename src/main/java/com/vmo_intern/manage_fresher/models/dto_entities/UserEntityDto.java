package com.vmo_intern.manage_fresher.models.dto_entities;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class UserEntityDto {
    private int idOffice;
    private int idRole;
    private String name;
    private int gender;
    private String address;
    private String avatar;
    private String email;
    private String phone;
    private List<Integer> programmingLanguageIds;

    public UserEntityDto() {
    }

    public UserEntityDto(int idOffice, int idRole, String name, int gender, String address, String avatar, String email, String phone, List<Integer> programmingLanguageIds) {
        this.idOffice = idOffice;
        this.idRole = idRole;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;
        this.programmingLanguageIds = programmingLanguageIds;
    }

    public int getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(int idOffice) {
        this.idOffice = idOffice;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getProgrammingLanguageIds() {
        return programmingLanguageIds;
    }

    public void setProgrammingLanguageIds(List<Integer> programmingLanguageIds) {
        this.programmingLanguageIds = programmingLanguageIds;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
