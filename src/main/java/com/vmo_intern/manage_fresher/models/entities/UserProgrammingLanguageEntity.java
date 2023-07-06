package com.vmo_intern.manage_fresher.models.entities;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_programming_language_entities")
@Data
public class UserProgrammingLanguageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_entity_id")
    private int userEntityId;
    @Column(name = "programming_language_entities_id")
    private int programmingLanguagesId;

    public UserProgrammingLanguageEntity() {
    }
    public UserProgrammingLanguageEntity(int userEntityId, int programmingLanguagesId) {
        this.userEntityId = userEntityId;
        this.programmingLanguagesId = programmingLanguagesId;
    }

    public UserProgrammingLanguageEntity(int id, int userEntityId, int programmingLanguagesId) {
        this.id = id;
        this.userEntityId = userEntityId;
        this.programmingLanguagesId = programmingLanguagesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserEntityId() {
        return userEntityId;
    }

    public void setUserEntityId(int userEntityId) {
        this.userEntityId = userEntityId;
    }

    public int getProgrammingLanguagesId() {
        return programmingLanguagesId;
    }

    public void setProgrammingLanguagesId(int programmingLanguagesId) {
        this.programmingLanguagesId = programmingLanguagesId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
