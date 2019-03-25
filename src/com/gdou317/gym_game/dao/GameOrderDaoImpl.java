package com.gdou317.gym_game.dao;

import com.gdou317.gym_game.model.GameOrder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("gameOrderDao")
public class GameOrderDaoImpl extends HibernateDaoSupport implements GameOrderDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<GameOrder> findAllOrder() {
        Session session = sessionFactory.openSession();
        //将所有的数据查询出来并放到List集合里 SiteInfo是表对应的实例名称
        List<GameOrder> list = session.createQuery("from GameOrder ").list();
        System.out.println("hahahaha");
//        System.out.println(list.size());
//        session.close();
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<GameOrder> findOrderByStatus(String orderStatus) {
        Session session = sessionFactory.openSession();
        //将所有的数据查询出来并放到List集合里 SiteInfo是表对应的实例名称
        List<GameOrder> list = session.createQuery("from GameOrder where orderstatus='" + orderStatus +"'").list();
        System.out.println("hahahaha");
////        System.out.println(list.size());
//        session.close();
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteOrderById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "delete from GameOrder where orderID=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id",id);
        query.executeUpdate();
    }
}
