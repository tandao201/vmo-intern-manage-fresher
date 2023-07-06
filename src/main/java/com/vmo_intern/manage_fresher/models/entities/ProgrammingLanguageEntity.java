package com.vmo_intern.manage_fresher.models.entities;

import com.alibaba.fastjson.JSON;
import com.vmo_intern.manage_fresher.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "programming_language")
@Data
public class ProgrammingLanguageEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    public ProgrammingLanguageEntity() {
    }

    public ProgrammingLanguageEntity(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
