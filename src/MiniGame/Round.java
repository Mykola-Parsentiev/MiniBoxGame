package MiniGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Round {
	private List<Box> allRoundsBoxes = new ArrayList<Box>();
	private boolean bonusRound = false;
	
	public void setLifeBoxes(int amountLifeBoxes) {
		this.checkGetArgument(amountLifeBoxes);
		
		for (int i = 0; i < amountLifeBoxes; i++) {
			Box newBox = new Box();
			newBox.setLife();
			this.allRoundsBoxes.add(newBox);
			}	
		}
	
	public void setDeathBoxes(int amountDeathBoxes) {
		this.checkGetArgument(amountDeathBoxes);
		
		for (int i = 0; i < amountDeathBoxes; i++) {
			Box newBox = new Box();
			newBox.setDeath();
			this.allRoundsBoxes.add(newBox);
			}	
		}
	
	public void setChanceBoxes(int amountChanceBoxes) {
		this.checkGetArgument(amountChanceBoxes);
		
		for (int i = 0; i < amountChanceBoxes; i++) {
			Box newBox = new Box();
			newBox.setChance();
			this.allRoundsBoxes.add(newBox);
			}
		this.bonusRound = true;
		}
	
	public void setMoneyBoxes(int amountMoneyBoxes, int moneyReward) {
		this.checkGetArgument(amountMoneyBoxes);
		this.checkGetArgument(moneyReward);
		
		for (int i = 0; i < amountMoneyBoxes; i++) {
			Box newBox = new Box();
			newBox.setMoney(moneyReward);
			this.allRoundsBoxes.add(newBox);
			}	
		}
	
	private void checkGetArgument (int argument) {
		if ( argument < 0 )
			throw new IllegalArgumentException("Illegal argument!");
		}
	
	public void shuffleBoxes() {
		Collections.shuffle(this.allRoundsBoxes);
		}
	
	public boolean getBonusRaundState() {
		return this.bonusRound;
		}
	
	public List<Box> getRoundBoxes() {
		if ( this.allRoundsBoxes == null )
			throw new NullPointerException("Empty round!");
		return this.allRoundsBoxes;
		}
	
	}
