/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import Client.ShoesJerseyClient;
import SessionBean.ShoesSessionBeanLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import Entity.*;
import java.util.ArrayList;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "usersJSFManagedBean")
@ApplicationScoped
public class UsersJSFManagedBean {

    @EJB
    private ShoesSessionBeanLocal shoesSessionBean;
    
    ShoesJerseyClient  pbl= new ShoesJerseyClient();
       
    int uid,rid;
    long phoneno;
    String ufname,ulname,email,password;
       
     private List<Roles> rlist;
     private List<Users> ulist;

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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getPhoneno() {
        return (int) phoneno;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    public String getUfname() {
        return ufname;
    }

    public void setUfname(String ufname) {
        this.ufname = ufname;
    }

    public String getUlname() {
        return ulname;
    }

    public void setUlname(String ulname) {
        this.ulname = ulname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRlist() {
        return rlist;
    }

    public void setRlist(List<Roles> rlist) {
        this.rlist = rlist;
    }

    public List<Users> getUlist() {
        return ulist;
    }

    public void setUlist(List<Users> ulist) {
        this.ulist = ulist;
    }

    public List<Roles> showRoles() {
        Response response = pbl.showallrole(Response.class);
        ArrayList<Roles> rlist = new ArrayList<>();
        GenericType<List<Roles>> cAdd = new GenericType<List<Roles>>(){};
        rlist = (ArrayList<Roles>) response.readEntity(cAdd);
        return rlist;
    }
    
    public List<Users> showusers() {
        Response response = pbl.showallusers(Response.class);
        ArrayList<Users> ulist = new ArrayList<>();
        GenericType<List<Users>> bAdd = new GenericType<List<Users>>(){};
        ulist = (ArrayList<Users>) response.readEntity(bAdd);
        return ulist;
    }
        
         public void insertuser(){
          try {
              pbl.adduser("0", ufname, ulname,String.valueOf(phoneno), email, password,String.valueOf(rid));
        } catch (ClientErrorException e) {
           e.getMessage();
        }
    }
       
        public void edituser(int id) {
        
        Response response = pbl.searchuser(Response.class,String.valueOf(id));
        GenericType<Users> usersearch = new GenericType<Users>(){};
        Users u = response.readEntity(usersearch);
        
        uid = u.getUserId();
        ufname = u.getFirstName();
        ulname = u.getLastName();
        phoneno = u.getMobileNo();
        email = u.getEmail();
        password = u.getPassword();
        rid = u.getRoleId().getRoleId();

    }
        
        public void updateuser() {
        
        try {
            pbl.updateuser(String.valueOf(uid), ufname, ulname, String.valueOf(phoneno), email, password, String.valueOf(rid));
            
        } catch (ClientErrorException e) {
            System.out.println(e);
            e.getMessage();
        }
    }
      
       public void deletebranchClick(int uid) 
       {
            pbl.deleteuser(String.valueOf(uid));
            System.out.println(uid);
        } 
      
     public void getuserfhname(String ufname)
     {
//         pbl.searchuser(ufname);
//         pbl.searchuser(responseType, email)
        
         shoesSessionBean.getUserName(ufname);
     }
     
     public void  getroleuser(int rid){
         shoesSessionBean.getUserrole(rid);
     }
     
     public List<Users> listByName()
     {
         if(ufname == ""){
              return showusers();
         }
         else{
              List<Users> u =  shoesSessionBean.getUserName(ufname);
//              List<Users> r = shoesSessionBean.getUserrole(rid);
            return u;
         
         }
           
             
         
        
     }
    /**
     * Creates a new instance of UsersJSFManagedBean
     */
    public UsersJSFManagedBean() {
    }
    
}
