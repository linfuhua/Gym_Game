package com.gdou317.gym_game.dao;
import java.util.List;

import com.gdou317.gym_game.model.GameMes;

public interface GameMesDao {
//    List<GameMes> findInPage(int pageNo, int pageSize);
//
//    List<GameMes> findAllSiteInfo();

    int saveEntity(GameMes gameMes);

//    void saveOrUpdateEntity(GameMes siteInfo);
//
   void assessTrue(GameMes gameMes);

//    GameMes getByName(String sitename);
//
//    GameMes getByNo(String siteno);
//
//    GameMes getById(int id);
//
//    void deleteSiteInfoById(Integer id);
//
//    void deleteSiteInfoByNo(String siteno);
//
//    void deleteSiteInfoByEntity(GameMes siteInfo);
//
    List<GameMes> findOneGame(int gameId);
    List<GameMes> findGameByReviseStatus(String revise_Status);
    List<GameMes> searchGame(String gameItem,String gameDay,String gameTime);
}
