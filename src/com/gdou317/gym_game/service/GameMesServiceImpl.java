package com.gdou317.gym_game.service;

import com.gdou317.gym_game.dao.GameMesDao;
import com.gdou317.gym_game.model.GameMes;
import com.gdou317.gym_game.vo.Msg;
import com.gdou317.gym_game.vo.ObjsRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("gameMesService")
@Transactional
public class GameMesServiceImpl implements GameMesService{
    @Autowired
    private GameMesDao gameMesDao;

    @Override
    public ObjsRespond<Msg> saveEntity(GameMes gameMes)
    {
        ObjsRespond<Msg> objsRespond = new ObjsRespond<>();
        int rs = gameMesDao.saveEntity(gameMes);
        if (rs >= 0){
            objsRespond.setMsg("添加赛事成功");
        }else {
            objsRespond.setMsg("添加赛事失败");
        }
//        System.out.println(objsRespond.getMsg());
        return objsRespond;
    }
    @Override
    public ObjsRespond<List<GameMes>> findOneGame(int gameId) {
        ObjsRespond<List<GameMes>> objsRespond = new ObjsRespond<>();
        List<GameMes> allGameMes = null;
        allGameMes = gameMesDao.findOneGame(gameId);
            objsRespond.setObjs(allGameMes);
        return objsRespond;
    }


    @Override
    public ObjsRespond<List<GameMes>> findGameByReviseStatus(String revise_Status) {
        ObjsRespond<List<GameMes>> objsRespond = new ObjsRespond<>();
        List<GameMes> allGameMes = null;
        allGameMes = gameMesDao.findGameByReviseStatus(revise_Status);
        if (allGameMes.size() == 0){
            objsRespond.setMsg("当前没有未审核的赛事预约信息！");
            System.out.println("当前没有未审核的赛事预约信息！");
        }else {
            objsRespond.setObjs(allGameMes);
//            System.out.println("当前没有未审核的赛事预约信息！");
        }
        return objsRespond;
    }


    @Override
    public ObjsRespond<List<GameMes>> searchGame(String gameItem,String gameDay,String gameTime) {
        ObjsRespond<List<GameMes>> objsRespond = new ObjsRespond<>();
        List<GameMes> allGame = null;
        allGame = gameMesDao.searchGame(gameItem,gameDay,gameTime);
        if (allGame.size() == 0){
            objsRespond.setMsg("当前没有赛事！");
        }else {
            objsRespond.setObjs(allGame);
        }
        return objsRespond;
    }

    @Override
    public ObjsRespond<Msg> assessTrue(GameMes gameMes) {
        ObjsRespond<Msg> objsRespond = new ObjsRespond<>();
        try
        {
            gameMesDao.assessTrue(gameMes);
            objsRespond.setMsg("审核成功");
            return objsRespond;
        }
        catch (Exception e)
        {
            objsRespond.setMsg("审核失败");
            e.printStackTrace();
            return objsRespond;
        }
    }

}
