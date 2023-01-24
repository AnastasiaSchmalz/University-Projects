import org.junit.Assert;
import org.junit.Test;

public class TestLebensmittel {

    //Konstruktortest
    @Test
    public void testKonstruktor(){
    Lebensmittel banane = new Lebensmittel(95, 1.1, 0.5, 21);
    Assert.assertEquals(banane.getKal(),95, 0.1);
    Assert.assertEquals(banane.getEw(),1.1, 0.1);
    Assert.assertEquals(banane.getFt(),0.5, 0.1);
    Assert.assertEquals(banane.getKh(), 21.0, 0.1);
    }
}