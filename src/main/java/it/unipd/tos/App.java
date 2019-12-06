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
        double totalePF = 0;
        
        if (itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("Non è consentita un'ordinazione con più di 30 elementi.");
        }

        for (int i = 0; i < itemsOrdered.size(); i++) {
            double prezzoCorrente = itemsOrdered.get(i).getPrice();

            // #1
            totale += prezzoCorrente;
            
            if (itemsOrdered.get(i).getType() == ItemType.PANINI) {
                numPanini += 1;
                if (prezzoMin == -1) {
                    prezzoMin = itemsOrdered.get(i).getPrice();
                }
                else if (prezzoMin > prezzoCorrente) {
                    prezzoMin = prezzoCorrente;
                }
                totalePF += prezzoCorrente;
            }
            else if (itemsOrdered.get(i).getType() == ItemType.FRITTI) {
                totalePF += prezzoCorrente;
            }
        }
        
        // #2
        if (numPanini > 5) {
            totale -= prezzoMin;
            totale += prezzoMin * 0.5;
        }
        
        // #3
        if (totalePF > 50) {
            totale -= totale / 10;
        }

        return totale;
    }
}