package com.whatsapp.utility;

import java.util.Comparator;

import com.whatsapp.entity.WhatsappUser;

public class SortByName implements Comparator<WhatsappUser>{

	@Override
	public int compare(WhatsappUser o1, WhatsappUser o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName()); //it will return 0 or -1 or +1
		//0 means both object are same
		//-1 means first object is greater than second
		//+1 means first object is smaller than second
	}

}
