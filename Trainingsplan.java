import java.time.LocalDate;
import java.util.ArrayList;

public class Trainingsplan {

    String name;
    ArrayList<TagesplanTraining> tagesplaene = new ArrayList<TagesplanTraining>();

    //Konstruktor
    public Trainingsplan(String name) {
        this.name = name;
    }
    //wegen der Komposition: Die Objekte der Klasse TagesplanTraining sind nur in der Klasse Trainingsplan verfügbar
    public class TagesplanTraining extends Tagesplan{

        public ArrayList<Trainingseinheit> trainingseinheiten = new ArrayList<Trainingseinheit>();
        public ArrayList<TrainingDurchgefuehrt> trainingsDurchgefuehrt = new ArrayList<TrainingDurchgefuehrt>();

        // Konstruktor der inneren Klasse
        public TagesplanTraining(String datum) {
        	this.datum = datum;
        }
        //weitere innere Klassen wegen der Existenzabhängigkeit
        public class TrainingDurchgefuehrt extends Training {

            String datum;
            Trainingseinheit trainingseinheit;

            //Konstruktor
            public TrainingDurchgefuehrt(String zeit, int dauer, String sport, String datum) {
                uhrzeit = zeit;
                this.dauer = dauer;
                sportart = sport;
                this.datum = datum;
            }

            //getter und setter
            public String getDatum() {
                return datum;
            }
            public Trainingseinheit getTrainingseinheit() {
                return this.trainingseinheit;
            }

            public void setDatum(String newDatum) {
                this.datum = newDatum;
            }
            public void setTrainingseinheit(Trainingseinheit neueEinheit) throws Exception{
                if(this.trainingseinheit == null) {
                this.trainingseinheit = neueEinheit;
                }
                else {
                    throw new Exception("Diesem Training ist schon eine Einheit zugeordnet");   //!!!!!
                }
            }
            //Funktionen
            public String trainingAuswerten () throws Exception {
            	String trainingsAuswertung = this.getSportart() + ":" + "Du hast heute, der " + this.getDatum() + "für " + this.getDauer() + "trainiert";
            	return trainingsAuswertung;
            }

        }
        
        public class Trainingseinheit extends Training {

            TrainingDurchgefuehrt trainingDurchgefuehrt;

            //Konstruktor
            public Trainingseinheit(String zeit, String sport, int dauer) {
                uhrzeit = zeit;
                sportart = sport;
                this.dauer = dauer;
            }

            //getter und setter
            public TrainingDurchgefuehrt getTrainingsDurchgefuehrt() {
                return this.trainingDurchgefuehrt;
            }
            
            @Override
            public String getZeit() throws Exception {
            	if (this.uhrzeit != null) {
            		return uhrzeit;
            	}
            	else {
            		throw new Exception("Die Uhrzeit ist ein Pflichtfeld");
            	}
            }
            
            @Override
            public String getSportart() throws Exception {
            	if (this.sportart != null) {
            		return sportart;
            	}
            	else {
            		throw new Exception("Die Sportart ist ein Pflichtfeld");
            	}
            }
            
            @Override
            public int getDauer() throws Exception {
            	if(this.dauer == 0) {
            			throw new Exception("Die geplante Dauer ist ein Pflichtfeld");            			
            	}
            	else if(this.dauer < 0 || this.dauer > 90) {
           			throw new Exception("Die geplante Dauer muss zwischen 0 und einschließlich 90 Minuten liegen");
           	  	}
            	else {
            		return dauer;            		
            	}

            }
            
            @Override
            public void setDauer(int newDauer) throws Exception {
               if(newDauer >= 0 || newDauer <= 90) {
            	   this.dauer = newDauer;
                }
               else {
            	   throw new Exception("Dauer muss zwischen 0 und 90 Minuten sein");
                }
            }
            
            public void setTrainingDurchgefuehrt(TrainingDurchgefuehrt neuesTraining) throws Exception {
                if(this.trainingDurchgefuehrt == null){
                	this.trainingDurchgefuehrt = neuesTraining;
                }
                else {
                    throw new Exception("Zu dieser Einheit fand schon ein Training statt");
                }
            }
        }
        //getter und setter der Klasse TagesplanTraining
        public ArrayList<Trainingseinheit> getTrainingseinheiten() throws Exception {
        	if(trainingseinheiten.size() != 0) {
        		return trainingseinheiten;
        	}
        	else {
        		throw new Exception("Der Tagesplan muss mindestens eine Trainingseinheit besitzen");
        	}
        }
        public ArrayList<TrainingDurchgefuehrt> getTrainingsDurchgefuehrt() {
        	return trainingsDurchgefuehrt;
        }

        //Funktionen der Klasse TagesplanTraining
        public void einheitHinzufuegen(Trainingseinheit newTraining) {
            trainingseinheiten.add(newTraining);
        }

        public void trainingHinzufuegen(TrainingDurchgefuehrt newTraining) {
            trainingsDurchgefuehrt.add(newTraining);
        }
    }

    //getter und setter der Klasse Trainingsplan
    public String getName() {
        return name;
    }
    public ArrayList<TagesplanTraining> getTagesplan() {
    	return this.tagesplaene;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    //Funktionen der Klasse Trainingsplan
    private void tagesplanAnlegen(TagesplanTraining plan) {
        tagesplaene.add(plan);
    }

    private boolean personalTrainerBuchen() {
        boolean trainerGebucht = true;
        return trainerGebucht;
    }
}