package com.Bank.project.DAO;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.transaction.Transaction;
import com.Bank.project.DTO.Account;
import com.Bank.project.DTO.Bank;
import com.Bank.project.DTO.Customer;
import com.Bank.project.DTO.Manager;
import com.Bank.project.DTO.Tranaction;

public class Controller {
	
	Scanner s = new Scanner(System.in);
	
	Dao dao = new Dao();
	
	// Bank
	
	public void createBank()
	{
		Bank b = new Bank();
		
		System.out.println("Enter the BANK NAME : ");
		b.setBname(s.nextLine());
		
		System.out.println("Enter the IFSC Code : ");
		b.setIfsc(s.nextLine());
		
		System.out.println("Enter Bank CITY : ");
		b.setCity(s.nextLine());
		
		System.out.println("Enter Bank Contact : ");
		b.setContact(s.nextLong());
		
		b.setMgr(null);
		
		List<Customer> cutomer = new ArrayList<>();
		b.setCustomer(cutomer);
		
		if(dao.saveBank(b) != null)
		{
			System.out.println("Bank is created ");
		}
		else
		{
			System.out.println("Process failed");
		}
		
		
	}
	
	public void findBank()
	{
		System.out.println("Enter Bank Id : ");
		int id = s.nextInt();
		
		Bank b = dao.findBank(id);
		
		if(b!=null)
		{
			System.out.println(b.getId()+" "+b.getBname()+" "+b.getCity()+" "+b.getContact());
		}
		else
		{
			System.out.println("Bank Not FOUND ");
		}
		
	}

	public void listOFBanks()
	{
		List<Bank> bankList = dao.listOFBank();
		for (Bank b : bankList) {
			System.out.println(b.getId());
			System.out.println(b.getBname());
			System.out.println(b.getCity());
			System.out.println(b.getContact());
		}
	}
	
	public void updateBank()
		{
			List<Bank> details = dao.listOFBank();
			for (Bank b : details) {
				System.out.println(b.getId());
				System.out.println(b.getBname());
				System.out.println(b.getIfsc());
			System.out.println(b.getCity());
			System.out.println(b.getContact());
		}
			
			System.out.println("Enter the ID ,you want to update ");
			Bank b = dao.findBank(s.nextInt());
					
				System.out.println("Enter 1 to Update Bank Name");
				System.out.println("Enter 2 to Update Bank IFSC code ");
				System.out.println("Enter 3 to Update Bank City ");
				System.out.println("Enter 4 to Update Bank contact ");
			
				int val = s.nextInt();
				
				switch(val)
				{
				case 1:
				{
					System.out.println("Enter New Bank Name to be updated");
					b.setBname(s.nextLine());
					Bank ba = dao.updateBank(b);
					if(ba!=null)
					{
						System.out.println("New Bank Name updated ");
					}
					else
					{
						System.out.println("Updating bank name failed");
					}
					break ;
				}
				case 2 :
				{
					System.out.println("Enter New Bank IFSC code to be updated ");
					b.setIfsc(s.nextLine());
					Bank ba = dao.updateBank(b);
					if(ba!=null)
					{
						System.out.println("New IFSC code Updated");
	
					}
					else
					{
						System.out.println("updating Bank IFSC code failed");
					}
				
				}
				
				case 3 :
				{
					System.out.println("Enter New City to be Updated");
					b.setCity(s.nextLine());
					Bank ba = dao.updateBank(b);
					if(ba!=null)
					{
						System.out.println("New Bank city is updated ");
					}
					else
					{
						System.out.println("updating new city failed");
					}	
				}
				
				case 4 :
				{
					System.out.println("Enter New Bank Contact no ");
					b.setContact(s.nextLong());
					Bank ba = dao.updateBank(b);
					if(ba!=null)
					{
						System.out.println("New Contact no is Updated");
					}
					else
					{
						System.out.println("updating new contact is failed");
					}
				}
				
				}
		}

