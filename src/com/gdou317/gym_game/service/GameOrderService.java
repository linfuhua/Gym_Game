package com.gdou317.gym_game.service;

import com.gdou317.gym_game.model.GameOrder;
import com.gdou317.gym_game.vo.Msg;
import com.gdou317.gym_game.vo.ObjsRespond;

import java.util.List;

public interface GameOrderService {
    List<GameOrder> findAllOrder();
//
//    int saveEntity(GameOrder gameOrder);
//
//    boolean saveOrUpdateEntity(GameOrder gameOrder);
//
//    boolean updateEntity(GameOrder gameOrder);
//
//    GameOrder getByStuName(String stuName);
//
//    GameOrder getByStuNo(String stuNo);
//
//    GameOrder getByOrderNo(String orderNo);
//
    ObjsRespond<List<GameOrder>> findOrderByStatus(String orderStatus);
     ObjsRespond<Msg> deleteOrderById(Integer id);
//
//    boolean deleteSiteOrderByNo(String orderNo);
//
//    boolean deleteSiteOrderByEntity(GameOrder gameOrder);
//
//    ObjsRespond<Msg> checkOrder(int siteid, String dateline, String period);
}
