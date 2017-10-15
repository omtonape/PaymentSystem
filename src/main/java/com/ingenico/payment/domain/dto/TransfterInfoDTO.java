package com.ingenico.payment.domain.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TransfterInfoDTO implements Serializable {

	private static final long serialVersionUID = -6091974304805381662L;
	private String srcName;
	private String destName;
	private double amount;
	
	public TransfterInfoDTO (){
		
	}
	public TransfterInfoDTO(String srcName, String destName, double amount) {
		this.srcName = srcName;
		this.destName = destName;
		this.amount = amount;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("TransfterInfoDTO [srcName = ");
		sb.append(srcName+", destName = ").append(destName).append(", amount = ").append(amount);
		return  sb.toString();
	}
	public String getSrcName() {
		return srcName;
	}
	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}
	public String getDestName() {
		return destName;
	}
	public void setDestName(String destName) {
		this.destName = destName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
