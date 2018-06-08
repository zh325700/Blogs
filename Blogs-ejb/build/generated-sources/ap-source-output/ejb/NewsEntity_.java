package ejb;

import ejb.LoginDao;
import ejb.NewsEntity.Categories;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-06T22:09:13")
@StaticMetamodel(NewsEntity.class)
public class NewsEntity_ { 

    public static volatile SingularAttribute<NewsEntity, Integer> id;
    public static volatile SingularAttribute<NewsEntity, String> title;
    public static volatile SingularAttribute<NewsEntity, String> body;
    public static volatile SingularAttribute<NewsEntity, Categories> category;
    public static volatile SingularAttribute<NewsEntity, LoginDao> user;
    public static volatile SingularAttribute<NewsEntity, Integer> likes;

}