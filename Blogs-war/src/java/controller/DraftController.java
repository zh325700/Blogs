/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.NewsEntity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import model.DraftStateful;

/**
 *
 * @author zhanghan
 */
@Named
@SessionScoped
public class DraftController implements Serializable {

    @Inject
    DraftStateful myDraft;
    
    NewsEntity i = new NewsEntity();
    String title;
    String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    
    public DraftController() {
    }
    
    public void doAdd(){
        i.setTitle(title);
        i.setBody(body);
        myDraft.addToList(i);
        i = new NewsEntity();
    }

    public DraftStateful getMyDraft() {
        return myDraft;
    }

    public void setMyDraft(DraftStateful myDraft) {
        this.myDraft = myDraft;
    }
    
    public List<NewsEntity> doGetArray(){
        return myDraft.getMyList();
    }



    public NewsEntity getI() {
        return i;
    }

    public void setI(NewsEntity i) {
        this.i = i;
    }
    
    
    
}
