/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import ejb.LoginDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author zhanghan
 */
public class DataQuery {
    
    EntityManagerFactory emf;
    EntityManager em;
    private LoginDao myUser;
    
    public DataQuery(){
        emf = Persistence.createEntityManagerFactory("Blogs-ejbPU");
        em = emf.createEntityManager();
        UserTransaction transaction = null;
        try {
            transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
        } catch (NamingException ex) {
            Logger.getLogger(DataQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            transaction.begin();
        } catch (NotSupportedException ex) {
            Logger.getLogger(DataQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(DataQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean loginControl(String username, String password){
        try{
            LoginDao l = em.createNamedQuery("LoginDao.control",LoginDao.class).setParameter("username",username).setParameter("password",password).getSingleResult();
            
            if(l !=null){
                setMyUser(l);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
        
    }

    public LoginDao getMyUser() {
        return myUser;
    }

    public void setMyUser(LoginDao myUser) {
        this.myUser = myUser;
    }

}
