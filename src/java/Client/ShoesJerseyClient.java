/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        ShoesJerseyClient client = new ShoesJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class ShoesJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/shoesfactory/webresources";

    public ShoesJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public String deleteproduct(String pid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteproduct/{0}", new Object[]{pid})).request().post(null, String.class);
    }


    
    public <T> T searchuser(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchuser/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T showallusers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("displayuser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String update(String rid, String rname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("update/{0}/{1}", new Object[]{rid, rname})).request().put(null, String.class);
    }

    
     public String deleteuser(String uid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteuser/{0}", new Object[]{uid})).request().post(null, String.class);
    }
     
    public <T> T searchproduct(Class<T> responseType, String pid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchproduct/{0}", new Object[]{pid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String insertrole(String rid, String rname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("insertrole/{0}/{1}", new Object[]{rid, rname})).request().post(null, String.class);
    }

     public String insertproduct(String pid, String bid, String cid, String scid, String pname, String pdesc, String price, String img) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("insertproduct/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{pid, bid, cid, scid, pname, pdesc, price, img})).request().post(null, String.class);
    }
    public String deletesubcategoey(String scid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deletesubcategoey/{0}", new Object[]{scid})).request().post(null, String.class);
    }

    public String insertsubcategoey(String scid, String scname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("insertsubcategoey/{0}/{1}", new Object[]{scid, scname})).request().post(null, String.class);
    }

    public <T> T GetAllLogins_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllLogins");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T GetAllLogins_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("GetAllLogins");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T searchsubcategoey(Class<T> responseType, String scid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchsubcategoey/{0}", new Object[]{scid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String deleterole(String rid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleterole/{0}", new Object[]{rid})).request().post(null, String.class);
    }

    public <T> T searchbrand(Class<T> responseType, String bid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbrand/{0}", new Object[]{bid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T showallproduct(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("displayproduct");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
     public <T> T showallorder(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("displayorder");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String deletecategoey(String rid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deletecategoey/{0}", new Object[]{rid})).request().post(null, String.class);
    }

    public String insertcategoey(String cid, String cname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("insertcategoey/{0}/{1}", new Object[]{cid, cname})).request().post(null, String.class);
    }

    public <T> T showallrole(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("showallrole");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T searchcategoey(Class<T> responseType, String rid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchcategoey/{0}", new Object[]{rid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String updatebrand(String bid, String bname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updatebrand/{0}/{1}", new Object[]{bid, bname})).request().put(null, String.class);
    }

    public <T> T searchrole(Class<T> responseType, String rid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchrole/{0}", new Object[]{rid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T showallsubcategoey(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("showallsubcategoey");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String updatesubcategoey(String scid, String scname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updatesubcategoey/{0}/{1}", new Object[]{scid, scname})).request().put(null, String.class);
    }

    public String updateproduct(String pid, String bid, String cid, String scid, String pname, String pdesc, String price, String img) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateproduct/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{pid, bid, cid, scid, pname, pdesc, price, img})).request().post(null, String.class);
    }

    public String insertbrand(String bid, String bname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("insertbrand/{0}/{1}", new Object[]{bid, bname})).request().post(null, String.class);
    }

    public String updatecategoey(String rid, String rname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updatecategoey/{0}/{1}", new Object[]{rid, rname})).request().put(null, String.class);
    }

    public <T> T showallbrand(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("showallbrand");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String adduser(String uid, String ufname, String ulname, String phoneno, String email, String password, String rid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("adduser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{uid, ufname, ulname, phoneno, email, password, rid})).request().post(null, String.class);
    }


    public String deletebrand(String bid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deletebrand/{0}", new Object[]{bid})).request().post(null, String.class);
    }

    public <T> T showallcategoey(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("showallcategoey");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String updateuser(String uid, String ufname, String ulname, String phoneno, String email, String password, String rid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateuser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{uid, ufname, ulname, phoneno, email, password, rid})).request().post(null, String.class);
    }

    public void close() {
        client.close();
    }

  
    
}
