package Entity;

import Entity.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T21:37:19", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Subcategory.class)
public class Subcategory_ { 

    public static volatile CollectionAttribute<Subcategory, Product> productCollection;
    public static volatile SingularAttribute<Subcategory, Integer> scId;
    public static volatile SingularAttribute<Subcategory, String> scName;

}