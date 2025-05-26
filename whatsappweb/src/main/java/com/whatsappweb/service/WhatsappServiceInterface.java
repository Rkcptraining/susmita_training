package com.whatsappweb.service;

import com.whatsappweb.entity.WhatsappUser;

public interface WhatsappServiceInterface {

	int createProfileService(WhatsappUser wu);

	boolean loginProfileService(WhatsappUser wu);

	WhatsappUser viewProfileService(WhatsappUser wu);

	int deleteProfileService(WhatsappUser ww);

}
