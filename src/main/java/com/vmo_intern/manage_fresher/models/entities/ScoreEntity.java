package com.vmo_intern.manage_fresher.models.entities;

import com.alibaba.fastjson.JSON;
import com.vmo_intern.manage_fresher.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_score_entities")
@Setter

@Getter

@AllArgsConstructor

@ToString
public class ScoreEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_entity_id")
    private int idFresher;
    @Column(name = "exam_order")
    private int examOrder;
    @Column(name = "exam_name")
    private String examName;
    private double result;
    @Column(name = "score_entities_id")
    private int scoreEntitiesId;

    public ScoreEntity() {
    }

    public ScoreEntity(int id, int idFresher, int examOrder, double result, String examName, int scoreEntitiesId) {
        this.id = id;
        this.idFresher = idFresher;
        this.examOrder = examOrder;
        this.examName = examName;
        this.result = result;
        this.scoreEntitiesId = scoreEntitiesId;

        Date now = new Date();
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

    public ScoreEntity(int idFresher, int examOrder, String examName, double result) {

        this.idFresher = idFresher;
        this.examOrder = examOrder;
        this.examName = examName;
        this.result = result;

        Date now = new Date();
        this.setCreatedAt(now);
        this.setUpdatedAt(now);
    }

    public ScoreEntity(int id, int idFresher, int examOrder, String examName, double result, int scoreEntitiesId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idFresher = idFresher;
        this.examOrder = examOrder;
        this.examName = examName;
        this.result = result;
        this.scoreEntitiesId = scoreEntitiesId;

        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public static ScoreEntity clone(ScoreEntity scoreEntity) {
        return new ScoreEntity(
                scoreEntity.id,
                scoreEntity.idFresher,
                scoreEntity.examOrder,
                scoreEntity.examName,
                scoreEntity.result,
                scoreEntity.scoreEntitiesId,
                scoreEntity.getCreatedAt(),
                scoreEntity.getUpdatedAt()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFresher() {
        return idFresher;
    }

    public void setIdFresher(int idFresher) {
        this.idFresher = idFresher;
    }

    public int getExamOrder() {
        return examOrder;
    }

    public void setExamOrder(int examOrder) {
        this.examOrder = examOrder;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getScoreEntitiesId() {
        return scoreEntitiesId;
    }

    public void setScoreEntitiesId(int scoreEntitiesId) {
        this.scoreEntitiesId = scoreEntitiesId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
