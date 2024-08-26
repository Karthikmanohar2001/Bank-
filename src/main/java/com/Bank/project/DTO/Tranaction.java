package com.Bank.project.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tranaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int t_id ;
	private String t_type ;
	private double t_amount ;
	private String t_status ;
	private int acntid  ;
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_type() {
		return t_type;
	}
	public void setT_type(String t_type) {
		this.t_type = t_type;
	}
	public double getT_amount() {
		return t_amount;
	}
	public void setT_amount(double t_amount) {
		this.t_amount = t_amount;
	}
	public String getT_status() {
		return t_status;
	}
	public void setT_status(String t_status) {
		this.t_status = t_status;
	}
	public int getAcntid() {
		return acntid;
	}
	public void setAcntid(int i) {
		this.acntid = i;
	}
	@Override
	public String toString() {
		return "Tranaction [t_id=" + t_id + ", t_type=" + t_type + ", t_amount=" + t_amount + ", t_status=" + t_status
				+ ", acntid=" + acntid + "]";
	}
	
	
	
	
	

}
