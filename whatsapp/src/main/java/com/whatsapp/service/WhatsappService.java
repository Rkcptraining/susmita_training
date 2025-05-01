package com.whatsapp.service;

import java.util.ArrayList;

import com.whatsapp.dao.WhatsappDAO;
import com.whatsapp.dao.WhatsappDAOInterface;
import com.whatsapp.entity.WhatsappUser;

public class WhatsappService implements WhatsappServiceInterface {

	@Override
	public int createProfileService(WhatsappUser wu) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		int i=wd.createProfileDAO(wu);
		return i;
	}

	@Override
	public WhatsappUser viewProfileService(WhatsappUser wu)  {
		WhatsappDAOInterface wd=new WhatsappDAO();
		WhatsappUser uprofile =wd.viewProfileDAO(wu);
		return uprofile;
	}

	@Override
	public ArrayList<WhatsappUser> viewAllProfileService()  {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.viewAllProfileDAO();
	}

	@Override
	public int deleteProfileService(WhatsappUser wu)  {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.deleteProfileDAO(wu);
	}

	@Override
	public ArrayList<WhatsappUser> searchProfileService(WhatsappUser wu)  {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.searchProfileDAO(wu);
	}

	@Override
	public int editProfileService(WhatsappUser wu)  {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.edithProfileDAO(wu);
	}

}
