package de.hs_lu.mensa.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateHelper {
	
	/**
	 * Diese Methode kriegt ein Datum im Java Format und subtrahiert davon die Zeit Angabe bzw. setze sie zu 0.
	 * Dies ist hilfreich für Suchen in der Datenbank.
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateTimeRemoved(Date date) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String strDate = formatter.format(date);
		return formatter.parse(strDate);
	}
	
	
	/**
	 * Diese Methode kriegt ein Datum im Java Format, erzeugt das nächste Datum,
	 * und subtrahiert davon die Zeit Angabe bzw. setze sie zu 0.
	 * Dies ist hilfreich für Suchen in der Datenbank.
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getTomorrowTimeRemoved(Date date) throws ParseException{
		Calendar c = Calendar.getInstance(); 
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		date = c.getTime();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String strDate = formatter.format(date);
		return formatter.parse(strDate);
	}
	
	public static Date getDateFormatted(String toFormat) throws ParseException{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		
		date = formatter.parse(toFormat);
		
		return date;
	}
	
}
