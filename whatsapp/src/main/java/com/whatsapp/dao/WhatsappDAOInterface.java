package com.whatsapp.dao;

import java.util.ArrayList;

import com.whatsapp.entity.WhatsappUser;

public interface WhatsappDAOInterface {

	int createProfileDAO(WhatsappUser wu)throws Exception;

	WhatsappUser viewProfileDAO(WhatsappUser wu)throws Exception;

	ArrayList<WhatsappUser> viewAllProfileDAO()throws Exception;

}
