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

public class MarketTest {
    private Market market;
    private GameData data;
    private Athlete athlete;
    private Item item;

    @Before
    public void setUp() {
        data = new GameData();
        market = new Market(data);
        athlete = new Athlete(data.getCurrentWeek());
        item = new Item();
    }

    @Test
    public void testPurchaseAthlete() throws IllegalFundsException, TeamLimitException {
        data.incrementMoney(1000);
        athlete.calculatePurchasePrice(data.getDifficulty().modifier);
        market.purchaseAthlete(athlete, Role.OFFENSE, "New Athlete");
        assertTrue(market.isPurchased(athlete));
    }

    @Test
    public void testSellAthlete() {
        athlete.calculateSalePrice(data.getDifficulty().modifier);
        market.sellAthlete(athlete);
        assertFalse(market.isPurchased(athlete));
    }

    @Test
    public void testPurchaseItem() throws IllegalFundsException, InventoryLimitException {
    	data.incrementMoney(1000);
        item.calculatePurchasePrice(data.getDifficulty().modifier);
        market.purchaseItem(item);
        assertTrue(market.isPurchased(item));
    }

    @Test
    public void testSellItem() {
        item.calculateSalePrice(data.getDifficulty().modifier);
        market.sellItem(item);
        assertFalse(market.isPurchased(item));
    }
    

}
