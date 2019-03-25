package com.gdou317.gym_game.action;

import com.gdou317.gym_game.model.GameMes;
import com.gdou317.gym_game.model.GameOrder;
import com.gdou317.gym_game.service.GameMesService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParentPackage("json-default")
@Controller("gameMesAction")
@Scope("prototype")
public class GameMesAction extends ActionSupport implements ModelDriven<GameMes> {
    private GameMes gameMes;

    //将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
    Map<String,Object> map = new HashMap<>();

    private HttpServletRequest request;
    private String result;

    private String reviseStatus;

    private String gameItem;
    private String gameDay;
    private String gameTime;

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public String getReviseStatus() {
        return reviseStatus;
    }

    public String getGameItem() {
        return gameItem;
    }

    public void setGameItem(String gameItem) {
        this.gameItem = gameItem;
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

    public void setReviseStatus(String reviseStatus) {
        this.reviseStatus = reviseStatus;
    }

    @Autowired
    private GameMesService gameMesService;

    @Override
    public GameMes getModel() {
        if(gameMes == null){
            gameMes = new GameMes();
        }
        return gameMes;
    }
    public GameMes getGameMes() {
        return gameMes;
    }

    public void setGameMes(GameMes gameMes) {
        this.gameMes = gameMes;
    }

    @Action(value = "reserverGame")
    public String ReserverGame() throws IOException {
        GameMes gameMes = new GameMes();
        BeanUtils.copyProperties(this.getModel(),gameMes);
        ObjsRespond<Msg> objsRespond = gameMesService.saveEntity(gameMes);
//        System.out.println(objsRespond.getMsg());
        ResultUtils.toJson(ServletActionContext.getResponse(), objsRespond);
        return null;
    }

    @Action(value = "allGame")
    public String findOneGame() throws IOException {
        GameMes gameMes = new GameMes();
        BeanUtils.copyProperties(this.getModel(),gameMes);
        int gameId = gameMes.getGameId();
        ObjsRespond<List<GameMes>> objsRespond = gameMesService.findOneGame(gameId);
        ResultUtils.toJson(ServletActionContext.getResponse(), objsRespond);
        return null;
    }

    @Action(value = "assessGame")
    public String AssessGame() throws IOException {
        GameMes gameMes = new GameMes();
        BeanUtils.copyProperties(this.getModel(),gameMes);
        String revise_Status = gameMes.getReviseStatus();
        ObjsRespond<List<GameMes>> objsRespond = gameMesService.findGameByReviseStatus(revise_Status);
//        System.out.println(revise_Status);
//        System.out.println(gameMes.getReviseStatus());
        ResultUtils.toJson(ServletActionContext.getResponse(), objsRespond);
//        System.out.println("haha");
        return null;
    }

    @Action(value = "searchGame")
    public String searchGame() throws IOException{
        GameMes gameMes = new GameMes();
        BeanUtils.copyProperties(this.getModel(),gameMes);
        String gameItem = gameMes.getGameItem();
        String gameDay = gameMes.getGameDay();
        String gameTime = gameMes.getGameTime();
        System.out.println(gameItem+gameDay+gameTime);
        ObjsRespond<List<GameMes>> objsRespond = gameMesService.searchGame(gameItem,gameDay,gameTime);
        ResultUtils.toJson(ServletActionContext.getResponse(), objsRespond);
        return null;
    }

    @Action(value = "assessTrue")
    public String assessTrue() throws IOException{
        GameMes gameMes = new GameMes();
        BeanUtils.copyProperties(this.getModel(),gameMes);
        System.out.println(gameItem+gameDay+gameTime);
        ObjsRespond<Msg> objsRespond = gameMesService.assessTrue(gameMes);
        ResultUtils.toJson(ServletActionContext.getResponse(), objsRespond);
        return null;
    }



}
