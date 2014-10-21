import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Game extends Object{
	
	List<Boolean> doubles = new ArrayList<Boolean>(Arrays.asList(new Boolean[3]));
	int numberOfTurns;
	int landedOn[] = new int[40];
	Player pawn;
	Random die1, die2, chan, comChest;
	Boolean isInJail;
	
	String positions[] = {"Go", "Mediterranean", "Community Chest",
			"Baltic", "Income Tax", "Reading RR", "Oriental", "Chance",
			"Vermont", "Connecticut", "Just Visiting", "Jail", "St. Charles",
			"Electric Company", "States", "Virginia", "Pennsylvania RR", "St. James",
			"Community Chest", "Tennessee", "New York", "Free Parking", "Kentucky", 
			"Chance", "Indiana", "Illinois", "B.&.O RR", "Atlantic", "Ventor", 
			"Water Works", "Marvin Gardens", "Go to Jail", "Pacific", "North Carolina",
			"Community Chest", "Pennsylvania", "Short Line RR", "Chance", "Park Place", 
			"Luxury Tax", "Boardwalk"};
	
	String chance[] = {"Advance to Go", "Advance to Illinois Ave", "Advance to St. Charles",
			"Advance to nearest utility", "Advance to nearest RR", "Bank pays you $50", 
			"Get out of jail free", "Go back 3 spaces", "Go to jail", "Make repairs on your property",
			"Pay 15 dollars", "Go to Reading RR", "Go to Boardwalk", "Pay each player $50", "Collect $150",
			"Collect $100"};
	String chest[] = {"Advance to Go", "Collect $200", "Pay $50", "Get $50", "Get out of jail Free", "Go to jail",
			"Collect $50 from each player", "Get $100", "Collect $20", "Collect $10 from each player",
			"Collect $100 dollars", "Pay $100", "Pay $150", "Get $25", "Get $100", "Get $10"};
	
	public Game(){
		Collections.fill(doubles, Boolean.FALSE);
		pawn = new Player();
		this.numberOfTurns = 0;
		this.die1 = new Random();
		this.die2 = new Random();
	}
	
	public int rollDice(){
		int result;
		int roll1, roll2;
		roll1 = die1.nextInt(6)+1;
		roll2 = die2.nextInt(6)+1;
		if(roll1 == roll2){
			doubles.add(Boolean.TRUE);
			System.out.println("You rolled doubles!");
		}
		result = roll1 + roll2;
		return result;
		
	}
	
	public void takeTurn(Player pawn){
		if(pawn.isInJail){
			//do something
		}
		int moveSpaces = rollDice();
		pawn.move(moveSpaces);
		
	}
	
	public void chance(Player pawn, int position){
		chan = new Random();
		int card = chan.nextInt(16);
		System.out.println("You pulled card number "+card+" from Chance");
	}
	
	public void communityChest(Player pawn, int position){
		comChest = new Random();
		int card = comChest.nextInt(16);
		System.out.println("You pulled card number "+card+" from comChest");
	}
	
	public static void main(String[] args){
		System.out.println("About to test monopoly");
		Game mon = new Game();
		mon.takeTurn(mon.pawn);
		System.out.println("Pawn is at "+mon.pawn.currentPosition);
	}
}
