package MiniGame;

import java.util.HashMap;

class Box {
	
	private HashMap<String, Boolean> boxState = new HashMap<String, Boolean>();
	private int moneyReward = 0;
	
	public void setNewBox () {
		boxState.put("Closed", true);
		boxState.put("Life", false);
	    boxState.put("Death", false);
	    boxState.put("SecondChance", false);
	    boxState.put("Money", false);
		}

	public HashMap<String, Boolean> getBoxState() {
		return this.boxState;
		}
	
	public void openBox() {
		boxState.put("Closed", false);
		}

	public void setLife() {
		setNewBox();
	    boxState.put("Life", true);;
		}
	
	public void setDeath() {
		setNewBox();
	    boxState.put("Death", true);
		}
	
	public void setChance() {
		setNewBox();
	    boxState.put("SecondChance", true);
		}
	
	public void setMoney(int reward) {
		if ( reward < 0 )
			throw new IllegalArgumentException("Illegal argument for money rewards!");
		
		setNewBox();
	    boxState.put("Money", true);
	    moneyReward = reward;
		}
	
	public int getMoney() {
		return this.moneyReward;
		}
	
}
