package com.Bank.project.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.Bank.project.DTO.Account;
import com.Bank.project.DTO.Bank;
import com.Bank.project.DTO.Customer;
import com.Bank.project.DTO.Manager;
import com.Bank.project.DTO.Tranaction;




public class Dao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Bank saveBank(Bank b)
	{
		et.begin();
		em.persist(b);
		et.commit();
		return b ;
	}
	public Bank findBank(int n)

	{
		Bank b = em.find(Bank.class, n);
		if(b!=null)
		{
			return b ;
		}
		else
		{
			return null ;
		}
	}

	public List<Bank> listOFBank()
	{
		Query q = em.createQuery("select b from Bank b");
		List<Bank> allbank = q.getResultList();
		if(!allbank.isEmpty())
		{
			return allbank ;
		}
		else
		{
			return null ;
		}
	}
		
 	public Bank updateBank(Bank b)
 	{
 		et.begin();
 		em.merge(b);
 		et.commit();
 		return b ;
 		
 	}
 	
 	public Bank deleteBank(int id)
	{
		Bank b = em.find(Bank.class, id);
		if(b!=null)
		{
		et.begin();
		em.remove(b);
		et.commit();
		return b ;
		}
		else
		{
			return null ;
		}
	}
 	
 	
	// Manager 
	
	public com.Bank.project.DTO.Manager saveMgr(Manager m)
	{
		et.begin();
		em.persist(m);
		et.commit();
		return m ;
		
	}
	
	public Manager findMgr(int id)
	{
		Manager m = em.find(Manager.class, id);
		if(m!=null)
		{
			return m ;
		}
		else
		{
			return null ;
		}
	}
	
	public List<Manager> listOfMgr()
	{
	Query q = em.createQuery("select m from Manager m");
	List<Manager> mgrList = q.getResultList();
	if(!mgrList.isEmpty())
	{
		return mgrList ;
	}
	else
	{
		return null ;
	}
		
	}
	
	public Manager updateMgr(Manager m)
	{
		et.begin();
		em.merge(m);
		et.commit();
		return m ;		
	}
	
	public Manager deleteMgr(int id)
	{
		Manager m = em.find(Manager.class, id);
		if(m!=null)
		{
			return m ;
		}
		else
		{
			return null ;
		}
	}

	
	// Customer
	
	  	public Customer saveCustomer(Customer c)
		
		{
			et.begin();
			em.persist(c);
			et.commit();
			return c ;
		}
		
	  	public Customer findCustomer(int id)
	  	{
	  		Customer c = em.find(Customer.class, id);
	  		if(c!=null)
	  		{
	  			return c ;
	  		}
	  		else
	  		{
	  			return null ;
	  		}
	  		
	  	}
	  	
	  	public List<Customer> listOfCustomer()
	  	{
	  		Query q = em.createQuery("select c from Customer c");
	  		List<Customer> custList = q.getResultList();
	  		if(!custList.isEmpty())
	  		{
	  			return custList ;
	  		}
	  		else
	  		{
	  			return null ;
	  		}
	  	}

		public Customer updateCustomer(Customer c)
		{
			et.begin();
			em.merge(c);
			et.commit();
			return c ;
		}
		
		public Customer deleteCustomer(int id)
		{
			Customer c = em.find(Customer.class, id);
			if(c!=null)
			{
				return c ;
			}
			else
			{
				return null ;
			}
		}
		
		// |Account
		// Verification
		
		public Customer verifyAccount(String name,long contact)
		{
			Query q = em.createQuery("select c from Customer c ");
			
			List<Customer> cus =  q.getResultList();
			
			for(Customer c:cus)
			{
				if(c.getC_name().equals(name) && c.getC_contact()==contact)
				{
					
					return c;
				}
				
			}
			return null;
			
		}
		
		
		public Account saveAccount(Account a)
		{
			et.begin();
			em.persist(a);
			et.commit();
			return a ;
			
		}
		
		public List<Account> listOfAccount()
		{
			Query q = em.createQuery("select a from  Account a");
			List<Account> accList = q.getResultList();
			if(!accList.isEmpty())
			{
				return accList ;
			}
			else
			{
				return null ;
			}
		}
		
		public Account findAccount(int id)
		{
			Account a = em.find(Account.class, id);
			if(a!=null)
			{
				return a ;
			}
			else
			{
				return null ;
			}
		}
		
		
		public Account updateAccount(Account a)
		{
			et.begin();
			em.merge(a);
			et.commit();
			return a ;
		}
		
		
		public Account deleteAccount(int id)
		{
			Account a = em.find(Account.class, id);
			if(a!=null)
			{
				return a ;
			}
			else
			{
				return null ;
			}
		}
		
		// Transaction 
		
		public Tranaction saveTranaction(Tranaction t)
		{
			et.begin();
			em.persist(t);
			et.commit();
			return t ;
		}
		
		
		public Customer findContact(long contact)
		{
			List<Customer> c_list = listOfCustomer();
			for (Customer cu : c_list) {
				if(cu.getC_contact()==contact)
				{
					return cu ;
				}
			}
			return null ;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

