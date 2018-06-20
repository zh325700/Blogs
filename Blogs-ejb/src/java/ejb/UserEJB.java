/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zhanghan
 */
@Stateless
public class UserEJB {

    @PersistenceContext(unitName = "Blogs-ejbPU")
    private EntityManager em;
    
     private List<LoginDao> myUser;


    public List<LoginDao> getMyUser() {
        return myUser;
    }

    public void setMyUser(List<LoginDao> myUser) {
        this.myUser = myUser;
    }

    public LoginDao ifhasUser(String username, String password) {
        myUser = em.createNamedQuery("LoginDao.control", LoginDao.class).setParameter("username", username).setParameter("password", password).getResultList();
        if (myUser.isEmpty()) {
            return null;
        } else {
            return myUser.get(0);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
