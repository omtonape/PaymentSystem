package com.ingenico.payment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mahendra
 * Pojo class repersenting database table account
 * ID is primary key and name is assumed as unique
 */
@Entity
@Table(name="account")
public class Account implements Serializable{
	private static final long serialVersionUID = 3039189851979895612L;
	
	@Id
	@GeneratedValue()
	private long id;
	
	@Column(nullable = false, unique= true)
	private String name;
	
	@Column(nullable = false)
	private double balance;
	
	public Account() {
	}

	public Account(long id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		StringBuilder sb = new StringBuilder("Account [");
		sb.append("id="+id).append(", name="+name).append(", balance= "+balance).append("]");
		return sb.toString();
	}
	
	
}
