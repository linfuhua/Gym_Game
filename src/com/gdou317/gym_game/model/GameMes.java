package com.gdou317.gym_game.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "gamemes")
public class GameMes implements Serializable {
    private static final long serialVersionUID = 2313421496945642L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;
    private String applicant;
    private String applyUnit;
    private String phone;
    private String gameItem;
    private String gamePlace;
    private String gameDay;
    private String gameTime;
    private String opponent;
    private String note;
    private String reviseStatus;
    private String makeStatus;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplyUnit() {
        return applyUnit;
    }

    public void setApplyUnit(String applyUnit) {
        this.applyUnit = applyUnit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGameItem() {
        return gameItem;
    }

    public void setGameItem(String gameItem) {
        this.gameItem = gameItem;
    }

    public String getGamePlace() {
        return gamePlace;
    }

    public void setGamePlace(String gamePlace) {
        this.gamePlace = gamePlace;
    }

    public String getGameDay() {
        return gameDay;
    }

    public void setGameDay(String gameDay) {
        this.gameDay = gameDay;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReviseStatus() {
        return reviseStatus;
    }

    public void setReviseStatus(String reviseStatus) {
        this.reviseStatus = reviseStatus;
    }

    public String getMakeStatus() {
        return makeStatus;
    }

    public void setMakeStatus(String makeStatus) {
        this.makeStatus = makeStatus;
    }
}
