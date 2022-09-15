/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import Client.ShoesJerseyClient;
import Entity.Roles;
import SessionBean.ShoesSessionBeanLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.management.relation.Role;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "roleJSFManagedBean")
@ApplicationScoped
public class RoleJSFManagedBean {

    @EJB
    private ShoesSessionBeanLocal shoesSessionBean;
    
    ShoesJerseyClient  pbl= new ShoesJerseyClient();
      Roles role = new Roles();
    
        
    int rid;
    String rname;
    private List<Roles> rlist;

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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public List<Roles> getRlist() {
        return rlist;
    }

    public void setRlist(List<Roles> rlist) {
        this.rlist = rlist;
    }
    
    public List<Roles> showrole() {
        Response response = pbl.showallrole(Response.class);
        ArrayList<Roles> alist = new ArrayList<>();
        GenericType<List<Roles>> dAdd = new GenericType<List<Roles>>(){};
        rlist = (ArrayList<Roles>) response.readEntity(dAdd);
        return rlist;
    }
     
      public void insertrole(){
        try {
            pbl.insertrole("0", rname);
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
     
      public String editrole(int id)
     {    
        Response response = pbl.searchrole(Response.class,String.valueOf(id));
        GenericType<Roles> rolesearch = new GenericType<Roles>(){};
        Roles r = response.readEntity(rolesearch);   
        rid = r.getRoleId();
        rname = r.getRoleName();
        return "/Admin/Roles.xhtml";
        
    }
     
      public String updaterole(){
      try {
            pbl.update(String.valueOf(rid), rname);
            return "Admin/role.xhtml";
             
        } catch (ClientErrorException e) {
            System.out.println(e);
           return e.getMessage();
        }
    }
        
       public void deleterole(int rid){
        try {
            pbl.deleterole(String.valueOf(rid));
        } catch (ClientErrorException e) {
            e.getMessage();
        }
    }
     


    /**
     * Creates a new instance of RoleJSFManagedBean
     */
    
    
    public RoleJSFManagedBean() {
    }
    
}
