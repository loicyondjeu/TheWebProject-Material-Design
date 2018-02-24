package de.hs_lu.mensa.model;

public class Ausgabe {
	String ausgabeTyp;
	Speise suppe;
	Speise hauptspeise;
	Speise komplement;
	Speise salat;
	Speise dessert;
	
	public Ausgabe(String ausgabeTyp, Speise suppe, Speise hauptspeise, Speise komplement, Speise salat,
			Speise dessert) {
		super();
		this.ausgabeTyp = ausgabeTyp;
		this.suppe = suppe;
		this.hauptspeise = hauptspeise;
		this.komplement = komplement;
		this.salat = salat;
		this.dessert = dessert;
	}

	public String toString() {
		return String.format("Ausgabe [ausgabeTyp=%s, suppe=%s, hauptspeise=%s, komplement=%s, salat=%s, dessert=%s]",
				ausgabeTyp, suppe, hauptspeise, komplement, salat, dessert);
	}
	
	

}
