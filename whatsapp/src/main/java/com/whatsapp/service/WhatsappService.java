package com.whatsapp.service;

import com.whatsapp.dao.WhatsappDAO;
import com.whatsapp.dao.WhatsappDAOInterface;
import com.whatsapp.entity.WhatsappUser;

public class WhatsappService implements WhatsappServiceInterface {

	@Override
	public int createProfileService(WhatsappUser wu)throws Exception {
		WhatsappDAOInterface wd=new WhatsappDAO();
		int i=wd.createProfileDAO(wu);
		return i;
	}

}
