package edu.iiitb.ebay.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction extends ActionSupport{
	public String selectModeOfPayment(){
		return Action.SUCCESS;
	}
	public String debitCard(){
		return Action.SUCCESS;
	}
	public String creditCard(){
		return Action.SUCCESS;
	}
	public String cashOnDelivery(){
		return Action.SUCCESS;
	}
	public String debitCardBuy(){
		return Action.SUCCESS;
	}
	public String creditCardBuy(){
		return Action.SUCCESS;
	}
	public String cashOnDeliveryBuy(){
		return Action.SUCCESS;
	}
}
