package edu.iiitb.ebay.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.ebay.dao.PaymentDAO;
import edu.iiitb.ebay.model.entity.ProductModel;
import edu.iiitb.ebay.model.entity.SellerModel;
import edu.iiitb.ebay.model.entity.UserModel;
import edu.iiitb.ebay.model.page.CartPageModel;
import edu.iiitb.ebay.util.ConstantValues;

public class PaymentAction extends ActionSupport{
	String atmNumber;
	String pinNumber;
	String accountNumber;
	String password;
	
	float initialBalanceUser;
//	int initialBalanceSeller;
	float initialBalanceEbay;
	float currentBalanceUser;
//	int currentBalanceSeller;
	float currentBalanceEbay;
	
	public float getInitialBalanceUser() {
		return initialBalanceUser;
	}

	public void setInitialBalanceUser(int initialBalanceUser) {
		this.initialBalanceUser = initialBalanceUser;
	}

//	public int getInitialBalanceSeller() {
//		return initialBalanceSeller;
//	}

//	public void setInitialBalanceSeller(int initialBalanceSeller) {
//		this.initialBalanceSeller = initialBalanceSeller;
//	}

	public float getInitialBalanceEbay() {
		return initialBalanceEbay;
	}

	public void setInitialBalanceEbay(int initialBalanceEbay) {
		this.initialBalanceEbay = initialBalanceEbay;
	}

	public float getCurrentBalanceUser() {
		return currentBalanceUser;
	}

	public void setCurrentBalanceUser(int currentBalanceUser) {
		this.currentBalanceUser = currentBalanceUser;
	}

//	public int getCurrentBalanceSeller() {
//		return currentBalanceSeller;
//	}
//
//	public void setCurrentBalanceSeller(int currentBalanceSeller) {
//		this.currentBalanceSeller = currentBalanceSeller;
//	}

	public float getCurrentBalanceEbay() {
		return currentBalanceEbay;
	}

