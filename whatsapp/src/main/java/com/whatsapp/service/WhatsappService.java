package com.whatsapp.service;

import java.util.ArrayList;

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

	@Override
	public WhatsappUser viewProfileService(WhatsappUser wu) throws Exception {
		WhatsappDAOInterface wd=new WhatsappDAO();
		WhatsappUser uprofile =wd.viewProfileDAO(wu);
		return uprofile;
	}

	@Override
	public ArrayList<WhatsappUser> viewAllProfileService() throws Exception {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.viewAllProfileDAO();
	}

}
