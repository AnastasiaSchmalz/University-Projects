import java.util.ArrayList;

public class Diaetplan {

    String name;
    ArrayList<TagesplanErnaehrung> tagesplaene = new ArrayList<TagesplanErnaehrung>();

    //Konstruktor
    public Diaetplan(String name) {
        this.name = name;
    }
    
    //getter und setter
    	public String getName() {
        return name;
    }
    public ArrayList<TagesplanErnaehrung> getTagesplan() throws Exception {
    	if(tagesplaene.size() != 0) {
    		return this.tagesplaene;    		
    	}
    	else {
    		throw new Exception("Der Diätplan muss mindestens einen Tagesplan besitzen");
    	}
    }
    
    public void setName(String newName) {
        this.name = newName;
    }

    //Funktionen
    public void tagesplanAnlegen(String datum, TagesplanErnaehrung plan) {
    	plan.setDatum(datum);
        tagesplaene.add(plan);
    }

    //wegen der Komposition: TagesplanErnaehrung ist vollständiger Teil dieser Klasse
    public class TagesplanErnaehrung extends Tagesplan{
    	
    	int kalorienZiel;
    	
    	//weitere innere Klasse (innere Klasse der Klasse TagesplanErnaehrung)
    	public class GeplanteMahlzeit extends Mahlzeit {

    	    public EingenommeneMahlzeit eingenommeneMahlzeit;

    	    //Konstruktor
    	    public GeplanteMahlzeit(ArrayList<Lebensmittel> lebensmittel, String uhrzeit) {
    	        this.listeLebensmittel = lebensmittel;
    	        this.uhrzeit = uhrzeit;
    	    }

    	    //getter und setter
    	    public EingenommeneMahlzeit getEingenommeneMahlzeit() {
    	        return this.eingenommeneMahlzeit;
    	    }

    	    public void setEingenommeneMahlzeit(EingenommeneMahlzeit neueMahlzeit) throws Exception {
    	        if(this.eingenommeneMahlzeit == null) {
    	        this.eingenommeneMahlzeit = neueMahlzeit;
    	        }
    	        else {
    	        	throw new Exception("Diese Mahlzeit wurde schon mal zu sich genommen");
    	        }
    	    }
    	}
    	public class EingenommeneMahlzeit extends Mahlzeit {

    	    public Diaetplan.TagesplanErnaehrung geplanteMahlzeit;

    	    //Konstruktor
    	    public EingenommeneMahlzeit(ArrayList<Lebensmittel> lebensmittel, String uhrzeit) {
    	        this.listeLebensmittel = lebensmittel;        
    	        this.uhrzeit = uhrzeit;
    	    }
    	    //getter und setter
    	    public Diaetplan.TagesplanErnaehrung getGeplanteMahlzeit() {
    	        return this.geplanteMahlzeit;
    	    }

    	    public void setGeplanteMahlzeit(Diaetplan.TagesplanErnaehrung neueMahlzeit) throws Exception {
    	        if(this.geplanteMahlzeit == null) {
    	        this.geplanteMahlzeit = neueMahlzeit;
    	        }
    	        else {
    	            throw new Exception("Es gibt schon eine geplante Mahlzeit dazu");
    	        }
    	    }

    	    //Funktionen
    	    public String zwischenberichtErstellen() {
    	        String zwischenbericht = "Kalorien:" + this.getKalorien() + ", Eiweiß: " + this.getEiweiß() + ", Fett: " + this.getFett() + ", Kohlenhydrate: " + this.getKohlenhydrate();
    	        return zwischenbericht;
    	    }
    	    public String nochErlaubteKalorien(Diaetplan.TagesplanErnaehrung plan) {
    	    	int nochErlaubteKalorien = plan.getKalorienZiel() - this.getKalorien();
    	    	return  "Es bleiben noch: " + nochErlaubteKalorien + " für die restlichen Mahlzeiten.";
    	    }
    	}
    	
    	
    	//Instanzvariable TagesplanErnaehrung
    	ArrayList<GeplanteMahlzeit> geplanteMahlzeiten = new ArrayList<GeplanteMahlzeit>();
    	ArrayList<EingenommeneMahlzeit> eingenommeneMahlzeiten = new ArrayList<EingenommeneMahlzeit>();

    	// Konstruktor der inneren Klasse TagesplanErnaehrung
    	public TagesplanErnaehrung(String datum) {
    		this.datum = datum;
    	}

    	//getter (setter für die Mahlzeiten wird schon mit der Funktion "mahlzeitHinzufuegen" realisiert)
    	public GeplanteMahlzeit getMahlzeit() {
    		GeplanteMahlzeit mahlzeit = null;
    		for(int i=0; i< geplanteMahlzeiten.size(); i++) {
    			mahlzeit = geplanteMahlzeiten.get(i);
    		}
    		return mahlzeit;
    	}

    	//Funktion der inneren Klasse
        public int getKalorienZiel() { //das für den bestimmten Tag festgelegte Kalorien-Ziel
        	return this.kalorienZiel;
        }
        public void setKalorienZiel(int neuesZiel) {
        	this.kalorienZiel = neuesZiel;
        }
        
    	public String geplanteMahlzeitHinzufuegen(GeplanteMahlzeit neueMahlzeit) throws Exception{
    		if(geplanteMahlzeiten.size() < 5) {
    			geplanteMahlzeiten.add(neueMahlzeit);
    		}
        	else {
            	throw new Exception("Es können maximal 5 Mahlzeiten hinzugefügt werden");
        	}
    		if(neueMahlzeit.getKalorien() > 3000) {
    			throw new Exception("Die Mahlzeit hat mehr als 3000 Kalorien, sie kann nicht hinzugefügt werden.");
    		}
    	    int nochErlaubteKalorien = this.getKalorienZiel() - neueMahlzeit.getKalorien();
    		return "Es bleiben noch: " + nochErlaubteKalorien + "für die restlichen Mahlzeiten";
    	}
    	public void eingenommeneMahlzeitEintragen(EingenommeneMahlzeit mahlzeit) {
        	
        }
    }
}