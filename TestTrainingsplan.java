import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestTrainingsplan {

	
    //Konstruktortest
    @Test
    public void testKonstruktorTrainingsplan(){
    	Trainingsplan t = new Trainingsplan("Trainingsplan");
    	Assert.assertEquals("Fehler im Konstruktor 1. Parameter",t.getName(),"Trainingsplan");
    }
    
    @Test
    public void testKonstruktorTagesplanTraining() throws Exception {
    	
    	Trainingsplan t = new Trainingsplan("Trainingsplan");
    	Trainingsplan.TagesplanTraining tag = t.new TagesplanTraining("12.12.2022");
    	Assert.assertEquals("Fehler im Konstruktor 1. Parameter",tag.getDatum(), "12.12.2022");
    	
    }
    
    @Test
    public void testKonstruktorTrainingseinheit() throws Exception {
    	Trainingsplan t = new Trainingsplan("Trainingsplan");
    	Trainingsplan.TagesplanTraining tag = t.new TagesplanTraining("12.12.2022");
    	Trainingsplan.TagesplanTraining.Trainingseinheit einheit = tag.new Trainingseinheit("15:20", "Laufen", 60);
    	Assert.assertEquals("Fehler im Konstrukor 1. Parameter",einheit.getZeit(), "15:20");
    	Assert.assertEquals("Fehler Konstruktor 2. Parameter", einheit.getSportart(), "Laufen");
    	Assert.assertEquals("Fehler Konstruktor 3. Parameter", einheit.getDauer(),60);
    }
    
    @Test
    public void testDauerTrainingseinheit() {
    	Trainingsplan t = new Trainingsplan("Trainingsplan");
    	Trainingsplan.TagesplanTraining tag = t.new TagesplanTraining("12.12.2022");
    	Trainingsplan.TagesplanTraining.Trainingseinheit einheit = tag.new Trainingseinheit("15:20", "Laufen", 110);
    	try {
    		einheit.getDauer();
    		Assert.fail("Die Exception von getDauer() trat nicht ein");
    	}
    	catch(Exception e) {
    		Assert.assertNotNull(e);
    	}
    }
    
    @Test
    public void testAttributeTrainingseinheit() {
    	Trainingsplan t = new Trainingsplan("Trainingsplan");
    	Trainingsplan.TagesplanTraining tag = t.new TagesplanTraining("12.12.2022");
    	Trainingsplan.TagesplanTraining.Trainingseinheit einheit = tag.new Trainingseinheit(null, null, 0);
    	try {
    		einheit.getZeit();
    		einheit.getSportart();
    		einheit.getDauer();
    		Assert.fail("Die Exception zu den Attributen von Trainingseinheit trat nicht ein");
    	}
    	catch(Exception e) {
    		Assert.assertNotNull(e);
    	}
    }
}