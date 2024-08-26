package com.Bank.project.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int a_id ;
	private String a_type ;
	private double a_balance ;
	private long a_number ;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer ; 
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Tranaction> tranaction ;

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_type() {
		return a_type;
	}

	public void setA_type(String a_type) {
		this.a_type = a_type;
	}

	public double getA_balance() {
		return a_balance;
	}

	public void setA_balance(double a_balance) {
		this.a_balance = a_balance;
	}

	public long getA_number() {
		return a_number;
	}

	public void setA_number(long a_number) {
		this.a_number = a_number;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Tranaction> getTranaction() {
		return tranaction;
	}

	public void setTranaction(List<Tranaction> tranaction) {
		this.tranaction = tranaction;
	}

	@Override
	public String toString() {
		return "Account [a_id=" + a_id + ", a_type=" + a_type + ", a_balance=" + a_balance + ", a_number=" + a_number
				+ ", customer=" + customer + ", tranaction=" + tranaction + "]";
	}
	
	
	
	

}
