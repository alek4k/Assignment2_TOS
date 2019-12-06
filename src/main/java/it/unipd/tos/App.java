////////////////////////////////////////////////////////////////////
// Alessandro Lovo 1142682
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

import java.util.List;

public class App implements TakeAwayBill
{
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double totale = 0;

        for (int i = 0; i < itemsOrdered.size(); i++) {
            totale += itemsOrdered.get(i).getPrice();
        }

        return totale;
    }
}