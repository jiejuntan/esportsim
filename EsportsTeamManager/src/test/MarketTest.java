package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.exceptions.IllegalFundsException;
import main.exceptions.InventoryLimitException;
import main.exceptions.TeamLimitException;
import main.model.Athlete;
import main.model.GameData;
import main.model.Item;
import main.model.Market;
import main.model.Team.Role;

/**
 * Junit tests for Market
 * 
 * @author blake
 *
 */
public class MarketTest {
    /**
     * Market Object
     */
    private Market market;
    
    /**
     * GameData Object
     */
    private GameData data;
    
    /**
     * Athlete object
     */
    private Athlete athlete;
    
    /**
     * Item Object
     */
    private Item item;

    /**
     * Setup for market tests 
     */
    @Before
    public void setUp() {
        data = new GameData();
        market = new Market(data);
        athlete = new Athlete(data.getCurrentWeek());
        item = new Item();
    }

    /**
     * Tests for purchasing an athlete
     */
    @Test
    public void testPurchaseAthlete() throws IllegalFundsException, TeamLimitException {
        data.incrementMoney(1000);
        athlete.calculatePurchasePrice(data.getDifficulty().modifier);
        market.purchaseAthlete(athlete, Role.OFFENSE, "New Athlete");
        assertTrue(market.isPurchased(athlete));
    }

    /**
     * Tests for selling an athlete
     */
    @Test
    public void testSellAthlete() {
        athlete.calculateSalePrice(data.getDifficulty().modifier);
        market.sellAthlete(athlete);
        assertFalse(market.isPurchased(athlete));
    }

    /**
     * Tests purchasing an athlete
     */
    @Test
    public void testPurchaseItem() throws IllegalFundsException, InventoryLimitException {
    	data.incrementMoney(1000);
        item.calculatePurchasePrice(data.getDifficulty().modifier);
        market.purchaseItem(item);
        assertTrue(market.isPurchased(item));
    }


    /**
     * Tests for selling an item
     */
    @Test
    public void testSellItem() {
        item.calculateSalePrice(data.getDifficulty().modifier);
        market.sellItem(item);
        assertFalse(market.isPurchased(item));
    }
    

}
