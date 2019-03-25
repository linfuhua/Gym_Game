package com.gdou317.gym_game.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "gameorder")
public class GameOrder implements Serializable {

    private static final long serialVersionUID = 2313421496945642L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int orderID;
    private String gameID;
    private String orderUer;
    private String orderTime;
    private String gameItem;
    private String gamePlace;
    private String gameDay;
    private String gameTime;
    private String orderCost;
    private String orderstatus;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getOrderUer() {
        return orderUer;
    }

    public void setOrderUer(String orderUer) {
        this.orderUer = orderUer;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
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

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }
}
