/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import Client.ShoesJerseyClient;
import Entity.Roles;
import Entity.Users;
import SessionBean.ShoesSessionBeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "login")
@ApplicationScoped
public class Login {
    
    @EJB
    private ShoesSessionBeanLocal shoesSessionBean;

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }
    
    @Inject private SecurityContext securityContext;
    
    ShoesJerseyClient  pbl= new ShoesJerseyClient();
       
  
//    String ufname,ulname,email,password;
         String id;
    Response res;
    String LoginID;
    
    private Users selectedLoginID;
    private Users loginTB = new Users();
   
    Collection<Users> logins;
    GenericType<Collection<Users>> glogins;

     private List<Roles> rlist;
     private List<Users> ulist;

    
    private String email;

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

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public String getLoginID() {
        return LoginID;
    }

    public void setLoginID(String LoginID) {
        this.LoginID = LoginID;
    }

    public Users getSelectedLoginID() {
        return selectedLoginID;
    }

    public void setSelectedLoginID(Users selectedLoginID) {
        this.selectedLoginID = selectedLoginID;
    }

    public Users getLoginTB() {
        return loginTB;
    }

    public void setLoginTB(Users loginTB) {
        this.loginTB = loginTB;
    }

    public Collection<Users> getLogins() {
        return logins;
    }
    
    
    

    public void setLogins(Collection<Users> logins) {
        this.logins = logins;
    }

    public GenericType<Collection<Users>> getGlogins() {
        return glogins;
    }

    public void setGlogins(GenericType<Collection<Users>> glogins) {
        this.glogins = glogins;
    }
    private String password;
//    private String message;
    private AuthenticationStatus status;
    private Set<String> roles;
   
//   FreelancerClient client;
//   ShoesJerseyClient  pbl= new ShoesJerseyClient();
   


    /**
     * Creates a new instance of Login
     */
    public Login() {
        logins = new ArrayList<Users>();
        glogins = new GenericType<Collection<Users>>(){};
    }
     
    public Collection<Users> Login() {
          res = pbl.GetAllLogins_XML(Response.class);
//        res = client.GetAllLogins_XML(Response.class);
        System.out.println(res);
        logins = res.readEntity(glogins);
         return logins;
    }

    public String login()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        try{
        
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      
        request.getSession().setAttribute("logged-group", ""); 
        request.getSession().setAttribute("Email", "");
        request.getSession().setAttribute("LoginID", "");
        
        Credential credential = new UsernamePasswordCredential(email, new Password(password));
        AuthenticationStatus status= securityContext.authenticate(request, response, withParams().credential(credential));
                                           
     
       if (status.equals(SEND_CONTINUE)) {
            // Authentication mechanism has send a redirect, should not
            // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
            context.responseComplete();
       } 
       
        System.out.println("credential:"+credential);
         System.out.println("In bean");
         if(roles.contains("Admin"))
           {
               System.out.println("In admin");
               request.getSession().setAttribute("logged-group", "admin");
               request.getSession().setAttribute("Email", email);
               //request.getSession().setAttribute("LoginID", LoginID);
              return "Admib/Idmin.xhtml?faces-redirect=true";
           }
        //   else if(securityContext.isCallerInRole("Supervisor"))
       else if(roles.contains("Manger"))
           {
               System.out.println("In Manager");
               request.getSession().setAttribute("logged-group", "Manager");
               request.getSession().setAttribute("Email", email);
               System.out.println("beans.LoginBean.login()" + email);
               return "Admib/Idmin.xhtml?faces-redirect=true";
           }
         else if(roles.contains("Customer"))
           {
               System.out.println("In Customer");
               request.getSession().setAttribute("logged-group", "Customer");
               request.getSession().setAttribute("Email", email);
               return "Customer/Index.xhtml?faces-redirect=true";
           }
        
       //} 
       
       
        }
        catch (Exception e)
        {
//             message = "Something is Wrong !!!";
             e.printStackTrace();
        }
//        
      return "SignIn.xhtml";
    }
   
   public String pass_confirm()
   {
        FacesContext context = FacesContext.getCurrentInstance();

        try
        {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            request.getSession().setAttribute("logged-group", ""); 
        
            Credential credential = new UsernamePasswordCredential(email, new Password(password));
            AuthenticationStatus status= securityContext.authenticate(request, response, withParams().credential(credential));
                                           
     
            if (status.equals(SEND_CONTINUE))
            {
                context.responseComplete();
            } 
            System.out.println("In password confirm");
            
            if(roles.contains("admin"))
            {
                System.out.println("In adminnn");
                request.getSession().setAttribute("logged-group", "admin");
                //return "/templates/admins/password_change.jsf";
               return EditAdminPassByID();
            }
       }
       catch(Exception e)
       {
           System.out.println( "Username and password is not match");
       }
       return "/templates/Common/SihnIn.xhtml";
   }
   
    public String EditAdminPassByID()
    {
       id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedId");
       // id = "4";
        return "change_password.jsf";
    }

//    public String EditAdminPass(Login bean)
//    {
//      client.AdminChangePassword_JSON(logins, bean.getId(), bean.getPassword());
//       // client.AdminChangePassword_JSON(logins, "4","vidhi@gmail.com" ,"vidhi","1002");
//        
//        return "password_change_sucsess.jsf";
//    }
   
   private static void addError(FacesContext context, String message) {
        context = FacesContext.getCurrentInstance();
        context
                .addMessage(
                        null,
                        new FacesMessage(SEVERITY_ERROR, message, null));
    }
   
   public String logout() throws ServletException
   {
       System.out.println("In Log out");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
          request.getSession().setAttribute("logged-group", "");
           request.logout();
          request.getSession().invalidate();
         
          
          return "/templates/login.jsf?faces-redirect=true";
             
             }
    
}
