package com.vmo_intern.manage_fresher.models.entities;

import com.vmo_intern.manage_fresher.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "example")
@Data
@EqualsAndHashCode(callSuper = true)
public class ExampleEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public ExampleEntity() {
    }

    public ExampleEntity(int id, String name) {
        this.id = id;
        this.name = name;
        Date now = new Date();
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

    public ExampleEntity(int id, String name,Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public static ExampleEntity clone (ExampleEntity entity) {
        return new ExampleEntity(entity.id, entity.name, entity.getCreatedAt(), entity.getUpdatedAt());
    }

    @Override
    public String toString() {
        return "ExampleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + super.getCreatedAt() +
                ", updatedAt=" + super.getUpdatedAt() +
                '}';
    }
}
