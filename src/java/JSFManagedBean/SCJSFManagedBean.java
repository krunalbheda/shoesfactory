/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import Client.ShoesJerseyClient;
import Entity.*;
import Entity.Subcategory;
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
@Named(value = "sCJSFManagedBean")
@ApplicationScoped
public class SCJSFManagedBean {

      @EJB
    private ShoesSessionBeanLocal shoesSessionBean;
    
    ShoesJerseyClient  pbl= new ShoesJerseyClient();
      Subcategory sc = new Subcategory();
    
        
    int scid;
    String scname;
    private List<Subcategory> sclist;

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

    public Subcategory getSc() {
        return sc;
    }

    public void setSc(Subcategory sc) {
        this.sc = sc;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    public List<Subcategory> getSclist() {
        return sclist;
    }

    public void setSclist(List<Subcategory> sclist) {
        this.sclist = sclist;
    }
    
     public List<Subcategory> showsc() {
        Response response = pbl.showallsubcategoey(Response.class);
        ArrayList<Subcategory> alist = new ArrayList<>();
        GenericType<List<Subcategory>> dAdd = new GenericType<List<Subcategory>>(){};
        sclist = (ArrayList<Subcategory>) response.readEntity(dAdd);
        return sclist;
    }
     
      public void insertsc(){
        try {
            pbl.insertsubcategoey("0", scname);
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
     
      public String editsc(int id)
     {    
        Response response = pbl.searchsubcategoey(Response.class,String.valueOf(id));
        GenericType<Subcategory> scsearch = new GenericType<Subcategory>(){};
        Subcategory sc = response.readEntity(scsearch);   
        sc.getScId();
        sc.getScName();
        return "/Admin/scs.xhtml";
        
    }
     
      public String updatesc(){
      try {
          pbl.updatesubcategoey(String.valueOf(scid), scname);
            return "Admin/Subcategory.xhtml";
             
        } catch (ClientErrorException e) {
            System.out.println(e);
           return e.getMessage();
        }
    }
        
       public void deletesc(int scid){
        try {
            pbl.deletesubcategoey(String.valueOf(scid));
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
        public void getsubcatname(String scname)
     {
//         pbl.searchuser(ufname);
         shoesSessionBean.getsubcatName(scname);
     }
     public List<Subcategory> listByName()
     {
         List<Subcategory> u =  shoesSessionBean.getsubcatName(scname);
         return u;
     }
    /**
     * Creates a new instance of SCJSFManagedBean
     */
    public SCJSFManagedBean() {
    }
    
}
