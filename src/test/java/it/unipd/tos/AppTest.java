package it.unipd.tos;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class AppTest {
    private ArrayList<MenuItem> list;
    private App myApp;

    public AppTest() {
        myApp = new App();
    }

    @Test
    public void testScontoSuOrdineConTotalePFMinoreDi50EuroEPiuDi5Panini() throws TakeAwayBillException {
        list = new ArrayList<MenuItem>();
        for (int i = 0; i < 6; i++) {
            list.add(new MenuItem(MenuItem.ItemType.PANINI, "Fantasia", 3));
        }
        list.add(new MenuItem(MenuItem.ItemType.PANINI, "Primavera", 2));
        assertEquals(myApp.getOrderPrice(list), 19, 0);
    }

    @Test
    public void testScontoSuOrdineConTotalePFMaggioreDi50EuroEPiuDi5Panini() throws TakeAwayBillException {
        list = new ArrayList<MenuItem>();
        for (int i = 0; i < 15; i++) {
            list.add(new MenuItem(MenuItem.ItemType.PANINI, "Fantasia", 3));
        }
        list.add(new MenuItem(MenuItem.ItemType.FRITTI, "Arancini", 5));
        list.add(new MenuItem(MenuItem.ItemType.FRITTI, "Olive Ascolane", 4.50));
        assertEquals(myApp.getOrderPrice(list), 54.50 - 1.5 - 5.3, 0);
    }
    
    @Test
    public void testScontoSuOrdineConTotalePFMaggioreDi50EuroEMenoDi5Panini() throws TakeAwayBillException {
        list = new ArrayList<MenuItem>();
        for (int i = 0; i < 10; i++) {
            list.add(new MenuItem(MenuItem.ItemType.FRITTI, "Arancini", 5));
        }
        list.add(new MenuItem(MenuItem.ItemType.PANINI, "Fantasia", 3));
        assertEquals(myApp.getOrderPrice(list), 53 - 5.3, 0);
    }

    @Test
    public void testOrdineConPiuDi30Elementi() throws TakeAwayBillException {
        list = new ArrayList<MenuItem>();
        for (int i = 0; i < 40; i++) {
            list.add(new MenuItem(MenuItem.ItemType.PANINI, "Fantasia", 3));
        }
        try {
            myApp.getOrderPrice(list);
        } catch (TakeAwayBillException ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testCommissioneSuOrdineConTotaleInferioreADieciEuro() throws TakeAwayBillException {
        list = new ArrayList<MenuItem>();
        list.add(new MenuItem(MenuItem.ItemType.PANINI, "Primavera", 2));
        list.add(new MenuItem(MenuItem.ItemType.FRITTI, "Olive Ascolane", 4.50));
        list.add(new MenuItem(MenuItem.ItemType.BEVANDE, "Coca Cola", 2.50));
        assertEquals(9.50, myApp.getOrderPrice(list), 0);
    }
}
