package com.Bank.project.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int m_id ;
	private String m_name ;
	private String m_city ;
	private long m_contact ;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bank bank ;

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_city() {
		return m_city;
	}

	public void setM_city(String m_city) {
		this.m_city = m_city;
	}

	public long getM_contact() {
		return m_contact;
	}

	public void setM_contact(long m_contact) {
		this.m_contact = m_contact;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "Manager [m_id=" + m_id + ", m_name=" + m_name + ", m_city=" + m_city + ", m_contact=" + m_contact
				+ ", bank=" + bank + "]";
	}
	
	
	
	

}