	public void deleteBank()
	{
		System.out.println("Enter Bank Id to delete : ");
		int id = s.nextInt();
		
		Bank b = dao.findBank(id);
		
		if(b!=null)
		{
			Bank ba = dao.deleteBank(id);
			System.out.println("Bank deleted ");
		}
		else
		{
			System.out.println("Bank deletion process failed");
		}

	}
	
	
	// Manager
	
	public void createMgr()
	{
		Manager m = new Manager();
		
		
		System.out.println("Enter Bank Id to add manager : ");
		int n = s.nextInt();
		
		Bank b = dao.findBank(n);
		
		System.out.println("Enter Manager Name");
		m.setM_name(s.nextLine());
		
		System.out.println("Enter Manager City : ");
		m.setM_city(s.nextLine());
		
		System.out.println("Enter Manager Contact : ");
		m.setM_contact(s.nextLong());
		
		m.setBank(b);
		
		if(dao.saveMgr(m)!=null)
		{
			System.out.println("Manager Created");
		}
		else
		{
			System.out.println("Manager creation process Failed");
		}
		
	}
			
	public void findMgr()
	{
		System.out.println("Enter Manager Id to find");
		int id = s.nextInt();
		
		Manager m = dao.findMgr(id);
		
		if(m!=null)
		{
			System.out.println(m.getM_id());
			System.out.println(m.getM_name());
			System.out.println(m.getM_city());
			System.out.println(m.getM_contact());
		}
		else
		{
			System.out.println("Finding Manger Id is Failed");
		}
	}
		
	public void listOfMgr()
	{
		List<Manager> mgrlist = dao.listOfMgr();
		for (Manager m : mgrlist) {
			System.out.println(m.getM_id());
			System.out.println(m.getM_name());
			System.out.println();
			
		}
	}
	
	public void updateMgr()
	{
		
		List<Manager> listofMgr = dao.listOfMgr();
		for (Manager m : listofMgr) {
			
			System.out.println(m.getM_id());
			System.out.println(m.getM_name());
			System.out.println(m.getM_city());
			System.out.println(m.getM_contact());
			System.out.println(m.getBank());
			
			System.out.println("Enter the id want to update Manager");
			int id = s.nextInt();
			
			Manager mg = dao.findMgr(id);
			System.out.println("Choose the options");
			System.out.println("choose 1 to update Manager Name");
			System.out.println("choose 2 to update Manager city");
			System.out.println("Choose 3 to update Manager contact ");
			
			int val = s.nextInt();
			switch(val)
			{
			case 1 :
			{
				System.out.println("Enter New Manager Name ");
				m.setM_name(s.nextLine());
				
				Manager mng = dao.updateMgr(m);
				if(mng!=null)
				{
					System.out.println("Name updated");
				}
				else
				{
					System.out.println("updating name is failed");
				}
			}
			case 2 :
			{
				System.out.println("Enter New Manager city");
				m.setM_city(s.nextLine());
				
				Manager mng = dao.updateMgr(m);
				if(mng!=null)
				{
					System.out.println("City updated ");
				}
				else
				{
					System.out.println("updating city failed");
				}
			}
			case 3 :
			{
				System.out.println("Enter New Manger Contact ");
				m.setM_contact(s.nextLong());
				
				Manager mgr = dao.updateMgr(m);
				if(mgr!=null)
				{
					System.out.println("Contact updated");
				}
				else
				{
					System.out.println("updating contact failed");
				}
			}
		
				
			}
			
			
		}
		
		
	}
	
	public void deleteMgr()
	{
		System.out.println("Enter Id to delete Manager");
		int id = s.nextInt();
		
		Manager m = dao.findMgr(id);
		if(m!=null)
		{
			Bank b = m.getBank();
			b.setMgr(null);
			dao.updateBank(b);
			
			dao.deleteBank(id);
			System.out.println("Manager is deleted");
				
		}
		else
		{
			System.out.println("Deleting Manager process is failed");
		}
	}
	
	
	// customer
	
