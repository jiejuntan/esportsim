/**
 * 
 */
package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import main.gui.GameFrame;
import main.gui.panels.DraftPanel;
import main.model.Market;
import main.model.Team;

public class DraftController extends Controller {
	
	/**
	 * Temporary property to calculate money
	 */
	private int visualMoney;
	
	/**
	 * @param frame	game frame
	 */
	public DraftController(GameFrame frame) {
		super(frame);
	}

	@Override
	protected void initialize() {
		panel = new DraftPanel();
		visualMoney = frame.getGame().getData().getMoney();
		Market market = frame.getGame().getMarket();

		JLabel moneyValueLabel = ((DraftPanel) panel).getMoneyValueLabel();
		moneyValueLabel.setText("$" + visualMoney);
		List<JToggleButton> toggleButtons = ((DraftPanel) panel).getToggleButtons();
		for (JToggleButton toggle: toggleButtons) {
			int index = toggleButtons.indexOf(toggle);
			toggle.setText(market.athleteDescriptionAt(index));
			toggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int amount = market.calculatePurchasePriceAt(index);
					changeVisualMoney(amount, toggle, moneyValueLabel);
				}
			});
		}
		
		JButton confirmButton = ((DraftPanel) panel).getConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int teamCount = 0;
				for (JToggleButton toggle: toggleButtons) {
					if (toggle.isSelected()) {
						teamCount++;
					}
				}
				if (teamCount >= Team.MIN_TEAM_SIZE) {
//					for (JToggleButton toggle: toggleButtons) {
//						if (toggle.isSelected()) {
//							try {
//								frame.getGame().draftAthlete(toggleButtons.indexOf(toggle));
//							} catch (IndexOutOfBoundsException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							} catch (IllegalArgumentException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							} catch (TeamMemberLimitException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						}
//					}
					toHomeScreen();
				} else {
					JOptionPane.showMessageDialog(panel, "You don't have enough athletes to start! Select at least " + Team.MIN_TEAM_SIZE  + ".", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		launch();
	}

	private void toHomeScreen() {
		close();
		frame.toHomeScreen();
	}
	
	private void changeVisualMoney(int rawAmount, JToggleButton toggle, JLabel label) {
		int finalAmount = rawAmount * (toggle.isSelected() ? -1 : 1);
		
		if (visualMoney + finalAmount >= 0) {
			visualMoney += finalAmount;
			label.setText("$" + Integer.toString(visualMoney));
		} else {
			toggle.setSelected(false);
			JOptionPane.showMessageDialog(panel, "You don't have enough money! Select different athletes.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
