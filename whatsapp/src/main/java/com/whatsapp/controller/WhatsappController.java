package com.whatsapp.controller;

import java.util.Scanner;

import com.whatsapp.entity.WhatsappUser;
import com.whatsapp.service.WhatsappService;
import com.whatsapp.service.WhatsappServiceInterface;

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

}













