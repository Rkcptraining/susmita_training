package com.whatsapp.service;

import java.util.ArrayList;

import com.whatsapp.entity.WhatsappUser;

public interface WhatsappServiceInterface {

	int createProfileService(WhatsappUser wu)throws Exception;

	WhatsappUser viewProfileService(WhatsappUser wu)throws Exception;

	ArrayList<WhatsappUser> viewAllProfileService()throws Exception;

	int deleteProfileService(WhatsappUser wu)throws Exception;

	ArrayList<WhatsappUser> searchProfileService(WhatsappUser wu)throws Exception;

	int editProfileService(WhatsappUser wu)throws Exception;

}
