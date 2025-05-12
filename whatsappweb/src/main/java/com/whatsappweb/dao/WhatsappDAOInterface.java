package com.whatsappweb.dao;

import com.whatsappweb.entity.WhatsappUser;

public interface WhatsappDAOInterface {

	int createProfileDAO(WhatsappUser wu);

	boolean loginProfileDAO(WhatsappUser wu);

	WhatsappUser viewProfileDAO(WhatsappUser wu);

}