	public void SaveCustomer()
	{
		List<Bank> allBank =dao.listOFBank();
		for(Bank b:allBank)
		{
		System.out.println(b.getId()+" "+b.getBname());	
		}
		
		System.out.println(" Enter Bank id to which want to add customer:");
		int num=s.nextInt();
		
		Bank b = dao.findBank(num);
		
		Customer c= new Customer();
		
		System.out.println("Enter the customer name:");
		String cname=s.next();
		
		System.out.println("Enter the customer city:");
		String city = s.next();
		
		System.out.println("Enter the customer contact:");
		long contact=s.nextLong();
		
		c.setC_name(cname);
		c.setC_city(city);
		c.setC_contact(contact);
		c.setAcnt(null);
		b.getCustomer().add(c);
		
		Customer cus = dao.saveCustomer(c);
		
		if(cus!=null)
		{
			System.out.println("Customer inserted successfully");
			Bank bank = dao.updateBank(b);
		}
		else
		{
			System.out.println("Customer details is not inserted");
		}
	
	
	}
	
	
	
	public void listOfCustomer()
		{
			List<Customer> custList = dao.listOfCustomer();
			for (Customer c : custList) {
			System.out.println(c.getC_id());
			System.out.println(c.getC_name());
			System.out.println(c.getC_city());
			System.out.println(c.getC_contact());
		}
		}
	
	
	
	
	
	public void findCustomer()
		{
			System.out.println("Enter Customer Id  ");
			int id = s.nextInt();
			
			Customer c = dao.findCustomer(id);
			
			if(c!=null)
			{
				System.out.println(c.getC_id());
				System.out.println(c.getC_name());
				System.out.println(c.getC_city());
				System.out.println(c.getC_contact());
			}
			else
			{
				System.out.println("Finding Customer Id is failed 	");
			}
			 
		}
	
	
	
	public void updateCustomer()
		{
			List<Customer> listOfcustomer = dao.listOfCustomer();
			for (Customer c : listOfcustomer) {
			System.out.println(c.getC_id());
			System.out.println(c.getC_name());
			System.out.println(c.getC_city());
			System.out.println(c.getC_contact());
			
			System.out.println("Enter the ID you want to update customer");
			int id = s.nextInt() ;
			
			Customer cst = dao.findCustomer(id);
			System.out.println("Choose the options");
			System.out.println("choose 1 to update Customer Name");
			System.out.println("choose 2 to update Customer city");
			System.out.println("Choose 3 to update Customer contact ");
			
			
			int val = s.nextInt();
			switch(val)
			{
			case 1 :
			{
				System.out.println("Enter New Customer name ");
				cst.setC_name(s.nextLine());
				
				Customer cus = dao.updateCustomer(cst);
				if(cus!=null)
				{
					System.out.println("Customer name updated");
				}
				else
				{
					System.out.println("updating customer name failed");
				}
				
			}
			
			case 2 :
			{
				System.out.println("Enter Customer New City");
				cst.setC_city(s.nextLine());
				
				Customer cus = dao.updateCustomer(cst);
				if(cus!=null)
				{
					System.out.println("Customer City updated");
				}
				else
				{
					System.out.println("updating Customer city failed");
				}
				
			}
			case 3 :
			{
				System.out.println("Enter Customer New Contact ");
				cst.setC_contact(s.nextLong());
				
				Customer css = dao.updateCustomer(cst);
				if(css!=null)
				{
					System.out.println("Customer Contact Updated");
				}
				else
				{
					System.out.println("updating Customer Contact failed");
				}
			}
			
		
			
			}	
			
		}
		}	
	
	
	
