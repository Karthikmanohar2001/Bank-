package com.Bank.project.Controller;

import java.util.Scanner;

import com.Bank.project.DAO.Controller;

public class Driver {
	
	public static void main(String args[])
	{
		boolean val = true ;
		
		while(val)
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Choose 1 to create bank");
			System.out.println("Choose 2 to find Account");
			
			System.out.println("plz select the options given above :");
			
			int op = sc.nextInt();
			
			Controller c = new Controller();
			
			switch(op)
			{
			case 1:
				c.createBank();
				break ;
//			case 2:
//				c.findId();
//				break ;
			}
			
		}
	}

}
