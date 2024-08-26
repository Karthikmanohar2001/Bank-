package com.Bank.project.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id ;
	private String c_name ;
	private String c_city ;
	private long c_contact ;
	
	@OneToOne
	private Account acnt  ;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_city() {
		return c_city;
	}

	public void setC_city(String c_city) {
		this.c_city = c_city;
	}

	public long getC_contact() {
		return c_contact;
	}

	public void setC_contact(long c_contact) {
		this.c_contact = c_contact;
	}

	public Account getAcnt() {
		return acnt;
	}

	public void setAcnt(Account acnt) {
		this.acnt = acnt;
	}

	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", c_city=" + c_city + ", c_contact=" + c_contact
				+ ", acnt=" + acnt + "]";
	}
	
	
	

}
