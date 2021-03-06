/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.LoggingInterceptor;
import ejb.LoginDao;
import ejb.NewsEntity;
import ejb.NewsEntity.Categories;
import ejb.SessionManagerBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.bean.ManagedBean;
import javax.interceptor.Interceptors;
import model.NewsEntityFacade;

/**
 *
 * @author zhanghan
 */
@Named(value = "newsController")
@SessionScoped
public class NewsController implements Serializable {

    @EJB
    private SessionManagerBean sessionManagerBean;

    @EJB
    private NewsEntityFacade newsEntityFacade;

    private NewsEntity news;
    private LoginController loginc = new LoginController();
    private LoginDao aUser;
    private Categories choosenCat;
    
    private Categories[] categories = Categories.values();

    public SessionManagerBean getSessionManagerBean() {
        return sessionManagerBean;
    }

    public void setSessionManagerBean(SessionManagerBean sessionManagerBean) {
        this.sessionManagerBean = sessionManagerBean;
    }

    public NewsEntityFacade getNewsEntityFacade() {
        return newsEntityFacade;
    }

    public void setNewsEntityFacade(NewsEntityFacade newsEntityFacade) {
        this.newsEntityFacade = newsEntityFacade;
    }

    public Categories getChoosenCat() {
        return choosenCat;
    }

    public void setChoosenCat(Categories choosenCat) {
        this.choosenCat = choosenCat;
    }

    public Categories[] getCategories() {
        return categories;
    }

    public void setCategories(Categories[] categories) {
        this.categories = categories;
    }

    
    
    public LoginDao getaUser() {
        return aUser;
    }

    public void setaUser(LoginDao aUser) {
        this.aUser = aUser;
    }

    public LoginController getLoginc() {
        return loginc;
    }

    public void setLoginc(LoginController loginc) {
        this.loginc = loginc;
    }

    public NewsEntity getNews() {
        return news;
    }

    public void setNews(NewsEntity news) {
        this.news = news;
    }

    public int getUserCount() {
        return sessionManagerBean.getActiveSessionsCount();
    }

    @PostConstruct
    public void init() {
        news = new NewsEntity();
    }

    public NewsController() {

    }

    @Interceptors({LoggingInterceptor.class})
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public List<NewsEntity> findAll() {
        return this.newsEntityFacade.findAll();
    }

    public String add() {
//        System.out.println("If I got user when add?" + aUser.getUsername());
        this.news.setUser(aUser);
        this.news.setCategory(choosenCat);
        this.newsEntityFacade.create(this.news);
        return "home";
    }

    public void delete(NewsEntity aNew) {
        this.newsEntityFacade.remove(aNew);
    }

    public String edit(NewsEntity aNew) {
        this.news = aNew;
        return "editNews";
    }

    public String edit() {
        this.newsEntityFacade.edit(this.news);
        return "home";
    }

    public String gotonews(LoginDao aUser) {
        this.aUser = aUser;
        return "addNews";
    }
    
    public String gotoListOnlyMyNews(){
            return "listOnlyMyNews";
    }

}