	public void deleteCustomer()
	{
		List<Bank> bank = dao.listOFBank();
		
		for(Bank b:bank)
		{
			 System.out.println("id"+" "+"name"+"   "+"ifsc"+"     "+"Contact");
				System.out.println(b.getId()+" "+b.getBname()+" "+b.getIfsc()+" "+b.getContact());
		}
		
		System.out.println("enter the bank id from where you want to delete a Customer");
		int id = s.nextInt();
		Bank b = dao.findBank(id);
		
		for(Customer c:b.getCustomer())
		{
			System.out.println(c.getC_id() ) ;
			System.out.println(c.getC_name());
			System.out.println(c.getC_contact());
		
		}
		
        System.out.println(" enter which Customer ID you want to delete");
		int id2 = s.nextInt();
		
		Customer c = dao.findCustomer(id2);
		
		if(c!=null)
		{
			b.getCustomer().remove(c);
			dao.updateBank(b);
			
			dao.deleteCustomer(id2);
			System.out.println("Deleted Successfully");
		}
		else
		{
			System.out.println("not deleted give valid input");
		}
		
	}
	
//	Account
	public Customer verifyAccount() 
	{
		System.out.println("For verification:");
		System.out.println("Enter your name:");
		String name =s.next();
		System.out.println("Enter your Contact");
		long contact=s.nextLong();
		Customer c= dao.verifyAccount(name, contact);
		if(c!=null)
		{
			System.out.println("you verified");
		}
		else 
		{
			System.out.println("given data is wrong you not verified");
		}
		
		return c;
		
	}
	
	
	public void createAccount()
	{
		Customer c = verifyAccount();
		
		Account a = new Account();
		
		System.out.println("Enter the Account type:");
		String type=s.next();
		
		System.out.println("Enter the Account number:");
		int num=s.nextInt();
		
		System.out.println("Enter the Account Balance:");
		double balance=s.nextDouble();	
		
		a.setA_type(type);
		a.setA_number(num);
		a.setA_balance(balance);
		a.setCustomer(c);
		a.setTranaction(null);
		c.setAcnt(a);
		Account ac=dao.saveAccount(a);
		
		if(ac!=null)
		{
			System.out.println("Account is created succssfully");
		}
		else
		{
			System.out.println("Account is not created");
		}
		
	}
	
	
	
	public void listOfAccount()
		{
			List<Account> acntList = dao.listOfAccount();
			for (Account a : acntList) {
			System.out.println(a.getA_id());
			System.out.println(a.getA_type());
			System.out.println(a.getA_balance());
			System.out.println(a.getA_number());
			//System.out.println(a.getA);
		}
		}
	
	public void findAccountById()
	{
		System.out.println("Enter the Account id to find account:");
		int id = s.nextInt();
		
		Account a = dao.findAccount(id);
		
		if(a!=null)
		{
			System.out.println(a.getA_id()+" "+a.getA_number()+" "+a.getA_type()+" "+a.getA_balance()+" "+a.getCustomer().getC_name());
		}
		else
		{
			System.out.println("You entered invalid Account try again");
		}
	}
	
	
	public void updateAccount()
	{
		List<Account> li =dao.listOfAccount();
		for(Account a:li)
		{
			System.out.println(a.getA_id()+" "+a.getA_number()+" "+a.getA_type()+" "+a.getA_balance()+" "+a.getCustomer().getC_name());
		}
		
		System.out.println("Enter which account id you want update:");
		int id=s.nextInt();
		
		Account a = dao.findAccount(id);
		
		System.out.println("Choose your option:");
		System.out.println("Enter 1 to update Account type");
		System.out.println("Enter 2 to update Account Balance:");
		
		int option =s.nextInt();
		
		switch(option)
		{
		case 1:
		{
			System.out.println("Enter new Account type:" );
			a.setA_type(s.next());
			
			Account acc=dao.updateAccount(a);
			
			if(acc!=null)
			{
				System.out.println("new account type is updated");
			}
			else
			{
				System.out.println("updation is unsuccessful");
			}
			
			break;
		}
		case 2:
		{
			System.out.println("Enter new Account Balance:" );
			a.setA_balance(s.nextDouble());
			
			Account acc=dao.updateAccount(a);
			
			if(acc!=null)
			{
				System.out.println("new account Balance is updated");
			}
			else
			{
				System.out.println("updation is unsuccessful");
			}
			break;
			
		}
		default :
		{
			System.out.println("Enter correct option");
			break;
		}
		}
		
		
	}
	
