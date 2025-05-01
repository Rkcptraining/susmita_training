package com.whatsapp.controller;

public interface WhatsappControllerInterface {
	
	//by default all the methods of an interface will be public and abstract

	void createProfileController();

	void viewProfile();

	void viewAllProfileController();

	void deleteProfileController();

	void searchProfileByNameController();

	void searchProfileByAddressController();

	void editProfilePasswordController();

	void editProfileAddressController();

}
