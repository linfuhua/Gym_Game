package com.gdou317.gym_game.service;

import com.gdou317.gym_game.dao.GameOrderDao;
import com.gdou317.gym_game.model.GameOrder;
import com.gdou317.gym_game.vo.Msg;
import com.gdou317.gym_game.vo.ObjsRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("gameOrderService")
@Transactional
public class GameOrderServiceImpl implements GameOrderService {
    @Autowired
    private GameOrderDao gameOrderDao;

    @Override
    public List<GameOrder> findAllOrder()
    {
        List<GameOrder> allSiteOrder = gameOrderDao.findAllOrder();
        return allSiteOrder;
    }

    @Override
    public ObjsRespond<List<GameOrder>> findOrderByStatus(String orderStatus)
    {
        ObjsRespond<List<GameOrder>> objsRespond = new ObjsRespond<>();
        List<GameOrder> allGame = null;
        allGame = gameOrderDao.findOrderByStatus(orderStatus);
        if (allGame.size() == 0){
            objsRespond.setMsg("当前没有订单！");
        }else {
            objsRespond.setObjs(allGame);
        }
        return objsRespond;
    }

    @Override
    public ObjsRespond<Msg> deleteOrderById(Integer id)
    {
        ObjsRespond<Msg> objsRespond = new ObjsRespond<>();
        try
        {
            gameOrderDao.deleteOrderById(id);
            objsRespond.setMsg("删除成功");
            return objsRespond;
        }
        catch (Exception e)
        {
            objsRespond.setMsg("删除失败");
            e.printStackTrace();
            return objsRespond;
        }
    }
}
