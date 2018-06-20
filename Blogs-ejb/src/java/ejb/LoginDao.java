/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zhanghan
 */
@Entity
@Table(name = "LOGIN_DAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginDao.control", query = "SELECT l FROM LoginDao l WHERE l.username = :username and l.password = :password")
    ,@NamedQuery(name = "LoginDao.findAll", query = "SELECT l FROM LoginDao l")
    , @NamedQuery(name = "LoginDao.findById", query = "SELECT l FROM LoginDao l WHERE l.id = :id")
    , @NamedQuery(name = "LoginDao.findByUsername", query = "SELECT l FROM LoginDao l WHERE l.username = :username")
    , @NamedQuery(name = "LoginDao.findByPassword", query = "SELECT l FROM LoginDao l WHERE l.password = :password")})
public class LoginDao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "user")
    private Collection<NewsEntity> newsCollection;
//    @JoinTable(name = "USER_NEWS", joinColumns = {
//        @JoinColumn(name = "ID",
//                referencedColumnName = "USER_ID")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "ID",
//                        referencedColumnName = "NEWS_ID")})
//    @ManyToMany(mappedBy = "invitees")
//    private Collection<NewsEntity> evenscollection;

    public Collection<NewsEntity> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<NewsEntity> newsCollection) {
        this.newsCollection = newsCollection;
    }

    public LoginDao() {
    }

    public LoginDao(Integer id) {
        this.id = id;
    }

    public LoginDao(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginDao)) {
            return false;
        }
        LoginDao other = (LoginDao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.LoginDao[ id=" + id + " ]";
    }

}
