package com.ingenico.payment.domain.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountDTO implements Serializable{
	private static final long serialVersionUID = 7043874189520912608L;

	private String name;
	
	private double balance;
	
	public AccountDTO() {
	}
	public AccountDTO(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[AccountDTO : ");
		sb.append("Name : "+name).append(", balance : "+balance).append("]");
		return sb.toString();
	}
}
