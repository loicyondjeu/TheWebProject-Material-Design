package de.hs_lu.mensa.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateHelper {
	
	public static Date getTodayTimeRemoved(Date date) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String strDate = formatter.format(date);
		return formatter.parse(strDate);
	}
	
	public static Date getTomorrowTimeRemoved(Date date) throws ParseException{
		Calendar c = Calendar.getInstance(); 
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		date = c.getTime();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String strDate = formatter.format(date);
		return formatter.parse(strDate);
	}
	
}
