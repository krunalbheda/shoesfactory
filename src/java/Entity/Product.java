/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "product", catalog = "shoesfactory", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByPId", query = "SELECT p FROM Product p WHERE p.pId = :pId"),
    @NamedQuery(name = "Product.findByPName", query = "SELECT p FROM Product p WHERE p.pName = :pName"),
    @NamedQuery(name = "Product.findByPDescription", query = "SELECT p FROM Product p WHERE p.pDescription = :pDescription"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
      @NamedQuery(name = "Product.latestProducts", query = "SELECT p FROM Product p ORDER BY P.pId ASC"),
    @NamedQuery(name = "Product.findByImage", query = "SELECT p FROM Product p WHERE p.image = :image")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "p_id", nullable = false)
    private Integer pId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "p_name", nullable = false, length = 50)
    private String pName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "p_description", nullable = false, length = 50)
    private String pDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "image", nullable = false, length = 500)
    private String image;
    @JoinColumn(name = "b_id", referencedColumnName = "b_id", nullable = false)
    @ManyToOne(optional = false)
    private Brand bId;
    @JoinColumn(name = "c_id", referencedColumnName = "c_id", nullable = false)
    @ManyToOne(optional = false)
    private Category cId;
    @JoinColumn(name = "sc_id", referencedColumnName = "sc_id", nullable = false)
    @ManyToOne(optional = false)
    private Subcategory scId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<Cart> cartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<Order1> order1Collection;

    public Product() {
    }

    public Product(Integer pId) {
        this.pId = pId;
    }

    public Product(Integer pId, String pName, String pDescription, int price, String image) {
        this.pId = pId;
        this.pName = pName;
        this.pDescription = pDescription;
        this.price = price;
        this.image = image;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPDescription() {
        return pDescription;
    }

    public void setPDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Brand getBId() {
        return bId;
    }

    public void setBId(Brand bId) {
        this.bId = bId;
    }

    public Category getCId() {
        return cId;
    }

    public void setCId(Category cId) {
        this.cId = cId;
    }

    public Subcategory getScId() {
        return scId;
    }

    public void setScId(Subcategory scId) {
        this.scId = scId;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Product[ pId=" + pId + " ]";
    }
    
}
