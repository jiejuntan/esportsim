package test;

import main.model.Club;
import main.model.GameData;
import main.model.Item;
import main.model.Athlete;
import main.exceptions.InventoryLimitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Junit tests for Club Class
 * 
 * @author blake
 *
 */
public class ClubTest {
    /**
     * Club Object
     */
    private Club club;
    
    /**
     * Item Object
     */
    private Item item;
    
    /**
     * Athlete Object
     */
    private Athlete athlete;
    
    /**
     * GameData Object
     */
    private GameData gameData;


    /**
     * Setup for the tests
     */
    @BeforeEach
    public void setUp() {
    	this.gameData = new GameData();
        club = new Club();
        item = new Item(); 
        athlete = new Athlete(gameData.getCurrentWeek()); 
    }

    /**
     * Tests the default constructor
     */
    @Test
    public void testDefaultConstructor() {
        assertTrue(club.getInventory().isEmpty());
    }

    /**
     * Tests adding of an item
     */
    @Test
    public void testAddItem() throws InventoryLimitException {
        club.addItem(item);
        assertEquals(1, club.getInventory().size());
        assertTrue(club.getInventory().contains(item));
    }

    /**
     * Tests adding item when inventory is at the limit
     */
    @Test
    public void testAddItemInventoryLimit() throws InventoryLimitException {
        for (int i = 0; i < 5; i++) {
            club.addItem(item);
        } 
        assertEquals(5, club.getInventory().size());
        assertThrows(InventoryLimitException.class, () -> club.addItem(item));
    }

    /**
     * Tests using an item on an athlete 
     */
    @Test
    public void testUseItem() throws InventoryLimitException {
    	
    	int itemPosValue = item.getItem().getPositiveValue();
    	int itemNegValue = item.getItem().getNegativeValue();
    	int athletePosValue = 0;
    	int athleteNegValue = 0;
    	
    		
    	//Find which stats will be affected for the positive and negative value of the items
    	//Records stat before item use
    	switch( item.getItem().getPositiveStat()) {
    	case Item.REACTION_TIME:
    		athletePosValue = athlete.getReactionTime();
    		break;
    	case Item.INTELLIGENCE:
    		athletePosValue = athlete.getIntelligence();
    		break;
    	case Item.EYESIGHT:
    		athletePosValue = athlete.getEyeSight();
    		break;
    	}
    	switch( item.getItem().getNegativeStat()) {
    	case Item.REACTION_TIME:
    		athleteNegValue = athlete.getReactionTime();
    		break;
    	case Item.INTELLIGENCE:
    		athleteNegValue = athlete.getIntelligence();
    		break;
    	case Item.EYESIGHT:
    		athleteNegValue = athlete.getEyeSight();
    		break;
    	}

        // Use the item on the athlete
        club.useItem(item, athlete);
        
        
        //Checks that the stats have the expected change in value
    	switch( item.getItem().getNegativeStat()) {
    	case Item.REACTION_TIME:
    		assertTrue(athleteNegValue + itemNegValue == athlete.getReactionTime());
    		break;
    	case Item.INTELLIGENCE:
    		assertTrue(athleteNegValue + itemNegValue == athlete.getIntelligence());
    		break;
    	case Item.EYESIGHT:
    		assertTrue(athleteNegValue + itemNegValue == athlete.getEyeSight());
    		break;
    	}
    	
    	switch( item.getItem().getPositiveStat()) {
    	case Item.REACTION_TIME:
    		assertTrue(athletePosValue + itemPosValue == athlete.getReactionTime());
    		break;
    	case Item.INTELLIGENCE:
    		assertTrue(athletePosValue + itemPosValue == athlete.getIntelligence());
    		break;
    	case Item.EYESIGHT:
    		assertTrue(athletePosValue + itemPosValue == athlete.getEyeSight());
    		break;
    	}
    }

}
