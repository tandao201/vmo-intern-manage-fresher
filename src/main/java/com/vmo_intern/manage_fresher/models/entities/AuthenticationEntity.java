package com.vmo_intern.manage_fresher.models.entities;

import com.alibaba.fastjson.JSON;
import com.vmo_intern.manage_fresher.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "authentication")
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthenticationEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_user")
    private int idUser;
    private String username;
    private String password;

    public AuthenticationEntity() {
    }

    public AuthenticationEntity(int id, int idUser, String username, String password) {
        this.id = id;
        this.idUser = idUser;
        this.username = username;
        this.password = password;

        Date now = new Date();
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

    public AuthenticationEntity(int id, int idUser, String username, String password, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idUser = idUser;
        this.username = username;
        this.password = password;

        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public static AuthenticationEntity clone(AuthenticationEntity authenticationEntity) {
        return new AuthenticationEntity(
                authenticationEntity.id,
                authenticationEntity.idUser,
                authenticationEntity.username,
                authenticationEntity.password,
                authenticationEntity.getCreatedAt(),
                authenticationEntity.getUpdatedAt()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
