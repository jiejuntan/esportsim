/**
 * 
 */
package main.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

		JLabel moneyValueLabel = ((DraftPanel) panel).getMoneyLabel();
		moneyValueLabel.setText("Money: $" + visualMoney);
		
		
		List<JToggleButton> toggleButtons = ((DraftPanel) panel).getToggleButtons();
		List<JTextField> textFields = ((DraftPanel) panel).getTextFields();
		for (JToggleButton athleteToggle: toggleButtons) {
			int index = toggleButtons.indexOf(athleteToggle);
			JTextField athleteTextField = textFields.get(index);
			athleteTextField.setText(market.getAvailableAthletes().get(index).getName());
			athleteTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (String.valueOf(e.getKeyChar()).matches("[ a-zA-Z]")
							&& athleteTextField.getText().length() >= 10
							|| String.valueOf(e.getKeyChar()).matches("[0-9!@#$%^&*()-_=+|\\\\:;\"',.<>?/{}\\[\\]]")) {
						e.consume();
						JOptionPane.showMessageDialog(panel, 
								"Your desired name must be under 10 characters long and only contain letters.", 
								"Error", JOptionPane.ERROR_MESSAGE);

					}
				}
			});
			athleteToggle.setText(market.athleteDescriptionAt(index));
			athleteToggle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					athleteTextField.setEditable(athleteToggle.isSelected());
					athleteTextField.setFocusable(athleteToggle.isSelected());
					athleteTextField.requestFocus();
					int amount = market.calculatePurchasePriceAt(index);
					changeVisualMoney(amount, athleteToggle, moneyValueLabel);
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
					Map<Integer, String> indexes = new HashMap<Integer, String>();
					for (JToggleButton toggle: toggleButtons) {
						if (toggle.isSelected()) {
							int index = toggleButtons.indexOf(toggle);
							indexes.put(index, textFields.get(index).getText());
						}
					}
					market.purchaseAthletesAt(indexes);
					toHomeScreen();
				} else {
					JOptionPane.showMessageDialog(panel, 
							"You don't have enough athletes to start! Select at least " + Team.MIN_TEAM_SIZE  + ".", 
							"Error", JOptionPane.ERROR_MESSAGE);
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
			label.setText("Money: $" + visualMoney);
		} else {
			toggle.setSelected(false);
			JOptionPane.showMessageDialog(panel, 
					"You don't have enough money! Select different athletes.", 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