	public void deleteAccount()
	{
		System.out.println("Enter the which Account id to delete :");
		int id=s.nextInt();
		
		Account a=dao.findAccount(id);
		
		if(a!=null) {
		Customer c=a.getCustomer();
		c.setAcnt(null);
		dao.updateCustomer(c);
		
		dao.deleteAccount(id);
		System.out.println("Account deleted");
		}
		else
		{
			System.out.println("given id is invalid");
		}
	}
	
	
	
	
	
	
//  Transaction	
	
		public void saveTransaction()
		{
			System.out.println("Enter your Account Id for transaction:");
			int n=s.nextInt();
			Account a= dao.findAccount(n);
			
			if(a!=null)
			{
			Tranaction t = new Tranaction();
			System.out.println("Enter your option:");
			System.out.println("Enter 1 to check Balance");
			System.out.println("Enter 2 for deposit");
			System.out.println("Enter 3 for withdraw");
			System.out.println("Enter 4 for Transfer money to your friends");
			System.out.println("Enter 5 to get bank statement");
			
			int option = s.nextInt();
			
			switch(option)
			{
			case 1:
			{
				System.out.println("Your Balance amount is"+a.getA_balance());
				break;
			}
			case 2:
			{
				System.out.println("Enter deposit amount");
				double amount=s.nextDouble();
				
				double newbalance = a.getA_balance()+amount;
				a.setA_balance(newbalance);
				
				t.setT_type("deposit");
				t.setT_amount(amount);
				t.setAcntid(a.getA_id());
				t.setT_status(null);
				a.getTranaction().add(t);
				Transaction t1=(Transaction) dao.saveTranaction(t);
				Account a1= dao.updateAccount(a);
				
				if((t1!=null) && (a1!=null))
				{
				System.out.println("your Transaction is successfully completed");	
				}
				else
				{
					System.out.println("your Transaction is failed");
				}
				break;
			}
			
			case 3:
			{
				System.out.println("Enter withdrawal amount");
				double amount=s.nextDouble();
				
				double newbalance = a.getA_balance()-amount;
				a.setA_balance(newbalance);
				
				t.setT_type("withdraw");
				t.setT_amount(amount);
				t.setAcntid(a.getA_id());
				t.setT_status(null);
				a.getTranaction().add(t);
				Transaction t1=(Transaction) dao.saveTranaction(t);
				Account a1= dao.updateAccount(a);
				
				if((t1!=null) && (a1!=null))
				{
				System.out.println("your Transaction is successfully completed");	
				}
				else
				{
					System.out.println("your Transaction is failed");
				}
				break;
			}
			case 4:
			{
				System.out.println("Enter Contact number to transfer money:");
				Customer c=dao.findContact(s.nextLong());
			
		    Account a1 =c.getAcnt();
		    
		    System.out.println("Enter amount to send money");
		    double money=s.nextDouble();
		    
		    double send=a.getA_balance()-money;
		    a.setA_balance(send);
		    
		    double reciever=a1.getA_balance()+money;
		    a1.setA_balance(reciever);
		    
		    t.setT_type("upi payment");
		    t.setT_status(null);
		    t.setT_id(a.getA_id());
		    t.setT_amount(money);
		    a.getTranaction().add(t);
		    
		    Account acc=dao.updateAccount(a);
		    Account acc2=dao.updateAccount(a1);
		    Transaction tr=(Transaction) dao.saveTranaction(t);
		    if(acc!=null && acc2!=null && tr!=null)
		    {
		    	System.out.println("Money transferred successfully");
		    }
		    else
		    {
		    	System.out.println("your transaction is failed");
		    }
		    break;		    
		}
		case 5:
		{
			List<Tranaction> z = a.getTranaction();
			for(Tranaction li:z)
			{
				System.out.println( li.getT_id()+" "+li.getT_type()+" "+li.getT_amount()+" "+li.getT_status());
			}
			
		}
		}
		
		}
		else
		{
			System.out.println("Enter valid account id...!");
		}
		
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
