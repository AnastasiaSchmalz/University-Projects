public abstract class Training {

    String uhrzeit;
    int dauer;
    String sportart;

    //getter und setter
    public String getZeit() throws Exception {
        return uhrzeit;
    }
    public int getDauer() throws Exception{
    	return dauer;
    }
    public String getSportart() throws Exception{
        return sportart;
    }

    public void setZeit(String newZeit) {
        this.uhrzeit = newZeit;
    }
    public void setDauer(int neueDauer) throws Exception {
    	this.dauer = neueDauer;
    }
    public void setSportart(String newSport) {
        this.sportart = newSport;
    }     
}
