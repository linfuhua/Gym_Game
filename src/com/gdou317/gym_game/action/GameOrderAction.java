package com.gdou317.gym_game.action;

import com.gdou317.gym_game.model.GameMes;
import com.gdou317.gym_game.model.GameOrder;
import com.gdou317.gym_game.service.GameMesService;
import com.gdou317.gym_game.service.GameOrderService;
import com.gdou317.gym_game.utils.ResultUtils;
import com.gdou317.gym_game.vo.Msg;
import com.gdou317.gym_game.vo.ObjsRespond;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@ParentPackage("json-default")
@Controller("gameOrderAction")
@Scope("prototype")
public class GameOrderAction extends ActionSupport implements ModelDriven<GameOrder> {
    public GameOrder gameOrder;

    @Autowired
    private GameOrderService gameOrderService;

//    @Autowired
//    private GameMesService gameMesService;

    @Override
    public GameOrder getModel() {
        if(gameOrder == null){
            gameOrder = new GameOrder();
        }
        return gameOrder;
    }
    private HttpServletRequest request;

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Action(value="orderAll")
    public String showAllResult() throws IOException {
        List<GameOrder> list = gameOrderService.findAllOrder();
        ObjsRespond<List<GameOrder>> objsRespond = new ObjsRespond<>();
        objsRespond.setObjs(list);
        ResultUtils.toJson(ServletActionContext.getResponse(), objsRespond);
        return null;
    }

    @Action(value = "findOrderByStatus")
    public String findOrderByStatus() throws IOException{
        GameOrder gameOrder = new GameOrder();
        BeanUtils.copyProperties(this.getModel(),gameOrder);
        String orderStatus = gameOrder.getOrderstatus();
        System.out.println(orderStatus);
        ObjsRespond<List<GameOrder>> objsRespond = gameOrderService.findOrderByStatus(orderStatus);
        ResultUtils.toJson(ServletActionContext.getResponse(), objsRespond);
        return null;
    }

    @Action(value= "deleteOrder")
    public String delOrder() throws IOException {
        GameOrder gameOrder = new GameOrder();
        BeanUtils.copyProperties(this.getModel(),gameOrder);
        int id = gameOrder.getOrderID();
        System.out.println(id);
        ObjsRespond<Msg> objsRespond = gameOrderService.deleteOrderById(id);
        System.out.println("haha");
        ResultUtils.toJson(ServletActionContext.getResponse(), objsRespond);
        return null;
    }

}
