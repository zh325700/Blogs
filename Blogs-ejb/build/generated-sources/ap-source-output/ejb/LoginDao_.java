package ejb;

import ejb.NewsEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-08T23:31:07")
@StaticMetamodel(LoginDao.class)
public class LoginDao_ { 

    public static volatile SingularAttribute<LoginDao, String> password;
    public static volatile CollectionAttribute<LoginDao, NewsEntity> newsCollection;
    public static volatile SingularAttribute<LoginDao, Integer> id;
    public static volatile SingularAttribute<LoginDao, String> username;

}