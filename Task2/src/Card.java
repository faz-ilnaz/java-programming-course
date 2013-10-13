
public class Card {
	public Suits suit;
	public Rangs rang;
	
	Card(Suits suit, Rangs rang) {
		this.suit = suit;
		this.rang = rang;
	}
	
	@Override
	public String toString() {
		return this.rang + " " + this.suit;
	}
}
