/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author zhanghan
 */
import ejb.LoginDao;
import ejb.NewsEntity;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import model.NewsEntityFacade;
import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;

//@ManagedBean
@Named
@FlowScoped("createNews")
//@SessionScoped
public class CreateNewsController implements Serializable {

    @EJB
    private NewsEntityFacade newsEntityFacade;
    private String title;
    private String content;
    private NewsEntity aNews = new NewsEntity();
    private LoginController loginc = new LoginController();
    private LoginDao aUser;

    private NewsEntity.Categories choosenCat;

    private NewsEntity.Categories[] categories = NewsEntity.Categories.values();

    public NewsEntity.Categories getChoosenCat() {
        return choosenCat;

    }

    public void setChoosenCat(NewsEntity.Categories choosenCat) {
        this.choosenCat = choosenCat;
    }

    public NewsEntity.Categories[] getCategories() {
        return categories;
    }

    public void setCategories(NewsEntity.Categories[] categories) {
        this.categories = categories;
    }

    public NewsEntityFacade getNewsEntityFacade() {
        return newsEntityFacade;
    }

    public LoginDao getaUser() {
        return aUser;
    }

    public void setaUser(LoginDao aUser) {
        this.aUser = aUser;
    }

    public void setNewsEntityFacade(NewsEntityFacade newsEntityFacade) {
        this.newsEntityFacade = newsEntityFacade;
    }

    public String add() {
//        System.out.println("If I got user when add?" + aUser.getUsername());
        aNews.setBody(content);
        aNews.setTitle(title);
        aNews.setCategory(choosenCat);
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        LoginDao l = (LoginDao) session.getAttribute("loggedUser");
        aNews.setUser(l);
        this.newsEntityFacade.create(this.aNews);
        return "createNews-return";
    }

    public String gotoflow(LoginDao aUser) {
        this.aUser = aUser;
        return "createNews";
    }

    public String getTitle() {
        return title;
    }

    public NewsEntity getaNews() {
        return aNews;
    }

    public void setaNews(NewsEntity aNews) {
        this.aNews = aNews;
    }

    public LoginController getLoginc() {
        return loginc;
    }

    public void setLoginc(LoginController loginc) {
        this.loginc = loginc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getCanonicalName() + "initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(this.getClass().getCanonicalName() + "destroyed.");
    }
//getters and setters omitted for brevity
}
