package com.whatsapp.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.whatsapp.entity.WhatsappUser;
import com.whatsapp.service.WhatsappService;
import com.whatsapp.service.WhatsappServiceInterface;

//if a class will use interface then it is must to write body for all abstract method of interface inside the class
public class WhatsappController implements WhatsappControllerInterface {

	@Override
	public void createProfileController()throws Exception {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter Password");
		String password=sc.next();
		
		System.out.println("enter Email");
		String email=sc.next();
		
		System.out.println("enter Address");
		String address=sc.next();

		//the above data we should transfer to service layer in form of object according to DTO(data transfer object)
		//object of which class?
		//entity class i.e. WhatsappUser
		
		WhatsappUser wu=new WhatsappUser();
		wu.setName(name);
		wu.setPassword(password);
		wu.setEmail(email);
		wu.setAddress(address);
		
		WhatsappServiceInterface ws=new WhatsappService();
		
		int i=ws.createProfileService(wu);
		if(i>0) {
			System.out.println("Profile created");
		}
		else {
			System.out.println("could not create profile");
		}
	}

	@Override
	public void viewProfile() throws Exception {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter Email to view profile");
		String email=sc.next();
		
		WhatsappUser wu=new WhatsappUser();
		wu.setEmail(email);
		
		WhatsappServiceInterface ws=new WhatsappService();
		WhatsappUser uprofile= ws.viewProfileService(wu);
		
		if(uprofile != null) {
			System.out.println("profile is ");
			System.out.println("Name is "+uprofile.getName());
			System.out.println("Password is "+uprofile.getPassword());
			System.out.println("Email is "+uprofile.getEmail());
			System.out.println("Address is "+uprofile.getAddress());
		}
		else {
			System.out.println("profile not found");
		}
		
	}

	@Override
	public void viewAllProfileController() throws Exception {
		/*
		int i[]=new int[10];
		drawback with array is fixed size means we can not resize array based on scenario means static array
		//but our requirement is to create dynamic array
		 * how to create dynamic array
		 * ArrayList
		
		*/
		
		WhatsappServiceInterface ws=new WhatsappService();
		ArrayList<WhatsappUser> allprofile= ws.viewAllProfileService();
		
		if(allprofile.size()>0) {
			for(WhatsappUser uprofile: allprofile) {
				System.out.println("***********************************");
				System.out.println("Name is "+uprofile.getName());
				System.out.println("Password is "+uprofile.getPassword());
				System.out.println("Email is "+uprofile.getEmail());
				System.out.println("Address is "+uprofile.getAddress());
			}
		}
		else {
			System.out.println("no profile found");
		}
		
	}

}













