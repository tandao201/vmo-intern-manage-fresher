package com.vmo_intern.manage_fresher.models.entities;

import com.alibaba.fastjson.JSON;
import com.vmo_intern.manage_fresher.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "office")
@Data
@EqualsAndHashCode(callSuper = true)
public class OfficeEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
    private String introduction;

    public OfficeEntity() {
    }

    public OfficeEntity(int id, String name, String address, String phone, String introduction) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.introduction = introduction;

        Date now = new Date();
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

    public OfficeEntity(int id, String name, String address, String phone, String introduction, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.introduction = introduction;

        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public static OfficeEntity clone(OfficeEntity officeEntity) {
        return new OfficeEntity(
                officeEntity.id,
                officeEntity.name,
                officeEntity.address,
                officeEntity.phone,
                officeEntity.introduction,
                officeEntity.getCreatedAt(),
                officeEntity.getUpdatedAt()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
