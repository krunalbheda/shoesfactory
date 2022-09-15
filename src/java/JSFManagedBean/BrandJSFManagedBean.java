/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import Client.ShoesJerseyClient;
import Entity.*;
import SessionBean.ShoesSessionBeanLocal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@Named(value = "brandJSFManagedBean")
@ApplicationScoped
public class BrandJSFManagedBean {
    
    @EJB
    private ShoesSessionBeanLocal shoesSessionBean;
    
    ShoesJerseyClient  pbl= new ShoesJerseyClient();
    Brand brand = new Brand();
    
    int bid;
    String bname;
    String gbname;

    public String getGbname() {
        return gbname;
    }

    public void setGbname(String gbname) {
        this.gbname = gbname;
    }
    
    private List<Brand> blist;

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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public List<Brand> getBlist() {
        return blist;
    }

    public void setBlist(List<Brand> blist) {
        this.blist = blist;
    }
    
    public List<Brand> showbrand() {
        Response response = pbl.showallbrand(Response.class);
        ArrayList<Brand> alist = new ArrayList<>();
        GenericType<List<Brand>> dAdd = new GenericType<List<Brand>>(){};
        blist = (ArrayList<Brand>) response.readEntity(dAdd);
        return blist;
    }
     
      public void insertbrand(){
        try {
            pbl.insertbrand("0", bname);
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
     
      public String editbrand(int id)
     {  
         Response response  = pbl.searchbrand(Response.class, String.valueOf(id));
        GenericType<Brand> brandsearch = new GenericType<Brand>(){};
        Brand b = response.readEntity(brandsearch);   
        
        bid = b.getBId();
        bname = b.getBName();
        return "/Admin/Brand.xhtml";
        
    }
     
      public String updatebrand(){
      try {
          pbl.updatebrand(String.valueOf(bid), bname);
            return "Admin/Brand.xhtml";
             
        } catch (ClientErrorException e) {
            System.out.println(e);
           return e.getMessage();
        }
    }
        
       public void deletebrand(int bid){
        try {
            pbl.deletebrand(String.valueOf(bid));
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
      public void getbrandhname(String bname)
     {
//         pbl.searchuser(ufname);
         shoesSessionBean.getbrandName(bname);
     }
     public List<Brand> listByName()
     {
         List<Brand> u =  shoesSessionBean.getbrandName(bname);
         return u;
     }
    /**
     * Creates a new instance of BrandJSFManagedBean
     */
    public BrandJSFManagedBean() {
    }
    
}
