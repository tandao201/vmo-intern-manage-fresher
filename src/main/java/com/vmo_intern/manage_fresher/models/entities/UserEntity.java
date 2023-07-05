package com.vmo_intern.manage_fresher.models.entities;

import com.vmo_intern.manage_fresher.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_office")
    private int idOffice;
    @Column(name = "id_role")
    private int idRole;
    private String name;
    private int gender;
    private String address;
    private String avatar;
    private String email;
    private String phone;

    public UserEntity() {
    }

    public UserEntity(int id, int idOffice, int idRole, String name, int gender, String address, String avatar, String email, String phone) {
        this.id = id;
        this.idOffice = idOffice;
        this.idRole = idRole;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;

        Date now = new Date();
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

    public UserEntity(int id, int idOffice, int idRole, String name, int gender, String address, String avatar, String email, String phone, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idOffice = idOffice;
        this.idRole = idRole;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;

        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public static UserEntity clone(UserEntity userEntity) {
        return new UserEntity(
                userEntity.id,
                userEntity.idOffice,
                userEntity.idRole,
                userEntity.name,
                userEntity.gender,
                userEntity.address,
                userEntity.avatar,
                userEntity.email,
                userEntity.phone,
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", idOffice=" + idOffice +
                ", idRole=" + idRole +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
