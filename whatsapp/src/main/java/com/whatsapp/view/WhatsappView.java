package com.whatsapp.view;

import java.util.Scanner;

import com.whatsapp.controller.WhatsappController;
import com.whatsapp.controller.WhatsappControllerInterface;

public class WhatsappView {

	public static void main(String[] args)  {
		String s = "y";

		while (s.equals("y")) {

			System.out.println("***************MAIN MENU************");
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to view profile");
			System.out.println("press 3 to view all profile");

			System.out.println("press 4 to delete profile");
			System.out.println("press 5 to search profile");
			System.out.println("press 6 to edit profile");

			System.out.println("enter your choice");

			Scanner sc = new Scanner(System.in);

			int choice = sc.nextInt();

			WhatsappControllerInterface wController = new WhatsappController();

			switch (choice) {
			case 1:
				wController.createProfileController();
				break;
			case 2:
				wController.viewProfile();
				break;
			case 3:
				wController.viewAllProfileController();
				break;
			case 4:
				wController.deleteProfileController();
				break;
			case 5:
				System.out.println("press 1 to search by name");
				System.out.println("press 2 to search by address");
				System.out.println("enter your option");
				int op = sc.nextInt();

				switch (op) {
				case 1:
					wController.searchProfileByNameController();
					break;
				case 2:
					wController.searchProfileByAddressController();
					break;
				}

				break;
			case 6:
				System.out.println("press 1 to edit password");
				System.out.println("press 2 to edit address");
				System.out.println("enter your option");
				int op1 = sc.nextInt();

				switch (op1) {
				case 1:
					wController.editProfilePasswordController();
					break;
				case 2:
					wController.editProfileAddressController();
					break;
				}

				break;
			default:
				System.out.println("wrong choice");
			}

			System.out.println("do you want to continue press y/n");
			s = sc.next();
		}

	}

}
