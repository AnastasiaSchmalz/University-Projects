import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDiaetplan {
	
	//Tests der Konstruktoren
	
	@Test
	public void testKonstruktorDiaetplan() {
		Diaetplan diaet = new Diaetplan("Diaet");
		Assert.assertEquals("Fehler im Konstruktor 1. Parameter", diaet.getName(), "Diaet");
	}
	@Test
	public void testKonstruktorTagesplanErnaehrung() {
		Diaetplan diaet = new Diaetplan("Diaet");
		Diaetplan.TagesplanErnaehrung plan = diaet.new TagesplanErnaehrung("22.10.2010");
		Assert.assertEquals("Fehler im Konstruktor 1. Paramenter", plan.getDatum(), "22.10.2010");
	}
	@Test
	public void testKonstruktorGeplanteMahlzeit() {
		Diaetplan diaet = new Diaetplan("Diaet");
		Diaetplan.TagesplanErnaehrung plan = diaet.new TagesplanErnaehrung("22.10.2010");
		Diaetplan.TagesplanErnaehrung.GeplanteMahlzeit mahlzeit = plan.new GeplanteMahlzeit(null, "10:30");
		Assert.assertEquals("Fehler im Konstruktor 2. Parameter", mahlzeit.getZeit(), "10:30");
	}
	@Test
	public void testKonstruktorEingenommeneMahlzeit() throws Exception {
		
	    Lebensmittel banane = new Lebensmittel(95, 1.1, 0.5, 21);
	    ArrayList<Lebensmittel> liste = new ArrayList<Lebensmittel>();
	    liste.add(banane);
		
		Diaetplan diaet = new Diaetplan("Diaet");
		Diaetplan.TagesplanErnaehrung plan = diaet.new TagesplanErnaehrung("22.10.2010");
		Diaetplan.TagesplanErnaehrung.EingenommeneMahlzeit mahlzeit = plan.new EingenommeneMahlzeit(liste, "10:30");
		Assert.assertEquals("Fehler im Konstruktor 1. Parameter", mahlzeit.getLebensmittel(), liste);
		Assert.assertEquals("Fehler im Konstruktor 2. Parameter", mahlzeit.getZeit(), "10:30");
	}
	
	//Tests der Exceptions
	
	@Test
	public void testGetTagesplan() throws Exception {
		Diaetplan diaet = new Diaetplan("Diaet");
		try {
		diaet.getTagesplan();
		Assert.fail("Die Exception zur Mindestanzahl an Tagesplänen trat nicht ein");
		}
		catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	@Test
	public void testUhrzeitMahlzeit() {
		Diaetplan diaet = new Diaetplan("Diaet");
		Diaetplan.TagesplanErnaehrung plan = diaet.new TagesplanErnaehrung("22.10.2010");
		Diaetplan.TagesplanErnaehrung.GeplanteMahlzeit mahlzeit = plan.new GeplanteMahlzeit(null, "10:30");
		try {
			mahlzeit.setZeit("04:30");
			Assert.fail("Die Exception zur Uhrzeit der Mahlzeit trat nicht ein");
		}
		catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	@Test
	public void testMahlzeitHinzufuegen() {
		Lebensmittel butter = new Lebensmittel(717, 0, 0, 0);
		ArrayList<Lebensmittel> listeLebensmittel = new ArrayList<Lebensmittel>();
		
		Diaetplan diaet = new Diaetplan("Diaet");
		Diaetplan.TagesplanErnaehrung plan = diaet.new TagesplanErnaehrung("22.10.2010");
		Diaetplan.TagesplanErnaehrung.GeplanteMahlzeit mahlzeit = plan.new GeplanteMahlzeit(listeLebensmittel, "10:30");
		try {
			mahlzeit.lebensmittelHinzufuegen(butter, 10);
			Assert.fail("Die Exception zur maximalen Kalorienanzahl trat nicht ein");
			}
		catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
}