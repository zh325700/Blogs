/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import static java.time.Clock.system;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import rest.Blog;

/**
 *
 * @author zhanghan
 */
@Named
@SessionScoped
public class BlogController  implements Serializable {
    
    private List<Blog> blogs;

    private BlogClient bgclient = new BlogClient();
    
    public BlogController(){

    }
    
    public List<Blog> getBlogs() {
//        Blog b = bgclient.find_JSON(Blog.class,Integer.toString(1));
//        blogs.add(b);
//        System.out.print(blogs.get(1).getMessage());
//        return blogs;
        
        GenericType<List<Blog>> gType = new GenericType<List<Blog>>() {
        };
        this.setBlogs(bgclient.findAll_XML(gType));
        return blogs;

//this.setBlogs(bgclient.findAll_JSON(Blog.class));
//        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public BlogClient getBgclient() {
        return bgclient;
    }

    public void setBgclient(BlogClient bgclient) {
        this.bgclient = bgclient;
    }
    
    
    
    
}
