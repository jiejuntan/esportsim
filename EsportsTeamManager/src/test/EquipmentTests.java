package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Equipment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EquipmentTests {

    private Equipment equipment;

    @BeforeEach
    public void setUp() {
        equipment = new Equipment();
    }

    @Test
    public void testEquipmentIsRandomlyGenerated() {
        Equipment otherEquipment = new Equipment();
        int sameItems = 0;
        for (int i = 0; i < 100; i++) {
            if (equipment.getEquipment().equals(otherEquipment.getEquipment())) {
                sameItems++;
            }
            otherEquipment = new Equipment();
        }
        // Although there is no guarantee that all items will be different,
        // with 100 iterations, it is very likely that some will be different.
        assert(sameItems < 100);
    }

    @Test
    public void testGetBasePrice() {
        int basePrice = equipment.getBasePrice();
        // As all the equipment items have a value of 1, their base price will be 1 * 50 = 50
        assertEquals(50, basePrice);
    }

    @Test
    public void testGetEquipment() {
        Equipment.TrainingItem currentItem = equipment.getEquipment();
        assertNotNull(currentItem);
    }

    @Test
    public void testTrainingItemEnum() {
        Equipment.TrainingItem[] trainingItems = Equipment.TrainingItem.values();
        assertEquals(5, trainingItems.length);

        for (Equipment.TrainingItem item : trainingItems) {
            assertNotNull(item.getValue());
            assertNotNull(item.getAffectedStat());
        }
    }
}
