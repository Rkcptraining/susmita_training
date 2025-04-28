package com.whatsapp.view;

import java.util.Scanner;

import com.whatsapp.controller.WhatsappController;
import com.whatsapp.controller.WhatsappControllerInterface;

public class WhatsappView {

	public static void main(String[] args)throws Exception {
		String s="y";
		
		while(s.equals("y")) {
			
			System.out.println("***************MAIN MENU************");
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to view profile");
			System.out.println("press 3 to view all profile");
			
			System.out.println("enter your choice");
			
			Scanner sc=new Scanner(System.in);
			
			int choice=sc.nextInt();
			
			WhatsappControllerInterface wController= new WhatsappController();
			
			switch(choice) {
			case 1 :  wController.createProfileController();
				break;
			case 2 : wController.viewProfile();
				break;
			case 3 : wController.viewAllProfileController();
				break;
				default : System.out.println("wrong choice");
			}
					
			
			System.out.println("do you want to continue press y/n");
			s=sc.next();
		}

	}

}