	public void setCurrentBalanceEbay(int currentBalanceEbay) {
		this.currentBalanceEbay = currentBalanceEbay;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAtmNumber() {
		return atmNumber;
	}

	public void setAtmNumber(String atmNumber) {
		this.atmNumber = atmNumber;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String debitCardPay(){
		PaymentDAO paymentDAO = new PaymentDAO();
		int userId = ((UserModel)ActionContext.getContext().getSession().get("user")).getUserId();
		//int userId =2;
		boolean isValidated = paymentDAO.validateDebitCard(userId,atmNumber,pinNumber);
		if(!isValidated)
			return Action.ERROR;
		initialBalanceUser=PaymentDAO.getBalance(userId);
		initialBalanceEbay=PaymentDAO.getBalance(ConstantValues.EbayUserID);
		ArrayList<CartPageModel> cartList = (ArrayList<CartPageModel>)ActionContext.getContext().getSession().get("cartList");
		for (CartPageModel cartPageModel : cartList) {
			float moneyToBeDeductedForThisCartItem = (cartPageModel.getProduct().getPrice()-cartPageModel.getProduct().getDiscount())*cartPageModel.getProduct().getQuantity();
			int sellerId = paymentDAO.getSellerId(cartPageModel.getProduct().getProductId());
			SellerModel seller = paymentDAO.getSeller(sellerId);
			
			//deduct Money from buyer account
			int flag = paymentDAO.deduceMoney(userId,moneyToBeDeductedForThisCartItem);
				//if there is no sufficient Money, inform the user that he has insufficient funds to buy
				if (flag == ConstantValues.INSUFFICIENT_MONEY)
					return "insufficientMoney";
			//credit money into sellers account
			float moneyToBeCreditedIntoEbay =(seller.getSla()*moneyToBeDeductedForThisCartItem)/100;
			float moneyToBeCreditedIntoSeller = moneyToBeDeductedForThisCartItem-moneyToBeCreditedIntoEbay;
			flag = paymentDAO.creditMoney(seller.getUserId(),moneyToBeCreditedIntoSeller);
			//credit money into ebay account as per seller SLA
			flag = paymentDAO.creditMoney(ConstantValues.EbayUserID,moneyToBeCreditedIntoEbay);
			//make type of the item in cart 'B' which means it is bought
			flag = paymentDAO.updateCartItemStatus(cartPageModel.getCartId(),'B');
			//insert the bought cart item in order table
			flag = paymentDAO.insertIntoOrderTable(userId,sellerId,cartPageModel.getProduct().getProductId(),"\"PAYMENT_RECEIVED\"",cartPageModel.getProduct().getQuantity());
			//Decrement Product Quantity
			flag = paymentDAO.decrementProductQuantity(cartPageModel.getProduct().getProductId(),cartPageModel.getProduct().getQuantity());			
		}
		currentBalanceUser=PaymentDAO.getBalance(userId);
		currentBalanceEbay=PaymentDAO.getBalance(ConstantValues.EbayUserID);
		return Action.SUCCESS;
	} 
	
	public String creditCardPay(){
		PaymentDAO paymentDAO = new PaymentDAO();
		int userId = ((UserModel)ActionContext.getContext().getSession().get("user")).getUserId();
		//int userId =2;
		boolean isValidated = paymentDAO.validateCreditCard(userId,accountNumber,password);
		if(!isValidated)
			return Action.ERROR;
		ArrayList<CartPageModel> cartList = (ArrayList<CartPageModel>)ActionContext.getContext().getSession().get("cartList");
		initialBalanceUser=PaymentDAO.getBalance(userId);
		initialBalanceEbay=PaymentDAO.getBalance(ConstantValues.EbayUserID);
		for (CartPageModel cartPageModel : cartList) {
			float moneyToBeDeductedForThisCartItem = (cartPageModel.getProduct().getPrice()-cartPageModel.getProduct().getDiscount())*cartPageModel.getProduct().getQuantity();
			int sellerId = paymentDAO.getSellerId(cartPageModel.getProduct().getProductId());
			SellerModel seller = paymentDAO.getSeller(sellerId);
			
			//deduct Money from buyer account
			int flag = paymentDAO.deduceMoney(userId,moneyToBeDeductedForThisCartItem);
				//if there is no sufficient Money, inform the user that he has insufficient funds to buy
				if (flag == ConstantValues.INSUFFICIENT_MONEY)
					return "insufficientMoney";
			//credit money into sellers account
			float moneyToBeCreditedIntoEbay =(seller.getSla()*moneyToBeDeductedForThisCartItem)/100;
			float moneyToBeCreditedIntoSeller = moneyToBeDeductedForThisCartItem-moneyToBeCreditedIntoEbay;
			flag = paymentDAO.creditMoney(seller.getUserId(),moneyToBeCreditedIntoSeller);
			//credit money into ebay account as per seller SLA
			flag = paymentDAO.creditMoney(ConstantValues.EbayUserID,moneyToBeCreditedIntoEbay);
			//make type of the item in cart 'B' which means it is bought
			flag = paymentDAO.updateCartItemStatus(cartPageModel.getCartId(),'B');
			//insert the bought cart item in order table
			flag = paymentDAO.insertIntoOrderTable(userId,sellerId,cartPageModel.getProduct().getProductId(),"PAYMENT_RECEIVED",cartPageModel.getProduct().getQuantity());
			//Decrement Product Quantity
			flag = paymentDAO.decrementProductQuantity(cartPageModel.getProduct().getProductId(),cartPageModel.getProduct().getQuantity());
		}
		currentBalanceUser=PaymentDAO.getBalance(userId);
		currentBalanceEbay=PaymentDAO.getBalance(ConstantValues.EbayUserID);
		return Action.SUCCESS;
	}
	public String debitCardBuyPay(){
		PaymentDAO paymentDAO = new PaymentDAO();
		int userId = ((UserModel)ActionContext.getContext().getSession().get("user")).getUserId();
		//int userId =2;
		boolean isValidated = paymentDAO.validateDebitCard(userId,atmNumber,pinNumber);
		if(!isValidated)
			return Action.ERROR;
		initialBalanceUser=PaymentDAO.getBalance(userId);
		initialBalanceEbay=PaymentDAO.getBalance(ConstantValues.EbayUserID);
		ProductModel product = (ProductModel)ActionContext.getContext().getSession().get("buyProduct");
		
			float moneyToBeDeductedForThisCartItem = (product.getPrice()-product.getDiscount())*product.getQuantity();
			int sellerId = paymentDAO.getSellerId(product.getProductId());
			SellerModel seller = paymentDAO.getSeller(sellerId);
			
			//deduct Money from buyer account
			int flag = paymentDAO.deduceMoney(userId,moneyToBeDeductedForThisCartItem);
				//if there is no sufficient Money, inform the user that he has insufficient funds to buy
				if (flag == ConstantValues.INSUFFICIENT_MONEY)
					return "insufficientMoney";
			//credit money into sellers account
			float moneyToBeCreditedIntoEbay =(seller.getSla()*moneyToBeDeductedForThisCartItem)/100;
			float moneyToBeCreditedIntoSeller = moneyToBeDeductedForThisCartItem-moneyToBeCreditedIntoEbay;
			flag = paymentDAO.creditMoney(seller.getUserId(),moneyToBeCreditedIntoSeller);
			//credit money into ebay account as per seller SLA
			flag = paymentDAO.creditMoney(ConstantValues.EbayUserID,moneyToBeCreditedIntoEbay);
			
			//insert the bought cart item in order table
			flag = paymentDAO.insertIntoOrderTable(userId,sellerId,product.getProductId(),"\"PAYMENT_RECEIVED\"",product.getQuantity());
			//Decrement Product Quantity
			flag = paymentDAO.decrementProductQuantity(product.getProductId(),product.getQuantity());			
		
		currentBalanceUser=PaymentDAO.getBalance(userId);
		currentBalanceEbay=PaymentDAO.getBalance(ConstantValues.EbayUserID);
		return Action.SUCCESS;
	} 
	
	public String creditCardBuyPay(){
		PaymentDAO paymentDAO = new PaymentDAO();
		int userId = ((UserModel)ActionContext.getContext().getSession().get("user")).getUserId();
		//int userId =2;
		boolean isValidated = paymentDAO.validateCreditCard(userId,accountNumber,password);
		if(!isValidated)
			return Action.ERROR;
		ArrayList<CartPageModel> cartList = (ArrayList<CartPageModel>)ActionContext.getContext().getSession().get("cartList");
		initialBalanceUser=PaymentDAO.getBalance(userId);
		initialBalanceEbay=PaymentDAO.getBalance(ConstantValues.EbayUserID);
		ProductModel product = (ProductModel)ActionContext.getContext().getSession().get("buyProduct");
		
			float moneyToBeDeductedForThisCartItem = (product.getPrice()-product.getDiscount())*product.getQuantity();
			int sellerId = paymentDAO.getSellerId(product.getProductId());
			SellerModel seller = paymentDAO.getSeller(sellerId);
			
			//deduct Money from buyer account
			int flag = paymentDAO.deduceMoney(userId,moneyToBeDeductedForThisCartItem);
				//if there is no sufficient Money, inform the user that he has insufficient funds to buy
				if (flag == ConstantValues.INSUFFICIENT_MONEY)
					return "insufficientMoney";
			//credit money into sellers account
			float moneyToBeCreditedIntoEbay =(seller.getSla()*moneyToBeDeductedForThisCartItem)/100;
			float moneyToBeCreditedIntoSeller = moneyToBeDeductedForThisCartItem-moneyToBeCreditedIntoEbay;
			flag = paymentDAO.creditMoney(seller.getUserId(),moneyToBeCreditedIntoSeller);
			//credit money into ebay account as per seller SLA
			flag = paymentDAO.creditMoney(ConstantValues.EbayUserID,moneyToBeCreditedIntoEbay);
			
			//insert the bought cart item in order table
			flag = paymentDAO.insertIntoOrderTable(userId,sellerId,product.getProductId(),"\"PAYMENT_RECEIVED\"",product.getQuantity());
			//Decrement Product Quantity
			flag = paymentDAO.decrementProductQuantity(product.getProductId(),product.getQuantity());			
		currentBalanceUser=PaymentDAO.getBalance(userId);
		currentBalanceEbay=PaymentDAO.getBalance(ConstantValues.EbayUserID);
		return Action.SUCCESS;
	}

}
