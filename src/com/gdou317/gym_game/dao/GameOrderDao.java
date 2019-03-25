package com.gdou317.gym_game.dao;

import com.gdou317.gym_game.model.GameOrder;

import java.util.List;

public interface GameOrderDao {
    List<GameOrder> findAllOrder();
    List<GameOrder>findOrderByStatus(String orderStatus);
//
//    int saveEntity(GameOrder gameOrder);
//
//    void saveOrUpdateEntity(GameOrder gameOrder);
//
//    void updateEntity(GameOrder gameOrder);
//
//    GameOrder getByStuName(String stuName);
//
//    GameOrder getByStuNo(String stuNo);
//
//    GameOrder getByOrderNo(String orderNo);

    void deleteOrderById(Integer id);

//    void deleteSiteOrderByNo(String orderNo);
//
//    void deleteSiteOrderByEntity(GameOrder gameOrder);
//
//    boolean checkOrder(int siteid, String dateline, String period);
}
