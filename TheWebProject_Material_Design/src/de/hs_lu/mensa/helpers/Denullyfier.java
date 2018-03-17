package de.hs_lu.mensa.helpers;

public abstract class Denullyfier {
	
	public static String denullifyString(String todenullify){
		todenullify = (todenullify == null) ? "":todenullify;
		return todenullify;
	}
	
	public static double denullifyNumber(String todenullify){
		todenullify = (todenullify == null) ? "0" : todenullify;
		return Double.valueOf(todenullify);
	}

}
