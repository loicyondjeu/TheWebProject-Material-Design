package de.hs_lu.mensa.helpers;

public abstract class Denullyfier {
	
	public static String denullify(String todenullify){
		todenullify = (todenullify == null) ? "":todenullify;
		return todenullify;
	}

}
