package com.vmo_intern.manage_fresher.models.dto_entities;

import com.alibaba.fastjson.JSON;

public class OfficeEntityDto {
    private String name;
    private String address;
    private String phone;
    private String introduction;

    public OfficeEntityDto() {
    }

    public OfficeEntityDto(String name, String address, String phone, String introduction) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.introduction = introduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
