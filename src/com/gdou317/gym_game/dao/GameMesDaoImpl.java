package com.gdou317.gym_game.dao;

import com.gdou317.gym_game.model.GameMes;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Repository("gameMesDao")
public class GameMesDaoImpl extends HibernateDaoSupport implements GameMesDao {
    @Autowired
    private SessionFactory sessionFactory;

//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public List<GameMes> findInPage(int pageNo, int pageSize) {
//        Session session = sessionFactory.getCurrentSession();
//        List<GameMes> siteInfos = session.createQuery("from gamemes")
//                .setFirstResult((pageNo-1)*pageSize)//第几条开始拿
//                .setMaxResults(pageSize)//每次第几条
//                .list();
//        return siteInfos;
//    }

//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public List<GameMes> findAllSiteInfo() {
//        Session session  = sessionFactory.openSession();
//        //将所有的数据查询出来并放到List集合里 SiteInfo是表对应的实例名称
//        List<GameMes> list = session.createQuery("from gamemes").list();
//        session.close();
//        return list;
//    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int saveEntity(GameMes gameMes) {
        Session session = sessionFactory.getCurrentSession();
        //返回插入数据的id
        Object id = session.save(gameMes);
        System.out.println(id);
        return Integer.valueOf(id.toString());
    }

//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void saveOrUpdateEntity(GameMes siteInfo) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(siteInfo);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void updateEntity(GameMes siteInfo) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(siteInfo);
//    }

//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public GameMes getByName(String sitename) {
//        Session session = sessionFactory.getCurrentSession();
//        //根据id查询,结果返回 SiteInfo.class
//        GameMes siteInfo = (GameMes) session.get(GameMes.class,2);
//        //将所有的数据查询出来并放到List集合里 SiteInfo是表对应的实例名称
//        List siteInfos = session.createQuery("from SiteInfo where site_name='" + sitename + "'").list();
//        return (GameMes) siteInfos.get(0);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public GameMes getByNo(String siteno) {
//        Session session = sessionFactory.getCurrentSession();
//        GameMes siteInfo = (GameMes) session.get(GameMes.class,2);
//        List siteInfos = session.createQuery("from SiteInfo where site_no='"+siteno+"'").list();
//        return (GameMes) siteInfos.get(0);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public GameMes getById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        GameMes siteInfo = (GameMes) session.get(GameMes.class,2);
//        List siteInfos = session.createQuery("from SiteInfo where id='"+id+"'").list();
//        return (GameMes) siteInfos.get(0);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void deleteSiteInfoById(Integer id) {
//        Session session = sessionFactory.getCurrentSession();
//        String sql = "delete from SiteInfo where id=:id";
//        Query query = session.createQuery(sql);
//        query.setParameter("id",id);
//        query.executeUpdate();
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void deleteSiteInfoByNo(String siteno) {
//        Session session = sessionFactory.getCurrentSession();
//        String sql = "delete from SiteInfo where site_no=:no";
//        Query query = session.createQuery(sql);
//        query.setParameter("no",siteno);
//        query.executeUpdate();
//    }
//
@Override
@Transactional(propagation = Propagation.REQUIRED)
public List<GameMes> findOneGame(int gameId) {
    Session session = sessionFactory.openSession();
        List<GameMes> gameList = session.createQuery("from GameMes where gameId='"+ gameId + "'").list();
    System.out.println(gameList.size());
        session.close();
        System.out.println("haha2");
        return gameList;
}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<GameMes> findGameByReviseStatus(String revise_Status) {
        Session session = sessionFactory.openSession();
//        GameMes gameMes = (GameMes)session.get(GameMes.class,1000);
//        System.out.println(gameMes.getReviseStatus());
        try{
            List gameList = session.createQuery("from GameMes where reviseStatus='"+ revise_Status + "'").list();
//            String sql = "select * from gameMes where reviseStatus:=revise_Status";
//            Query query = session.createQuery(sql);
//            query.setParameter("revise_Status", revise_Status);
//            List gameList = query.list();
            System.out.println(gameList.size());
            session.close();
            System.out.println("haha2");
            return gameList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<GameMes> searchGame(String gameItem,String gameDay,String gameTime) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(gameItem+gameDay+gameTime);
        //根据id查询,结果返回 SiteInfo.class
//        SiteOrder siteOrder = (SiteOrder) session.get(SiteOrder.class,2);
        //将所有的数据查询出来并放到List集合里 SiteInfo是表对应的实例名称
        try {
            List gameList = session.createQuery("from GameMes where gameItem='" + gameItem + "' and gameDay='"+ gameDay +"' and gameTime='"+ gameTime +"'").list();
            System.out.println(gameList.size());
            return gameList;
        }catch (Exception e){
            return null;
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void assessTrue(GameMes gameMes) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(gameMes);
    }
}
