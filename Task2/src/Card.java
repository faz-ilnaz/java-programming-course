
public class Card {
	public Suits suit;
/*TODO rank тоже переделай на enum*/
	public String rang;
	
	final static String[] rangs = {"A","6","7","8","9","10","J","Q","K"};
	
	Card(Suits suit, String rang) {
		this.suit = suit;
		this.rang = rang;
	}
	
	@Override
	public String toString() {
		return this.rang + " " + this.suit;
	}
}
