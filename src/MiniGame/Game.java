package MiniGame;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	List<Round> game = new ArrayList<Round>();
	private boolean gameOver = false;
	
	private int activeRound = 0;
	private int life = 1;
	private int rewards = 0;
	private boolean secondChance = false;
	
	public void typicalGame() {
		Round round1 = new Round();
		round1.setMoneyBoxes(1, 100);
		round1.setMoneyBoxes(2, 20);
		round1.setMoneyBoxes(5, 5);
		round1.setDeathBoxes(3);
		round1.setLifeBoxes(1);
		round1.shuffleBoxes();
		game.add(round1);
		
		Round round2 = new Round();
		round2.setChanceBoxes(1);
		round2.setMoneyBoxes(1, 5);
		round2.setMoneyBoxes(1, 10);
		round2.setMoneyBoxes(1, 20);
		round2.shuffleBoxes();
		game.add(round2);
		}
	
	public Round getRound(int numRound) {
		this.checkGetArgument(numRound);
		return game.get(numRound);
		}
	
	public Round getActiveRound() {
		return game.get(activeRound);
		}
	
	public Box getBox(int numBox) {
		checkGetArgument(numBox);
		return getRound(activeRound).getRoundBoxes().get(numBox);
		}
	
	public int amountBoxActRound() {
		return getRound(activeRound).getRoundBoxes().size();
		}
	
	public void removeBox(int numBox) {
		checkGetArgument(numBox);
		getRound(activeRound).getRoundBoxes().remove(numBox);
		}
	
	public boolean checkForCloseBox(int numBox) {
		return this.getBox(numBox).getBoxState().get("Closed");
	}
	
	public void checkBox(int numBox){
		if ( getBox(numBox) == null )
			throw new NullPointerException("Empty box!");
		
		if (this.getBox(numBox).getBoxState().get("Life") == true) {
    		life++;
    		System.out.println("+ 1 Life");
    		}
    	if (getBox(numBox).getBoxState().get("Death") == true) {
    		life--;
    		System.out.println("Death");
    		}
    	if (getBox(numBox).getBoxState().get("SecondChance") == true) {
    		secondChance = true;
    		System.out.println("SecondChance");
    		}
    	if (getBox(numBox).getBoxState().get("Money") == true) {
    		this.rewards += this.getBox(numBox).getMoney();
    		System.out.println("You win money +" + this.getBox(numBox).getMoney() + "$");
    		}
		if (getActiveRound().getBonusRaundState() == true) {
			life--;
			}
		}
	
	public void takeBox(int numBox){
		if ( getBox(numBox) == null )
			throw new NullPointerException("Empty box!");
		
		this.getBox(numBox).openBox();
		
		if (this.getBox(numBox).getBoxState().get("Life") == true) {
    		life++;
    		}
    	if (getBox(numBox).getBoxState().get("Death") == true) {
    		life--;
    		}
    	if (getBox(numBox).getBoxState().get("SecondChance") == true) {
    		secondChance = true;
    		}
    	if (getBox(numBox).getBoxState().get("Money") == true) {
    		this.rewards += this.getBox(numBox).getMoney();
    		}
		if (getActiveRound().getBonusRaundState() == true) {
			life--;
			}
		this.removeBox(numBox);
		}
	
	public int getLife() {
		return life;
		}
	
	public int getNumActiveRound() {
		return activeRound;
		}
	
	public void prevRound() {
		activeRound--;
		}
	
	public void nextRound() {
		activeRound++;
		}
	
	public void addLife() {
		life++;
		}
	
	public boolean getGameOver() {
		return gameOver;
		}
	
	public void checkGameOver() {
		if (this.getActiveRound().getBonusRaundState() == false) {
			this.addLife();
			this.nextRound();
			}
		else {
			if (this.secondChance() == true){
				this.addLife();
				this.prevRound();
				}
			else {
				this.gameOver = true;
				}
			}
		}
	
	public boolean secondChance() {
		boolean tmp = secondChance;
		secondChance = false;
		return tmp;
		}
	
	public int getReward() {
		return rewards;
		}
	
	private void checkGetArgument(int argument) {
		if ( argument < 0 )
			throw new IllegalArgumentException("Illegal argument!");
		}
	
	}