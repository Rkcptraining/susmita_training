package com.whatsapp.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.whatsapp.entity.WhatsappUser;
import com.whatsapp.service.WhatsappService;
import com.whatsapp.service.WhatsappServiceInterface;

//if a class will use interface then it is must to write body for all abstract method of interface inside the class
public class WhatsappController implements WhatsappControllerInterface {

	@Override
	public void createProfileController() {
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
	public void viewProfile()  {
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
	public void viewAllProfileController()  {
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

	@Override
	public void deleteProfileController()  {
Scanner sc=new Scanner(System.in);
		
		System.out.println("enter Email to delete profile");
		String email=sc.next();
		
		WhatsappUser wu=new WhatsappUser();
		wu.setEmail(email);
		
		WhatsappServiceInterface ws=new WhatsappService();
		int result= ws.deleteProfileService(wu);
		
		if(result>0) {
			System.out.println("Profile deleted");
		}
		else {
			System.out.println("could not delete profile");
		}
		
	}

	@Override
	public void searchProfileByNameController()  {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter name to search profile");
		String name=sc.next();
		
		WhatsappUser wu=new WhatsappUser();
		wu.setName(name);
		
		WhatsappServiceInterface ws=new WhatsappService();
		ArrayList<WhatsappUser> allprofile= ws.searchProfileService(wu);
		
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

	@Override
	public void searchProfileByAddressController()  {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter address to search profile");
		String address=sc.next();
		
		WhatsappUser wu=new WhatsappUser();
		wu.setAddress(address);
		
		WhatsappServiceInterface ws=new WhatsappService();
		ArrayList<WhatsappUser> allprofile= ws.searchProfileService(wu);
		
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

	@Override
	public void editProfilePasswordController()  {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter Email to edit password");
		String email=sc.next();
		
		WhatsappUser wu=new WhatsappUser();
		wu.setEmail(email);
		
		WhatsappServiceInterface ws=new WhatsappService();
		WhatsappUser uprofile= ws.viewProfileService(wu);
		
		if(uprofile != null) {
			System.out.println("Your Old Password is "+uprofile.getPassword());
			System.out.println("Enter New Password");
			String password=sc.next();
			
			WhatsappUser wu1=new WhatsappUser();
			wu1.setPassword(password);
			wu1.setEmail(email);
			
			int i=ws.editProfileService(wu1);
			
			if(i>0) {
				System.out.println("Password edited");
			}
			
		}
		else {
			System.out.println("profile not found");
		}
		
	}

	@Override
	public void editProfileAddressController()  {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter Email to edit address");
		String email=sc.next();
		
		WhatsappUser wu=new WhatsappUser();
		wu.setEmail(email);
		
		WhatsappServiceInterface ws=new WhatsappService();
		WhatsappUser uprofile= ws.viewProfileService(wu);
		
		if(uprofile != null) {
			
			System.out.println("Your Old Address is "+uprofile.getAddress());
			
			System.out.println("Enter New Address");
			String address=sc.next();
			
			WhatsappUser wu1=new WhatsappUser();
			wu1.setAddress(address);
			wu1.setEmail(email);
			
			
			int i=ws.editProfileService(wu1);
			if(i>0) {
				System.out.println("Address edited");
			}
			
		}
		else {
			System.out.println("profile not found");
		}
		
	}

}













