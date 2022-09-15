/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import Entity.*;
import SessionBean.ShoesSessionBeanLocal;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("generic")
@RequestScoped
public class GenericResource {

    @EJB
    private ShoesSessionBeanLocal sf;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               Roles Rest Business Logic                               /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Path("insertrole/{rid}/{rname}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String insertrole(@PathParam("rid") int id, @PathParam("rname") String name) {
        return sf.insertroles(id, name);
    }

    @Path("showallrole")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roles> showallrole() {
        return sf.showallroles();
    }

    @Path("update/{rid}/{rname}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@PathParam("rid") int id, @PathParam("rname") String name) {
        return sf.updateroles(id, name);
    }

    @Path("deleterole/{rid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String deleterole(@PathParam("rid") int id) {
        return sf.deleteroles(id);
    }

    @Path("searchrole/{rid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Roles searchrole(@PathParam("rid") int id) {
        return sf.searchroles(id);
    }

    //   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               Brand Rest Business Logic                               /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Path("insertbrand/{bid}/{bname}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String insertbrand(@PathParam("bid") int id, @PathParam("bname") String name) {
        return sf.insertbrand(id, name);
    }

    @Path("showallbrand")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Brand> showallbrand() {
        return sf.showallbrand();
    }

    @Path("updatebrand/{bid}/{bname}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String updatebrand(@PathParam("bid") int id, @PathParam("bname") String name) {
        return sf.updatebrand(id, name);
    }

    @Path("deletebrand/{bid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String deletebrand(@PathParam("bid") int id) {
        return sf.deletebrand(id);
    }

    @Path("searchbrand/{bid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Brand searchbrand(@PathParam("bid") int id) {
        return sf.searchbrand(id);
    }

//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               Category Rest Business Logic                            /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Path("insertcategoey/{cid}/{cname}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String insertcategoey(@PathParam("cid") int id, @PathParam("cname") String name) {
        return sf.insertcategory(id, name);
    }

    @Path("showallcategoey")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> showallcategoey() {
        return sf.showallcategory();
    }

    @Path("updatecategoey/{rid}/{rname}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String updatecategoey(@PathParam("rid") int id, @PathParam("rname") String name) {
        return sf.updatecategory(id, name);
    }

    @Path("deletecategoey/{rid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String deletecategoey(@PathParam("rid") int id) {
        return sf.deletecategory(id);
    }

    @Path("searchcategoey/{rid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Category searchcategoey(@PathParam("rid") int id) {
        return sf.searchcategory(id);
    }

//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               SubCatgory Rest Business Logic                          /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Path("insertsubcategoey/{scid}/{scname}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String insertsubcategoey(@PathParam("scid") int id, @PathParam("scname") String name) {
        return sf.insertsubcategory(id, name);
    }

    @Path("showallsubcategoey")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subcategory> showallsubcategoey() {
        return sf.showallsubcategory();
    }

    @Path("updatesubcategoey/{scid}/{scname}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String updatesubcategoey(@PathParam("scid") int id, @PathParam("scname") String name) {
        return sf.updatsubcategory(id, name);
    }

    @Path("deletesubcategoey/{scid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String deletesubcategoey(@PathParam("scid") int id) {
        return sf.deletesubcategory(id);
    }

    @Path("searchsubcategoey/{scid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Subcategory searchsubcategoey(@PathParam("scid") int id) {
        return sf.searchsubcategory(id);
    }

//   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               User Rest Business Logic                          /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Path("adduser/{uid}/{ufname}/{ulname}/{phoneno}/{email}/{password}/{rid}")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public String adduser(@PathParam("uid") int uid, @PathParam("ufname") String ufname, @PathParam("ulname") String ulname,
            @PathParam("phoneno") long phoneno, @PathParam("email") String email, @PathParam("password") String password,
            @PathParam("rid") int rid) {
        return sf.insertuser(uid, ufname, ulname, phoneno, email, password, rid);
    }

    @Path("updateuser/{uid}/{ufname}/{ulname}/{phoneno}/{email}/{password}/{rid}")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public String updateuser(@PathParam("uid") int uid, @PathParam("ufname") String ufname, @PathParam("ulname") String ulname,
            @PathParam("phoneno") long phoneno, @PathParam("email") String email, @PathParam("password") String password,
            @PathParam("rid") int rid) {
        return sf.updateuser(uid, ufname, ulname, phoneno, email, password, rid);
    }

    @Path("deleteuser/{uid}")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public String deleteuser(@PathParam("uid") int uid) {
        return sf.deleteuser(uid);
    }

    @Path("displayuser")
    @GET
//    @Produces("application/json")
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> showallusers() {
        return sf.showalluser();
    }

    @Path("searchuser/{uid}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)

    public Users searchuser(@PathParam("uid") int uid) {
        return sf.searchuser(uid);
    }

    //   ///////////////////////////////////////////////////////////////////////////////////////// // 
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ////////////                                                                  /////////// //    
//   ////////////               Product Rest Business Logic                          /////////// //     
//   /////////////                                                                 /////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //    
//   ///////////////////////////////////////////////////////////////////////////////////////// //
    @Path("insertproduct/{pid}/{bid}/{cid}/{scid}/{pname}/{pdesc}/{price}/{img}")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public String insertproduct(@PathParam("pid") int pid, @PathParam("bid") int bid, @PathParam("cid") int cid,
            @PathParam("scid") int scid, @PathParam("pname") String pname, @PathParam("pdesc") String pdesc,
            @PathParam("price") int price, @PathParam("img") String img) {
        return sf.insertproduct(pid, bid, cid, scid, pname, pdesc, price, img);
    }

    @Path("updateproduct/{pid}/{bid}/{cid}/{scid}/{pname}/{pdesc}/{price}/{img}")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public String updateproduct(@PathParam("pid") int pid, @PathParam("bid") int bid, @PathParam("cid") int cid,
            @PathParam("scid") int scid, @PathParam("pname") String pname, @PathParam("pdesc") String pdesc,
            @PathParam("price") int price, @PathParam("img") String img) {
        return sf.updateproduct(pid, bid, cid, scid, pname, pdesc, price, img);
    }

    @Path("deleteproduct/{pid}")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public String deleteproduct(@PathParam("pid") int pid) {
        return sf.deleteproduct(pid);
    }

    @Path("displayproduct")
    @GET
//    @Produces("application/json")
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> showallproduct() {
        return sf.showallproduct();
    }

    @Path("searchproduct/{pid}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)

    public Product searchproduct(@PathParam("pid") int pid) {
        return sf.searchproductr(pid);
    }

    //Login
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("GetAllLogins")
    public Collection<Users> GetAllLogins() {
        Collection<Users> logins = sf.GetAllLogins();
        return logins;
    }
    
    @Path("displayorder")
    @GET
//    @Produces("application/json")
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order1> showallorder() {
        return sf.showallorder();
    }
}
