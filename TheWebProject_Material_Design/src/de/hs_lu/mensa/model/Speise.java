package de.hs_lu.mensa.model;

public class Speise {
	String name;
	String typ;
	int anzahl_sterne;
	String emoticon;
	
	public Speise(String name, String typ) {
		super();
		this.name = name;
		this.typ = typ;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Speise [name=");
		builder.append(name);
		builder.append(", typ=");
		builder.append(typ);
		builder.append(", anzahl_sterne=");
		builder.append(anzahl_sterne);
		builder.append(", emoticon=");
		builder.append(emoticon);
		builder.append("]");
		return builder.toString();
	}
	
	
}
