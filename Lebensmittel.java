public class Lebensmittel {

//die Nährwert-Angaben gelten für 100 Gramm eines Lebensmittel
int kalorien;
double eiweiß;
double fett;
double kohlenhydrate;

//; 
public Lebensmittel(int kalorien, double eiweiß, double fett, double kohlenhydrate) {
    this.kalorien = kalorien;
    this.eiweiß = eiweiß;
    this.fett = fett;
    this.kohlenhydrate = kohlenhydrate;
}

//getter und setter; Angaben gelten pro 100 Gramm
public int getKal() {
    return kalorien;
}
public double getEw() {
    return eiweiß;
}
public double getFt() {
    return fett;
}
public double getKh() {
    return kohlenhydrate;
}

public void setKalorien(int newKal) {
    this.kalorien = newKal;
}
public void setEiweiß(double newEiweiß) {
    this.eiweiß = newEiweiß;
}
public void setFett(double newFett) {
    this.fett = newFett;
}
public void setKohlenhydrate(double newKh) {
    this.kohlenhydrate = newKh;
}

}