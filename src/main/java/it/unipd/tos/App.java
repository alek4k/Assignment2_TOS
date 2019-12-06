////////////////////////////////////////////////////////////////////
// Alessandro Lovo 1142682
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.ItemType;

import java.util.List;

public class App implements TakeAwayBill
{
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double totale = 0;
        int numPanini = 0;
        double prezzoMin = -1;

        for (int i = 0; i < itemsOrdered.size(); i++) {
            // #1
            totale += itemsOrdered.get(i).getPrice();
            
            // #2
            if (itemsOrdered.get(i).getType() == ItemType.PANINI) {
                numPanini += 1;
                double prezzoCorrente = itemsOrdered.get(i).getPrice();
                if (prezzoMin == -1) {
                    prezzoMin = itemsOrdered.get(i).getPrice();
                }
                else if (prezzoMin > prezzoCorrente) {
                    prezzoMin = prezzoCorrente;
                }
            }
        }
        
        if (numPanini > 5) {
            totale -= prezzoMin;
            totale += prezzoMin * 0.5;
        }

        return totale;
    }
}