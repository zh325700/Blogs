/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import ejb.Event;
import ejb.Person;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author Yunying
 */
@Singleton
@Startup
public class ConfigBean {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init(){
        
        Person zh = new Person();
        zh.setName("zhanghan");
        em.persist(zh);
        
        Person myy = new Person();
        zh.setName("mayunying");
        em.persist(myy);
        
        Person wsy = new Person();
        wsy.setName("wangsy");
        em.persist(wsy);
        
        
        Event stuevent = new Event();
        stuevent.setName("Java EE study");
        em.persist(stuevent);
        
        Event playevent = new Event();
        playevent.setName("Java EE study");
        em.persist(playevent);
        
        //set relation
        zh.getOwnedEvents().add(stuevent);
        zh.getOwnedEvents().add(playevent);
        
        zh.getEvents().add(stuevent);
        stuevent.getInvitees().add(zh);      
       
        myy.getEvents().add(stuevent);
        stuevent.getInvitees().add(myy);
             
        wsy.getEvents().add(stuevent);
        stuevent.getInvitees().add(wsy);
        
        
        
        
        
        

       
        
        
        
    }


    

    
}
