package pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import baseClasses.Order.OrderStatus;
import baseClasses.Order;
import baseClasses.Page;
import baseClasses.Product;
import baseClasses.User;

/**
 * @author 
 *
 */

@Named
@SessionScoped
public class AddRemoveAdmin extends Page implements Serializable {
	
	private String uName;
	private String eMail;
	private String pWord;
	private ArrayList<Order> arr = new ArrayList<Order>();
	/**
	 * Default serialVersionID generated from eclipse
	 */
	private static final long serialVersionUID = 1L;
	
	public void test(){
		Product p = new Product("test","1", 123, "", "description", 100, 10);
		ArrayList<Product> arr = new ArrayList<Product>();
		arr.add(p);
		Order o = new Order(100,arr,"date",OrderStatus.IN_PROCESS);
		ArrayList<Order> arr2 = new ArrayList<Order>();
		arr2.add(o);
		User u = new User(0001, "test",arr2,"Testemail", "password", false);
		super.updateDB(u);
	}	
	public void setUName(String uName){
		this.uName = uName;
	} 
	public void setEMail(String eMail){
		this.eMail = eMail;
	}
	public void setPWord(String pWord){
		this.pWord = pWord;
	}
	public String getPWord(){
		return pWord;
	}
	public String getEMail(){
		return eMail;
	}
	public String getUName(){
		return uName;
	}
	
	public void addUser(){ 
		User u = new User(0001, uName, arr , eMail, pWord ,false);
		super.updateDB(u);
	}
	
	public void removeUser(String uName){
		super.updateDB("remove from webshopDB where name="+uName);
	} 
}