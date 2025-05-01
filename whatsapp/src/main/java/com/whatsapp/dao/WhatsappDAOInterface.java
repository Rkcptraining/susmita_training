package com.whatsapp.dao;

import java.util.ArrayList;

import com.whatsapp.entity.WhatsappUser;

public interface WhatsappDAOInterface {

	int createProfileDAO(WhatsappUser wu);

	WhatsappUser viewProfileDAO(WhatsappUser wu);

	ArrayList<WhatsappUser> viewAllProfileDAO();

	int deleteProfileDAO(WhatsappUser wu);

	ArrayList<WhatsappUser> searchProfileDAO(WhatsappUser wu);

	int edithProfileDAO(WhatsappUser wu);

}
