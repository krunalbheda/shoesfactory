package Entity;

import Entity.Product;
import Entity.Users;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T21:37:19", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Order1.class)
public class Order1_ { 

    public static volatile SingularAttribute<Order1, Product> pId;
    public static volatile SingularAttribute<Order1, Integer> oId;
    public static volatile SingularAttribute<Order1, Users> userId;
    public static volatile SingularAttribute<Order1, String> status;

}