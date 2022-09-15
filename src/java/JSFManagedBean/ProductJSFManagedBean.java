/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import Client.ShoesJerseyClient;
import Entity.*;
import SessionBean.ShoesSessionBeanLocal;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.Part;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author admin
 */
@Named(value = "productJSFManagedBean")
@ApplicationScoped
public class ProductJSFManagedBean {

    @EJB
    private ShoesSessionBeanLocal shoesSessionBean;

    ShoesJerseyClient pbl = new ShoesJerseyClient();

    int pid, bid, cid, scid, price;
    String pname, pdesc, img;

    private List<Brand> blist;
    private List<Category> clist;
    private List<Subcategory> sclist;

    private List<Product> plist;

    private Part uploadedFile;
    private String file = "E:\\shoesfactory\\shoesfactory-war\\web\\templet\\Admin\\uploads";

//      Pbkdf2PasswordHashImpl pb   
    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String folder) {
        this.file = file;
    }

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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Brand> getBlist() {
        return blist;
    }

    public void setBlist(List<Brand> blist) {
        this.blist = blist;
    }

    public List<Category> getClist() {
        return clist;
    }

    public void setClist(List<Category> clist) {
        this.clist = clist;
    }

    public List<Subcategory> getSclist() {
        return sclist;
    }

    public void setSclist(List<Subcategory> sclist) {
        this.sclist = sclist;
    }

    public List<Product> getPlist() {
        return plist;
    }

    public void setPlist(List<Product> plist) {
        this.plist = plist;
    }

    public List<Brand> showbrand() {
        Response response = pbl.showallbrand(Response.class);
        ArrayList<Brand> blist = new ArrayList<>();
        GenericType<List<Brand>> cAdd = new GenericType<List<Brand>>() {
        };
        blist = (ArrayList<Brand>) response.readEntity(cAdd);
        return blist;
    }

    public List<Category> showcategory() {
        Response response = pbl.showallcategoey(Response.class);
        ArrayList<Category> clist = new ArrayList<>();
        GenericType<List<Category>> cAdd = new GenericType<List<Category>>() {
        };
        clist = (ArrayList<Category>) response.readEntity(cAdd);
        return clist;
    }

    public List<Subcategory> showsubcategory() {
        Response response = pbl.showallsubcategoey(Response.class);
        ArrayList<Subcategory> sclist = new ArrayList<>();
        GenericType<List<Subcategory>> cAdd = new GenericType<List<Subcategory>>() {
        };
        sclist = (ArrayList<Subcategory>) response.readEntity(cAdd);
        return sclist;
    }

    public List<Product> showproduct() {
        Response response = pbl.showallproduct(Response.class);
        ArrayList<Product> plist = new ArrayList<>();
        GenericType<List<Product>> bAdd = new GenericType<List<Product>>() {
        };
        plist = (ArrayList<Product>) response.readEntity(bAdd);
        return plist;
    }

    public String insertproduct() {
        try {
            InputStream input = uploadedFile.getInputStream();
            String path = "E:\\shoesfactory\\web\\templet\\Admin\\uploads";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            img = "IMG_" + temp + uploadedFile.getSubmittedFileName();
            Files.copy(input, new File(path, img).toPath());
            
            pbl.insertproduct(String.valueOf(pid), String.valueOf(bid), String.valueOf(cid), String.valueOf(scid), pname, pdesc, String.valueOf(price), img);
            return "/templet/Admin/Product.xhtml";

            
            
            
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public void editproduct(int id) {

        Response response = pbl.searchproduct(Response.class, String.valueOf(id));
        GenericType<Product> productsearch = new GenericType<Product>() {
        };
        Product p = response.readEntity(productsearch);

        pid = p.getPId();
        bid = p.getBId().getBId();
        cid = p.getCId().getCId();
        scid = p.getScId().getScId();
        pname = p.getPName();
        pdesc = p.getPDescription();
        price = p.getPrice();
        img = p.getImage();

    }

    public void updateproduct() {

        try {
            pbl.updateproduct(String.valueOf(pid), String.valueOf(bid), String.valueOf(cid),
                    String.valueOf(scid), pname, pdesc, String.valueOf(price), img);
        } catch (ClientErrorException e) {
            System.out.println(e);
            e.getMessage();
        }
    }

    public void deleteproduct(int pid) {
        pbl.deleteproduct(String.valueOf(pid));
        System.out.println(pid);
    }

    public void getproducthname(String pname) {
        shoesSessionBean.getProductName(pname);
    }

    public List<Product> listByName() {
      
            List<Product> p = shoesSessionBean.getProductName(pname);;
            return p;
            
    }

    /**
     * Creates a new instance of ProductJSFManagedBean
     */
    public ProductJSFManagedBean() {
    }

}
