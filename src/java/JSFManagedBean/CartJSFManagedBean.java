/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import Entity.*;
import SessionBean.ShoesSessionBeanLocal;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@Named(value = "cartJSFManagedBean")
@ApplicationScoped
public class CartJSFManagedBean {

    @EJB
    private ShoesSessionBeanLocal shoesSessionBean;
    
    private Collection<Product> productlist;
    private Collection<Cart> cartlist;
    private int qty = 1;
    private int total = 0;
    private String cartError = "";

  
    private Collection<Product> relatedProducts;
    private Product product;

     @PostConstruct
    public void init(){
        productlist = shoesSessionBean.userProducts();
        getCartList();
    }

      public String productDetail(Product p){
        this.product = p;
        this.relatedProducts = p.getCId().getProductCollection();
        return "/user/productdetail.xhtml?faces-redirect=true";
    }
    
    public String addToCart(Product p)throws IOException{
        product = p;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users u = (Users) session.getAttribute("user");
//        Product p = ()
        if(u == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/shoesfactory/faces/templet/SignIn.xhtml");
        }
        total = product.getPrice() * qty;
        int status = shoesSessionBean.addToCart(product.getPId(), u.getUserId(), qty);
//        int status = shoesSessionBean.addToCart(product.getId(), u.getId(),qty , total);
         getCartList();
        if(status == 1){
            System.out.println("product already exist");
            qty = 1;
            cartError = "product already into cart";
            return null;
        }else{
            cartError = "";
             qty = 1;
             FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/shoesfactory/faces/templet/Customer/cart.xhtml");
             return null;
        }
    }

     public String removeCart(int cid){
        shoesSessionBean.removeCart(cid);
         getCartList();
        return "/user/cart.xhtml?faces-redirect=true";
    }
     
     public void getCartList(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users u = (Users) session.getAttribute("user");
        cartlist = shoesSessionBean.userCarts(u);
     }
     
     
    public ShoesSessionBeanLocal getShoesSessionBean() {
        return shoesSessionBean;
    }

    public void setShoesSessionBean(ShoesSessionBeanLocal shoesSessionBean) {
        this.shoesSessionBean = shoesSessionBean;
    }

    public Collection<Product> getProductlist() {
        return productlist;
    }

    public void setProductlist(Collection<Product> productlist) {
        this.productlist = productlist;
    }

    public Collection<Cart> getCartlist() {
        return cartlist;
    }

    public void setCartlist(Collection<Cart> cartlist) {
        this.cartlist = cartlist;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getCartError() {
        return cartError;
    }

    public void setCartError(String cartError) {
        this.cartError = cartError;
    }

    public Collection<Product> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(Collection<Product> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    

    /**
     * Creates a new instance of CartJSFManagedBean
     */
    public CartJSFManagedBean() {
    }
    
}
