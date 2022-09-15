package Entity;

import Entity.Brand;
import Entity.Cart;
import Entity.Category;
import Entity.Order1;
import Entity.Subcategory;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T21:37:19", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile CollectionAttribute<Product, Cart> cartCollection;
    public static volatile SingularAttribute<Product, String> image;
    public static volatile CollectionAttribute<Product, Order1> order1Collection;
    public static volatile SingularAttribute<Product, String> pName;
    public static volatile SingularAttribute<Product, Integer> price;
    public static volatile SingularAttribute<Product, Integer> pId;
    public static volatile SingularAttribute<Product, String> pDescription;
    public static volatile SingularAttribute<Product, Brand> bId;
    public static volatile SingularAttribute<Product, Subcategory> scId;
    public static volatile SingularAttribute<Product, Category> cId;

}