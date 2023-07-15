package com.vmo_intern.manage_fresher.models.entities;

import com.alibaba.fastjson.JSON;
import com.vmo_intern.manage_fresher.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity implements Serializable {

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


    @OneToMany
    private List<ProgrammingLanguageEntity> programmingLanguageEntities;

    @OneToMany
    private List<ScoreEntity> scoreEntities;

    @Column(name = "average_score")
    private double averageScore;

    public UserEntity() {
    }

    public UserEntity(int id, int idOffice, int idRole, String name, int gender, String address, String avatar, String email, String phone, List<ProgrammingLanguageEntity> programmingLanguageEntities, List<ScoreEntity> scoreEntities, double averageScore) {
        this.id = id;
        this.idOffice = idOffice;
        this.idRole = idRole;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;
        this.programmingLanguageEntities = programmingLanguageEntities;
        this.scoreEntities = scoreEntities;
        this.averageScore = averageScore;

        Date now = new Date();
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

    public UserEntity(int id, int idOffice, int idRole, String name, int gender, String address, String avatar, String email, String phone, List<ProgrammingLanguageEntity> programmingLanguageEntities, List<ScoreEntity> scoreEntities, double averageScore, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idOffice = idOffice;
        this.idRole = idRole;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;
        this.programmingLanguageEntities = programmingLanguageEntities;
        this.scoreEntities = scoreEntities;
        this.averageScore = averageScore;

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
                userEntity.programmingLanguageEntities,
                userEntity.scoreEntities,
                userEntity.averageScore,
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

    public List<ProgrammingLanguageEntity> getProgrammingLanguageEntities() {
        return programmingLanguageEntities;
    }

    public void setProgrammingLanguageEntities(List<ProgrammingLanguageEntity> programmingLanguageEntities) {
        this.programmingLanguageEntities = programmingLanguageEntities;
    }

    public List<ScoreEntity> getScoreEntities() {
        return scoreEntities;
    }

    public void setScoreEntities(List<ScoreEntity> scoreEntities) {
        this.scoreEntities = scoreEntities;
    }

    public double getAverageScore() {
        if (scoreEntities == null) return 0;
        double total = 0;
        for (ScoreEntity scoreEntity: scoreEntities) {
            total += scoreEntity.getResult();
        }
        return total / 3;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
