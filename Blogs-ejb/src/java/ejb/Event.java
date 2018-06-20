/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import ejb.Person;

/**
 *
 * @author Yunying
 */
@Entity
@XmlRootElement
public class Event implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    protected String name;
    
    @ManyToMany
    protected List<Person> invitees;
    
    @ManyToOne
    private Person owner;
    
    @Enumerated(EnumType.STRING)
    private TypeEnum topictype;

    public Event() {
        this.invitees = new ArrayList<>();
        this.topictype = TypeEnum.FUN;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Person> getInvitees() {
        return invitees;
    }

    public void setInvitees(List<Person> invitees) {
        this.invitees = invitees;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public TypeEnum getTopictype() {
        return topictype;
    }

    public void setTopictype(TypeEnum topictype) {
        this.topictype = topictype;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.entity.Event[ id=" + id + " ]";
    }
    
}
