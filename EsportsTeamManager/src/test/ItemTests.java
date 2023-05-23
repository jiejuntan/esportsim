package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Junit class for testing Item Class
 * 
 * @author blake
 *
 */
public class ItemTests {

    /**
     * Item  Object
     */
    private Item item;

    /**
     * Setup for tests 
     */
    @BeforeEach
    public void setUp() {
        item = new Item();
    }

    /**
     * Tests to see if equipment is randomly generated
     */
    @Test
    public void testEquipmentIsRandomlyGenerated() {
        Item otherItem = new Item();
        int sameItems = 0;
        for (int i = 0; i < 100; i++) {
            if (item.getItem().equals(otherItem.getItem())) {
                sameItems++;
            }
            otherItem = new Item();
        }

        assert(sameItems < 100);
    }


    /**
     * Tests for getting base price
     */
    @Test
    public void testGetBasePrice() {
        int basePrice = item.getBasePrice();
        // As all the item items have a value of 1, their base price will be 1 * 50 = 50
        assertEquals(50, basePrice);
    }

    /**
     * Tests for getting equipment
     */
    @Test
    public void testGetEquipment() {
        Item.TrainingItem currentItem = item.getItem();
        assertNotNull(currentItem);
    }


}
