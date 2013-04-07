package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.NotifySellerDAO;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.UserModel;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NotifySellerAction extends ActionSupport{
	
	ArrayList<ProductModel> productList;
	int sellerId;
	int productId;
	
	
	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ArrayList<ProductModel> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<ProductModel> productList) {
		this.productList = productList;
	}

	
	
	

	public String execute(){
		NotifySellerDAO notifySellerDAO = new NotifySellerDAO();
		ProductModel product = notifySellerDAO.getProduct(productId);
		String ret=sendMail(product);
		System.out.println(ret);
		return ret ;
	}
	
	public String sendMail(ProductModel product){
		UserModel user ;
		NotifySellerDAO notifySellerDAO = new NotifySellerDAO();
		user = notifySellerDAO.getUserWithSellerId(product.getSellerId());
		addActionMessage(user.getFirstName()+"is intimated about his product getting out of stock");
		String host = "smtp.gmail.com";
		String userid = "vamsi2k18";
		String password = "81k2vamsi";		
		//Send email to user.getEmail()
		final String from="vamsi2k18";
		final String fromPassword="81k2vamsi";
		String subject="Your Product is getting out of stock";
		String body="The present quantity of your product "+product.getTitle()+"is"+product.getQuantity()+" Please update the quantity";
		String ret = SUCCESS;
		Properties props =new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.setProperty("mail.transport.protocol", "smtps");
		props.put("mail.smtp.user", userid);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "false");
		
		
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
	      try
	      {
	         Session session = Session.getDefaultInstance(props,  
	            new javax.mail.Authenticator() {
	            protected PasswordAuthentication 
	            getPasswordAuthentication() {
	            return new 
	            PasswordAuthentication(from, fromPassword);
	            }});

	         Message message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.setRecipients(Message.RecipientType.TO, 
	            InternetAddress.parse(user.getEmail()));
	         message.setSubject(subject);
	         message.setText(body);
	         Transport.send(message);
	      }
	      catch(Exception e)
	      {
	         ret = ERROR;
	         e.printStackTrace();
	      }
	      return ret;
	}
	public String notifyAllSellers(){
		productList= (ArrayList<ProductModel>)ActionContext.getContext().getSession().get("notifySellersProductList");
		for (ProductModel product: productList) {
			sendMail(product);
		}
		addActionMessage("All users are intimated about their products getting out of stock");
		return Action.SUCCESS;
	}
}
