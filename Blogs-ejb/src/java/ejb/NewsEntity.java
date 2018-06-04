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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zhanghan
 */
@Entity
@Table(name = "NEWSENTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsEntity.findAll", query = "SELECT n FROM NewsEntity n")
    , @NamedQuery(name = "NewsEntity.findById", query = "SELECT n FROM NewsEntity n WHERE n.id = :id")
    , @NamedQuery(name = "NewsEntity.findByTitle", query = "SELECT n FROM NewsEntity n WHERE n.title = :title")
    , @NamedQuery(name = "NewsEntity.findByBody", query = "SELECT n FROM NewsEntity n WHERE n.body = :body")
   
    , @NamedQuery(name = "NewsEntity.findByLikes", query = "SELECT n FROM NewsEntity n WHERE n.likes = :likes")})
public class NewsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "BODY")
    private String body;
    @Column(name = "LIKES")
    private int likes;
    @JoinColumn(name="USER_ID",                       // name 本地的column name , referencedColumnName : 外来的column name
            referencedColumnName = "ID")
    @ManyToOne
    private LoginDao user;
//    @ManyToMany(mappedBy = "newsCollection")
//    private Collection<LoginDao> customerOrderCollection;

    public LoginDao getUser() {
        return user;
    }

    public void setUser(LoginDao user) {
        this.user = user;
    }


    public NewsEntity() {
    }

    public NewsEntity(Integer id) {
        this.id = id;
    }

    public NewsEntity(Integer id, String title, String body, int likes) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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
        if (!(object instanceof NewsEntity)) {
            return false;
        }
        NewsEntity other = (NewsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.NewsEntity[ id=" + id + " ]";
    }

}
