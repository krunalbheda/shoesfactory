/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import Client.ShoesJerseyClient;
import Entity.Roles;
import Entity.*;
import SessionBean.ShoesSessionBeanLocal;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;  
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "auth")
@ApplicationScoped
public class auth {

    @EJB
    private ShoesSessionBeanLocal shoesSessionBean;

     ShoesJerseyClient  pbl= new ShoesJerseyClient();
       
   
    private Users user;
    private Users us;
    private Users ulog;
    private String passwordConfirm;

    private Response res;
    private GenericType<Users> u;

    public static final String SALT = "secret-code";

    @PostConstruct
    public void init() {
        
    }
    
    
    public String registerUser() {
        String saltedPassword = SALT + user.getPassword();
        String hashedPassword = generateHash(saltedPassword);
           pbl.adduser(String.valueOf(user.getUserId()),user.getFirstName(),user.getLastName(),String.valueOf(user.getMobileNo()),user.getEmail(),hashedPassword,String.valueOf(user.getRoleId()));
//        rest.addUser(user.getName(), user.getEmail(), hashedPassword, user.getAddress(), user.getPhone(), String.valueOf(user.getPincode()));
        clearUser();
        return "SignIn.xhtml?faces-redirect=true";
    }

    public String loginUser() {
//        Users a = ab.getUserByEmailPassword(user.getEmail(), user.getPassword());
//        clearUser();
//        System.out.print(a.getAddress());
        u = new GenericType<Users>() {
        };
        String saltedPassword = SALT + user.getPassword();
        String hashedPassword = generateHash(saltedPassword);
//        res = rest.getUserByEmailPassword(Response.class, user.getEmail(), hashedPassword);
//        System.out.println(res);

        try {
//            Users a = shoesSessionBean.login(user.getEmail(), hashedPassword);
            Users as = shoesSessionBean.login(user.getEmail(), hashedPassword);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("user", as);
            session.setMaxInactiveInterval(15 * 60);
            us = (Users) session.getAttribute("user");
            clearUser();
            if (us.getRoleId().getRoleName() == "admin") {
//                System.out.println("in admin");
                return "/Admin/Index.xhtml?faces-redirect=true";
            } else {
                return "/index.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            return "SignIn.xhtml?faces-redirect=true";
        }
    }

    public void logoutUser() throws IOException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session.getAttribute("user") != null) {
            us = (Users) session.getAttribute("user");
            System.out.print(us);
            session.removeAttribute("user");
            ulog = new Users();
            FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/shoesfactory/faces/templet/SignIn.xhtml");
        }
            ulog = new Users();
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/shoesfactory/faces/templet/SignIn.xhtml");
    }

    public void validatePasswordCorrect(FacesContext context, UIComponent component,
            Object value) {

        // Retrieve the value passed to this method
        String confirmPassword = (String) value;

        // Retrieve the temporary value from the password field
        UIInput passwordInput = (UIInput) component.findComponent("password");
        String password = (String) passwordInput.getLocalValue();

        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['nomatch']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

    public static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            // handle error here.
        }

        return hash.toString();
    }
    
    public boolean checkLogged(){
        try{
             HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        ulog = (Users) session.getAttribute("user");
            return true;
        }
        catch(Exception e){
            ulog = new Users();
            return false;
        }
    }

    public void clearUser() {
        user = new Users();
        setPasswordConfirm("");
    }

    public ShoesSessionBeanLocal getShoesSessionBean() {
        return shoesSessionBean;
    }

    public void setShoesSessionBean(ShoesSessionBeanLocal shoesSessionBean) {
        this.shoesSessionBean = shoesSessionBean;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUlog() {
        return ulog;
    }

    public void setUlog(Users ulog) {
        this.ulog = ulog;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public GenericType<Users> getU() {
        return u;
    }

    public void setU(GenericType<Users> u) {
        this.u = u;
    }

    /**
     * Creates a new instance of auth
     */
    public auth() {
         user = new Users();
    }
    
}
