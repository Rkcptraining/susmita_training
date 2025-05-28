package com.whatsappweb.service;

import com.whatsappweb.dao.WhatsappDAO;
import com.whatsappweb.dao.WhatsappDAOInterface;
import com.whatsappweb.entity.WhatsappUser;

public class WhatsappService implements WhatsappServiceInterface {

	@Override
	public int createProfileService(WhatsappUser wu) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.createProfileDAO(wu);
	}

	@Override
	public boolean loginProfileService(WhatsappUser wu) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.loginProfileDAO(wu);
	}

	@Override
	public WhatsappUser viewProfileService(WhatsappUser wu) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.viewProfileDAO(wu);
	}

	@Override
	public int deleteProfileService(WhatsappUser ww) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.deleteProfileDAO(ww);
	}

	@Override
	public int checkEmailService(WhatsappUser ww) {
		WhatsappDAOInterface wd=new WhatsappDAO();
		return wd.checkEmailDAO(ww);
	}

}
