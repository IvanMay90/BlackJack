import java.util.Random;

public class Deck {
	
	private Card[] myCards;
	private int nbCards;
	
	public Deck(){
		this(1,false);
	}
	
	public Deck(int nbDeck, boolean shuffle){
		
		this.nbCards = nbDeck * 52;
		this.myCards = new Card[this.nbCards];
		
		int c = 0;
		for (int d = 0; d < nbDeck; d++){
			for (int s = 0; s < 4; s++){
				for (int n = 1; n <= 13; n++){
					this.myCards[c] = new Card(Suit.values()[s], n);
					c++;
				}
			}
		}
		if (shuffle){
			this.shuffle();
		}
	}

	public void shuffle(){
		Random rng = new Random();
		Card temp;
		
		int j;
		for (int i = 0; i < this.nbCards; i++){
			
			j = rng.nextInt(this.nbCards);
			temp = this.myCards[i];
			myCards[i] = myCards[j];
			myCards[j] = temp;
		}
	}

	public Card dealNextCard(){
		
		Card cardTop = this.myCards[0];
		
		for (int c = 1; c < this.nbCards; c++){
			this.myCards[c-1] = this.myCards[c];
		}
		this.myCards[this.nbCards-1] = null;
		nbCards--;
		
		return cardTop;
	}
	
	public void printDeck(int numToPrint){
		for (int c = 0; c < numToPrint; c++){
			System.out.printf("% 3d/%d %s\n", c+1, this.nbCards,
					this.myCards[c].toString());
		}
		System.out.printf("\t\t[%d other]\n", this.nbCards-numToPrint);
	}
}
