/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author admin
 */
@Named(value = "orderJSFManagedBean")
@ApplicationScoped
public class OrderJSFManagedBean {

     @EJB
    private ShoesSessionBeanLocal shoesSessionBean;

    ShoesJerseyClient pbl = new ShoesJerseyClient();

    private List<Order1> olist;

    /**
     * Creates a new instance of OrderJSFManagedBean
     */
    public OrderJSFManagedBean() {
    }
    
     public List<Order1> showorder() {
        Response response = pbl.showallorder(Response.class);
        ArrayList<Order1> plist = new ArrayList<>();
        GenericType<List<Order1>> bAdd = new GenericType<List<Order1>>() {
        };
        olist = (ArrayList<Order1>) response.readEntity(bAdd);
        return olist;
    }
    
}
