package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuItemTest {
    @Test
    public void testGetType() {
        MenuItem item = new MenuItem(MenuItem.ItemType.PANINI, "Fantasia", 2);
        assertEquals(item.getType(), MenuItem.ItemType.PANINI);
    }

    @Test
    public void testGetName() {
        MenuItem item = new MenuItem(MenuItem.ItemType.FRITTI, "Arancini", 3.50);
        assertEquals(item.getName(), "Arancini");
    }

    @Test
    public void testGetPrice() {
        MenuItem item = new MenuItem(MenuItem.ItemType.BEVANDE, "Sprite", 2.50);
        assertEquals(item.getPrice(), 2.50, 0);
    }
}