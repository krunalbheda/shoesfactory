/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package SessionBean;

import Entity.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entity.*;
import com.sun.xml.ws.api.security.trust.Claims;
import static com.sun.xml.ws.security.impl.policy.Constants.SignatureAlgorithm;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
@Stateless
public class ShoesSessionBean implements ShoesSessionBeanLocal {

    @PersistenceContext(unitName = "shoesfactoryPU")
    EntityManager em;

//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               Roles Business Logic                               /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Override
    public String insertroles(int rid, String rname) {
        try {

            Roles r = new Roles(rid, rname);
            em.persist(r);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateroles(int rid, String rname) {
        try {
            Roles r = em.find(Roles.class, rid);
            r.setRoleName(rname);
            em.merge(r);

            return "updated";

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String deleteroles(int rid) {
        try {
            Roles r = em.find(Roles.class, rid);
            em.remove(r);
            return "deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Roles searchroles(int rid) {
        try {
            Roles r = em.find(Roles.class, rid);
            return r;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Roles> showallroles() {
        List<Roles> rlist = em.createNamedQuery("Roles.findAll").getResultList();
        return rlist;
    }
//    @Override
//    public String countrole(int rid, String rname) {
//        try{
//            List rname = em.createNamedQuery("Roles.count").getResultList();
//        }catch(Exception e){
//            return e.getMessage();
//        }
//        return null;
//    }
//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               Brand Business Logic                               /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //

    @Override
    public String insertbrand(int bid, String bname) {
        try {
            Brand b = new Brand(bid, bname);
            em.persist(b);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatebrand(int bid, String bname) {
        try {

            Brand b = em.find(Brand.class, bid);
            b.setBName(bname);
            em.merge(b);

            return "updated";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletebrand(int bid) {
        try {
            Brand b = em.find(Brand.class, bid);
            em.remove(b);
            return "deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Brand searchbrand(int bid) {
        try {
            Brand b = em.find(Brand.class, bid);
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Brand> showallbrand() {
        List<Brand> blist = em.createNamedQuery("Brand.findAll").getResultList();
        return blist;
    }

//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               Category Business Logic                            /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Override
    public String insertcategory(int cid, String cname) {
        try {
            Category c = new Category(cid, cname);
            em.persist(c);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatecategory(int cid, String cname) {
        try {
            Category c = em.find(Category.class, cid);
            c.setCName(cname);
            em.merge(c);
            return "updated";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletecategory(int cid) {
        try {
            Category c = em.find(Category.class, cid);
            em.remove(c);
            return "deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Category searchcategory(int cid) {
        try {
            Category c = em.find(Category.class, cid);
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Category> showallcategory() {
        List<Category> clist = em.createNamedQuery("Category.findAll").getResultList();
        return clist;
    }

//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               SubCatgory Business Logic                          /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Override
    public String insertsubcategory(int scid, String scname) {
        try {
            Subcategory sc = new Subcategory(scid, scname);
            em.persist(sc);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatsubcategory(int scid, String scname) {
        try {
            Subcategory sc = em.find(Subcategory.class, scid);
            sc.setScName(scname);
            em.merge(sc);
            return "updated";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletesubcategory(int scid) {
        try {
            Subcategory sc = em.find(Subcategory.class, scid);
            em.remove(sc);
            return "deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Subcategory searchsubcategory(int scid) {
        try {
            Subcategory sc = em.find(Subcategory.class, scid);
            return sc;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Subcategory> showallsubcategory() {
        List<Subcategory> sclist = em.createNamedQuery("Subcategory.findAll").getResultList();
        return sclist;
    }

//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               User Business Logic                             /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Override
    public String insertuser(int uid, String ufname, String ulname, long phoneno, String email, String password, int rid) {
        try {
            Roles r = em.find(Roles.class, rid);
            Collection<Users> users = r.getUsersCollection();

            Users u = new Users();

            u.setUserId(uid);
            u.setFirstName(ufname);
            u.setLastName(ulname);
            u.setMobileNo(phoneno);
            u.setEmail(email);
            u.setPassword(password);
            u.setRoleId(r);

            users.add(u);
            r.setUsersCollection(users);

            em.persist(u);
            em.merge(r);

            return "Inserted";

        } catch (Exception e) {
            return e.toString();
        }
    }

    @Override
    public String updateuser(int uid, String ufname, String ulname, long phoneno, String email, String password, int rid) {
        try {

            Roles r = em.find(Roles.class, rid);
            Collection<Users> users = r.getUsersCollection();

            Users u = em.find(Users.class, uid);
            u.setUserId(uid);
            u.setFirstName(ufname);
            u.setLastName(ulname);
            u.setMobileNo(phoneno);
            u.setEmail(email);
            u.setPassword(password);
            u.setRoleId(r);

            users.add(u);
            r.setUsersCollection(users);

            em.persist(u);
            em.merge(r);

            return "updated";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteuser(int uid) {
        try {
            Users du = em.find(Users.class, uid);
            em.remove(du);
            return "deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Users searchuser(int uid) {
        try {
            Users u = em.find(Users.class, uid);
            return u;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Users> showalluser() {
        try {
            List<Users> userlist = em.createNamedQuery("Users.findAll").getResultList();
            return userlist;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Users> getUserName(String firstName) {
//      return em.createNamedQuery("Users.findByFirstName").setParameter("ufirstname", ufname).getResultList();  
        return em.createNamedQuery("Users.findByFirstName").setParameter("firstName", firstName).getResultList();
    }

//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               Product Business Logic                             /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Override
    public String insertproduct(int pid, int bid, int cid, int scid, String pname, String pdesc, int price, String img) {
        try {

            Category c = em.find(Category.class, cid);
            Brand b = em.find(Brand.class, bid);
            Subcategory sc = em.find(Subcategory.class, scid);

            Collection<Product> bp = b.getProductCollection();
            Collection<Product> cp = c.getProductCollection();
            Collection<Product> scp = sc.getProductCollection();

            Product p = new Product();

            p.setPId(pid);
            p.setBId(b);
            p.setCId(c);
            p.setScId(sc);
            p.setPName(pname);
            p.setPDescription(pdesc);
            p.setPrice(price);
            p.setImage(img);

            bp.add(p);
            cp.add(p);
            scp.add(p);

            b.setProductCollection(bp);
            c.setProductCollection(cp);
            sc.setProductCollection(scp);

            em.persist(p);
            em.merge(b);
            em.merge(c);
            em.merge(sc);

            return "Inserted";

        } catch (Exception e) {
            return e.toString();
        }
    }

    @Override
    public String updateproduct(int pid, int bid, int cid, int scid, String pname, String pdesc, int price, String img) {
        try {

            Category c = em.find(Category.class, cid);
            Brand b = em.find(Brand.class, bid);
            Subcategory sc = em.find(Subcategory.class, scid);

            Collection<Product> bp = b.getProductCollection();
            Collection<Product> cp = c.getProductCollection();
            Collection<Product> scp = sc.getProductCollection();

            Product p = em.find(Product.class, pid);

            p.setPId(pid);
            p.setBId(b);
            p.setCId(c);
            p.setScId(sc);
            p.setPName(pname);
            p.setPDescription(pdesc);
            p.setPrice(price);
            p.setImage(img);

            bp.add(p);
            cp.add(p);
            scp.add(p);

            b.setProductCollection(bp);
            c.setProductCollection(cp);
            sc.setProductCollection(scp);

            em.persist(p);
            em.merge(b);
            em.merge(c);
            em.merge(sc);

            return "Updated";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteproduct(int pid) {
        try {
            Product p = em.find(Product.class, pid);
            em.remove(p);
            return "deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Product searchproductr(int pid) {
        try {
            Product p = em.find(Product.class, pid);
            return p;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Product> showallproduct() {
        try {
            List<Product> plist = em.createNamedQuery("Product.findAll").getResultList();
            return plist;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Product> getProductName(String pname) {
        return em.createNamedQuery("Product.findByPName").setParameter("pName", pname).getResultList();
    }

    @Override
    public Collection<Users> GetAllLogins() {
        Collection<Users> login = em.createNamedQuery("Users.findByLogin").getResultList();
        return login;
    }
//}
// public Collection<LoginTB> GetAllLogins() {
//        Collection<LoginTB> logins = em.createNamedQuery("LoginTB.findAll")
//                .getResultList();
//        return logins;

    @Override
    public Users login(String email, String password) {
        Users loginUsers = (Users) em.createNamedQuery("Users.findByLogin")
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        if (loginUsers == null) {
//            System.out.println("user not found");
            return null;
        } else {
//            System.out.println("user  found");
            return loginUsers;
        }
    }

    @Override
    public List<Roles> getroleName(String rname) {
        return em.createNamedQuery("Roles.findByRoleName").setParameter("roleName", rname).getResultList();
    }

    @Override
    public List<Brand> getbrandName(String bname) {
        return em.createNamedQuery("Brand.findByBName").setParameter("bName", bname).getResultList();
    }

    @Override
    public List<Category> getcatName(String catname) {
        return em.createNamedQuery("Category.findByCName").setParameter("cName", catname).getResultList();
    }

    @Override
    public List<Subcategory> getsubcatName(String subcatname) {
        return em.createNamedQuery("Subcategory.findByScName").setParameter("scName", subcatname).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Users getUser(Integer id) {
        return (Users) em.createNamedQuery("Users.findByUserId");
    }

    @Override
    public Collection<Product> userProducts() {
        return em.createNamedQuery("Product.findAll").getResultList();
    }

    @Override
    public int addToCart(Integer product_id, Integer user_id, Integer qty) {
        Product p = em.find(Product.class, product_id);
        Users u = em.find(Users.class, user_id);
        try {
            Cart cdata = (Cart) em.createNamedQuery("Cart.findByUser").setParameter("user_id", u).setParameter("p_id", p).getSingleResult();
            return 1;
        } catch (Exception e) {
            Cart c = new Cart();
            c.setPId(p);
            c.setUserId(u);
            c.setQty(qty);
            em.persist(c);
            return 0;
        }
    }

    @Override
    public Collection<Cart> userCarts(Users user_id) {
        Query q = em.createNamedQuery("Cart.findByUserId");
        q.setParameter("customerId", user_id);
        return q.getResultList();
    }

    @Override
    public void removeCart(Integer cid) {
        Cart c = (Cart) em.find(Cart.class, cid);
        em.remove(c);
    }

    @Override
    public void addOrder(Integer order_no, Integer p_id, Integer user_id, String Stutus) {

        Product p = em.find(Product.class, p_id);
        Users u = em.find(Users.class, user_id);

        Order1 o = new Order1();
        o.setOId(order_no);
        o.setUserId(u);
        o.setPId(p);
        o.setStatus(Stutus);

        Collection<Order1> ordersp = p.getOrder1Collection();
        Collection<Order1> ordersu = u.getOrder1Collection();

        ordersp.add(o);
        ordersu.add(o);

        p.setOrder1Collection(ordersp);
        u.setOrder1Collection(ordersu);

        em.persist(o);
        em.merge(p);
        em.merge(u);
    }

//    @Override
//    public void addOrderDetail(Integer order_no_details, Integer product_id, Integer total) {
//        OrderDetails o = new OrderDetails();
//        Orders on = em.find(Orders.class, order_no_details);
//        Products p = em.find(Products.class, product_id);
//
//        o.setOrderNoDetails(on);
//        o.setProductId(p);
//        o.setTotal(total);
//
//        em.persist(o);
//
//        Collection<OrderDetails> product = p.getOrderDetailsCollection();
//
//        product.add(o);
//        p.setOrderDetailsCollection(product);
//        em.merge(p);
//    }
    @Override
    public Collection<Order1> userOrders(Users user_id) {
        Query q = em.createNamedQuery("Order1.findByUserId");
        q.setParameter("user_id", user_id);
        return q.getResultList();
    }

    @Override
    public Collection<Product> getlatestProduct() {
        return em.createNamedQuery("Product.latestProducts").setMaxResults(5).getResultList();
    }

    @Override
    public Collection<Category> getAllCategories() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    @Override
    public Product getProduct(Integer id) {
        return (Product) em.createNamedQuery("Product.findByPId").getSingleResult();
    }

    @Override
    public List<Order1> showallorder() {
        try {
            List<Order1> olist = em.createNamedQuery("Order1.findAll").getResultList();
            return olist;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Users> getUserrole(int rid) {
        return em.createNamedQuery("Users.findByrole").setParameter("role_id", rid).getResultList();
    }
//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               Login Business Logic                               /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //

    @Override
    public Users getLoginUser(String email, String password) {
        try {
            Users user = (Users) em.createNamedQuery("Users.findByLogin").setParameter("email", email).setParameter("password", password).getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean parseJwt(String jwtString) {
        try {
//            boolean t = tokenDecode(jwtString).getExpiration().after(new Date(System.currentTimeMillis()));
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Claims tokenDecode(String token) {
        try {
            String secret = "krunalbheda";
//            return Jwts.parser()
//                    .setSigningKey(Base64.getEncoder().encode(secret.getBytes()))
//                    .parseClaimsJws(token)
//                    .getBody();
                return null;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String loginCheck(String email, String password) {
try{
            
            Users user =  (Users)em.createNamedQuery("Users.findByLogin").setParameter("email",email).setParameter("password",password).getSingleResult();
            String secret = "krunalbheda";

            System.out.println(user);

            if(user!=null)
            {
                Instant now = Instant.now();
////                String jwtToken = Jwts.builder()
////                        .setSubject("LoginJWTToken")
////                        .setId(UUID.randomUUID().toString())
////                        .setIssuedAt(Date.from(now))
////                        .setExpiration(Date.from(now.plus(5l, ChronoUnit.MINUTES)))
////                        .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secret.getBytes()))
////                        .compact();
//                System.out.println(jwtToken);
                return null;
            }
            return null;
            
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
