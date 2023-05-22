package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemTests {

    private Item item;

    @BeforeEach
    public void setUp() {
        item = new Item();
    }

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
        // Although there is no guarantee that all items will be different,
        // with 100 iterations, it is very likely that some will be different.
        assert(sameItems < 100);
    }

    @Test
    public void testGetBasePrice() {
        int basePrice = item.getBasePrice();
        // As all the item items have a value of 1, their base price will be 1 * 50 = 50
        assertEquals(50, basePrice);
    }

    @Test
    public void testGetEquipment() {
        Item.TrainingItem currentItem = item.getItem();
        assertNotNull(currentItem);
    }

    @Test
    public void testTrainingItemEnum() {
        Item.TrainingItem[] trainingItems = Item.TrainingItem.values();
        assertEquals(5, trainingItems.length);

        for (Item.TrainingItem item : trainingItems) {
            assertNotNull(item.getPositiveValue());
            assertNotNull(item.getPositiveStat());
        }
    }
}
