import java.util.Random;

public class Deck {
	private Card[] deck;
	
	public Deck() {
		this.deck = new Card[36];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 9; j++) {
				deck[i * 9 + j] = new Card(Suits.values()[i], Rangs.values()[j]);
			}
		}
	}
	
	public void shuffle() {
		Random r = new Random();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 9; j++) {
				move( i*9+j, r.nextInt(36));
			}
		}
	}
	
	public void move(int oldIndex, int newIndex) {
		Card temp = deck[newIndex];
		deck[newIndex] = deck[oldIndex];
		deck[oldIndex] = temp;
	}
	
	public void print() {
		for(int i = 0; i < 36; i++) {
			System.out.println(deck[i]);
		}
			
	}
}