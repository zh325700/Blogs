/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import ejb.LoginDao;
import ejb.NewsEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zhanghan
 */
@Stateless
public class NewsEntityFacade extends AbstractFacade<NewsEntity> {

@PersistenceContext(unitName = "Blogs-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsEntityFacade() {
        super(NewsEntity.class);
    }
    
    public List<NewsEntity> findNewsByUser(LoginDao user){
        List<NewsEntity> newsOfCertainUser = null;
        newsOfCertainUser = em.createNamedQuery("NewsEntity.findByUser", NewsEntity.class).setParameter("user", user).getResultList();
        return newsOfCertainUser;
    }
    
}
