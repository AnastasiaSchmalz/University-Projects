import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Mahlzeit {
    
    ArrayList<Lebensmittel> listeLebensmittel = new ArrayList<Lebensmittel>();   
    ArrayList<Double> listeMenge = new ArrayList<Double>();
    String uhrzeit;
    int kalorien;
    double eiweiß;
    double fett;
    double kohlenhydrate;

    //getter und setter (die Nährstoffe werden aus den Objekten der Klasse Lebensmittel in der Liste Lebensmittel abgeleitet, daher für sie keine Setter-Methoden)
    public ArrayList<Lebensmittel> getLebensmittel() throws Exception {
    	if(listeLebensmittel.size() != 0) {
    		return listeLebensmittel;    		
    	}
    	else {
    		throw new Exception("Die Mahlzeit muss aus mind. einem Lebensmittel bestehen");
    	}
    }   
    public ArrayList<Double> getListeMenge() throws Exception {
    	if(listeMenge.size() != 0) {
    		return listeMenge;    		
    	}
    	else {
    		throw new Exception("Die Liste mit den Mengenangaben darf nicht leer sein");
    	}
    }
    public String getZeit() {
        return uhrzeit;
    }

    public int getKalorien(){
        int totalKalorien = 0;
        for(int i=0; i< listeLebensmittel.size(); i++) {
            totalKalorien += listeLebensmittel.get(i).getKal() * listeMenge.get(i);
        }
        return totalKalorien;
    }
    public double getEiweiß(){
        int totalEiweiß = 0;
        for(int i=0; i< listeLebensmittel.size(); i++) {
            totalEiweiß += listeLebensmittel.get(i).getEw() * listeMenge.get(i);
        }
        return totalEiweiß;
    }
    public double getFett(){
        int totalFett = 0;
        for(int i=0; i< listeLebensmittel.size(); i++) {
            totalFett += listeLebensmittel.get(i).getFt() * listeMenge.get(i);
        }
        return totalFett;
    }
    public double getKohlenhydrate(){
        int totalKohlenhydrate = 0;
        for(int i=0; i< listeLebensmittel.size(); i++) {
            totalKohlenhydrate += listeLebensmittel.get(i).getKh() * listeMenge.get(i);
        }
        return totalKohlenhydrate;
    }


    public void setZeit(String newZeit) throws Exception {
    	LocalTime zeit = LocalTime.parse(newZeit);
    	LocalTime anfang = LocalTime.parse("05:00");
    	LocalTime ende = LocalTime.parse("23:00");
        if (!zeit.isBefore(anfang) && !zeit.isAfter(ende)) {
        	this.uhrzeit = newZeit;        	
        }
        else {
        	throw new Exception("Die Uhrzeit muss zwischen 05:00 Uhr und 23:00 Uhr liegen.");
        }
    }

    //Funktionen
    public void lebensmittelHinzufuegen(Lebensmittel newLebensmittel, double newMenge) {
        listeLebensmittel.add(newLebensmittel);
        listeMenge.add(newMenge);
    }
    public double getMenge(String lebensmittel) {
    	double menge = 0;
    	for(int i = 0; i < listeMenge.size(); i++) {
    		if (i == listeLebensmittel.indexOf(lebensmittel)) {
    			menge = listeMenge.get(i);
    		}
    	}
    	return menge;
    }
}