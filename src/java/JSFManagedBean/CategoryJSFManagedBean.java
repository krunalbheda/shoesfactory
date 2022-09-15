/*
 * Click nbfs://nbhost/SystemFileSyst   em/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import Client.ShoesJerseyClient;
import Entity.*;
import SessionBean.ShoesSessionBeanLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;  
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "categoryJSFManagedBean")
@ApplicationScoped
public class CategoryJSFManagedBean {
  @EJB
    private ShoesSessionBeanLocal shoesSessionBean;
    
    ShoesJerseyClient  pbl= new ShoesJerseyClient();
      Category cat = new Category();
    
        
    int cid;
    String cname;
    private List<Category> clist;

    public ShoesSessionBeanLocal getShoesSessionBean() {
        return shoesSessionBean;
    }

    public void setShoesSessionBean(ShoesSessionBeanLocal shoesSessionBean) {
        this.shoesSessionBean = shoesSessionBean;
    }

    public ShoesJerseyClient getPbl() {
        return pbl;
    }

    public void setPbl(ShoesJerseyClient pbl) {
        this.pbl = pbl;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Category> getClist() {
        return clist;
    }

    public void setClist(List<Category> clist) {
        this.clist = clist;
    }
    
     public List<Category> showccategory() {
        Response response = pbl.showallcategoey(Response.class);
        ArrayList<Category> alist = new ArrayList<>();
        GenericType<List<Category>> dAdd = new GenericType<List<Category>>(){};
        clist = (ArrayList<Category>) response.readEntity(dAdd);
        return clist;
    }
     
      public void insertCategory(){
        try {
            pbl.insertcategoey("0", cname);
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
     
      public String editCategory(int id)
     {    
        Response response = pbl.searchrole(Response.class,String.valueOf(id));
        GenericType<Category> categorysearch = new GenericType<Category>(){};
        Category c = response.readEntity(categorysearch);
        
        cid = c.getCId();
        cname = c.getCName();
        return "/Admin/Category.xhtml";
        
    }
     
      public String updateCategory(){
      try {
          
          pbl.updatecategoey(String.valueOf(cid), cname);
            return "Admin/Category.xhtml";
             
        } catch (ClientErrorException e) {
           return e.getMessage();
        }
    }
        
       public void deleteCategory(int cid){
        try {
            pbl.deletecategoey(String.valueOf(cid));
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
       public void getcatname(String cname){
           shoesSessionBean.getcatName(cname);
       }
        public List<Category> listByName()
     {
         List<Category> categorys =  shoesSessionBean.getcatName(cname);
         return categorys;
     }
    /**
     * Creates a new instance of CategoryJSFManagedBean
     */
    public CategoryJSFManagedBean() {
    }
    
}
