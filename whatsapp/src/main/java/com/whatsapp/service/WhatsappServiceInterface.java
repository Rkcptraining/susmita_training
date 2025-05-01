package com.whatsapp.service;

import java.util.ArrayList;

import com.whatsapp.entity.WhatsappUser;

public interface WhatsappServiceInterface {

	int createProfileService(WhatsappUser wu);

	WhatsappUser viewProfileService(WhatsappUser wu);

	ArrayList<WhatsappUser> viewAllProfileService();

	int deleteProfileService(WhatsappUser wu);

	ArrayList<WhatsappUser> searchProfileService(WhatsappUser wu);

	int editProfileService(WhatsappUser wu);

}
