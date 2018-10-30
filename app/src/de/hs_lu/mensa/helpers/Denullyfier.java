package de.hs_lu.mensa.helpers;

/**
 * Der Denullyfier hilft uns Daten aus dem Request auf null zu Prüfen.
 * sollte ein getParameter null zurückgeben erzeugt der Denullyfier einen default Wert
 * entsprechend des Datentyps.
 * @author loicy
 *
 */
public abstract class Denullyfier {
	
	public static String denullifyString(String todenullify){
		todenullify = (todenullify == null) ? "" : todenullify;
		return todenullify;
	}
	
	public static double denullifyDouble(String todenullify){
		todenullify = (todenullify == null) ? "0" : todenullify;
		return Double.valueOf(todenullify);
	}
	
	public static int denullifyInteger(String todenullify){
		todenullify = (todenullify == null) ? "0" : todenullify;
		return Integer.valueOf(todenullify);
	}

}
