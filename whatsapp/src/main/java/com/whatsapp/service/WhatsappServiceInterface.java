package com.whatsapp.service;

import java.util.ArrayList;

import com.whatsapp.entity.WhatsappUser;

public interface WhatsappServiceInterface {

	int createProfileService(WhatsappUser wu)throws Exception;

	WhatsappUser viewProfileService(WhatsappUser wu)throws Exception;

	ArrayList<WhatsappUser> viewAllProfileService()throws Exception;

}
