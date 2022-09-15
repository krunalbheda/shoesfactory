/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package SessionBean;

import Entity.*;
import com.sun.xml.ws.api.security.trust.Claims;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface ShoesSessionBeanLocal {
      /////////////     ROLES   ///////////////////
    public String insertroles(int rid,String rname);
    public String updateroles(int rid,String rname);
    public String deleteroles(int rid);
    public Roles searchroles(int rid);
    public List<Roles> showallroles();
    public List<Roles> getroleName(String rname);
    
    
        /////////////     BRAND   //////////////////
    public String insertbrand(int bid,String bname);
    public String updatebrand(int bid,String bname);
    public String deletebrand(int bid);
    public Brand searchbrand(int bid);
    public List<Brand> showallbrand();
    public List<Brand> getbrandName(String bname);


    /////////////     CATEGORY   ///////////
     public String insertcategory(int cid,String cname);
    public String updatecategory(int cid,String cname);
    public String deletecategory(int cid);
    public Category searchcategory(int cid);
    public List<Category> showallcategory();
     public List<Category> getcatName(String catname);

    
    
    /////////////     SUBCATEGORY   ///////////
     public String insertsubcategory(int scid,String scname);
    public String updatsubcategory(int scid,String scname);
    public String deletesubcategory(int scid);
    public Subcategory searchsubcategory(int scid);
    public List<Subcategory> showallsubcategory();
    public List<Subcategory> getsubcatName(String subcatname);

    
   /////////////     USERS   ///////////
    public String insertuser(int uid,String ufname,String ulname,long phoneno,String email,String password,int rid);
    public String updateuser(int uid,String ufname,String ulname,long phoneno,String email,String password,int rid);
    public String deleteuser(int uid);
    public Users searchuser(int uid);
    public List<Users> showalluser();
    
    
    // Login
     public Collection<Users> GetAllLogins() ;
    public List<Users> getUserName(String firstName);
      public List<Users> getUserrole(int rid);
    public Users login(String email,String password);
    
    
    
    
    
//    Logintb getLoginUser(String userName,String password);
//    boolean parseJwt(String jwtString);
//    Claims tokenDecode(String token);
//    String loginCheck(String userName,String password);

    
    //Login
    Users getLoginUser(String email,String password);
    boolean parseJwt(String jwtString);
    Claims tokenDecode(String token);
    String loginCheck(String email,String password);
    
   
    
     /////////////     PRODUCT   ///////////
    public String insertproduct(int pid,int bid,int cid,int scid,String pname,String pdesc,int price,String img);
    public String updateproduct(int pid,int bid,int cid,int scid,String pname,String pdesc,int price,String img);
    public String deleteproduct(int pid);
    public Product searchproductr(int pid);
    public List<Product> showallproduct();
    
    public List<Product> getProductName(String pname);
      // User
    Users getUser(Integer id);
    
    // Product
    Collection<Product> userProducts();
    
    Product getProduct(Integer id);
    
    //Cart
    int addToCart(Integer product_id, Integer customer_id, Integer qty);
    Collection<Cart> userCarts(Users user_id);
    void removeCart(Integer cid);
    
    //Order
    void addOrder(Integer order_no,Integer p_id ,Integer user_id, String Stutus);
    
    //OrderDetails
//    void addOrderDetail(Integer order_no_details, Integer product_id, Integer total);
    
    //Payments
//    void addPayment(Integer order_no_payment, Integer amount, String method);
    
    Collection<Order1> userOrders(Users user_id);
     public List<Order1> showallorder();
    //Reviews
//    Collection<Reviews> productReviews(Products product_id);
    
    //Home
//    Collection<Banners> getactiveBanner();
    
    //Latest Products
    Collection<Product> getlatestProduct();
    
    //Categories
    Collection<Category> getAllCategories();

    
}
