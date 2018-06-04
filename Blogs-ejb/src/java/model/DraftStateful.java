/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ejb.NewsEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;

/**
 *
 * @author zhanghan
 */
@Named
@Stateful
public class DraftStateful {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    List<NewsEntity> myList = new ArrayList<>();

    public List<NewsEntity> getMyList() {
        return myList;
    }

    public void setMyList(List<NewsEntity> myList) {
        this.myList = myList;
    }
    
    public void addToList(NewsEntity i)
    {
        myList.add(i);
    }
    
    
    
}
