package com.whatsapp.controller;

public interface WhatsappControllerInterface {
	
	//by default all the methods of an interface will be public and abstract

	void createProfileController()throws Exception;

	void viewProfile()throws Exception;

	void viewAllProfileController()throws Exception;

	void deleteProfileController()throws Exception;

	void searchProfileByNameController()throws Exception;

	void searchProfileByAddressController()throws Exception;

	void editProfilePasswordController()throws Exception;

	void editProfileAddressController()throws Exception;

}
