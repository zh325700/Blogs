/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import query.DataQuery;
import ejb.LoginDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static javax.swing.text.StyleConstants.Size;
import org.primefaces.context.RequestContext;

/**
 *
 * @author zhanghan
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable{

    private String username;
    private String password;
    private LoginDao user;
    private DataQuery query = new DataQuery();
    
    public String loginControl(){
        if(query.loginControl(username,password)){
            user = query.getMyUser();
            return "home.xhtml?faces-redirect=true";
        }
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Ussername or Password invalid"));
        return "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDao getUser() {
        return user;
    }

    public void setUser(LoginDao user) {
        this.user = user;
    }
    
    
}
