package com.gdou317.gym_game.service;

import com.gdou317.gym_game.model.GameMes;
import com.gdou317.gym_game.vo.Msg;
import com.gdou317.gym_game.vo.ObjsRespond;

import java.util.List;

public interface GameMesService {
//    List<GameMes> findInPage(int pageNo, int pageSize);
//
//    List<GameMes> findAllSiteInfo();

    ObjsRespond<Msg> saveEntity(GameMes gameMes);

//    boolean saveOrUpdateEntity(GameMes siteInfo);
//
ObjsRespond<Msg> assessTrue(GameMes siteInfo);
//
//    GameMes getByName(String sitename);
//
//    GameMes getByNo(String siteno);
//
//    GameMes getById(int id);
//
//    ObjsRespond<Msg> deleteSiteInfoById(Integer id);
//
//    boolean deleteSiteInfoByNo(String siteno);
//
//    boolean deleteSiteInfoByEntity(GameMes siteInfo);
//
ObjsRespond<List<GameMes>> findOneGame(int gameId);
   ObjsRespond<List<GameMes>> findGameByReviseStatus(String revise_Status);
   ObjsRespond<List<GameMes>> searchGame(String gameItem,String gameDay,String gameTime);
}
