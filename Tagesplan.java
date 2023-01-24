import java.time.LocalDate;

public abstract class Tagesplan {

    String datum;

    //getter und setter
    public String getDatum() {
        return datum;
    }

    public void setDatum(String newDatum) {
        this.datum = newDatum;
    }
}