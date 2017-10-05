
public class Player {

	private String name;
	private Card[] hand = new Card[10];
	private int nbCards;
	
	public Player(String name){
		this.name = name;
		this.emptyHand();
	}
	public void emptyHand(){
		for(int i = 0; i < nbCards; i++){
			hand[i] = null;
			nbCards = 0;	
		}
	}

	public boolean addCard(Card aCard){
		this.hand[nbCards] = aCard;
		nbCards++;
		return (this.getSumHand() <= 21);
	}
	
	public int getSumHand(){
		int sum = 0;
		int cardNb;
		int nbAces = 0;
		
		for (int i = 0; i < this.nbCards; i++){
			cardNb = this.hand[i].getNumber();
			if (cardNb == 1){
				nbAces++;
				sum += 11;
			}
			else if(cardNb > 10)
				sum += 10; 
			else
				sum += cardNb;
		}
		
		while (sum > 21 && nbAces > 0){
			sum -= 10;
			nbAces--;
		}
		
		return sum;
	}
	public void printHand(boolean showFirstCard){
		System.out.printf("Les cartes de %s\n", this.name);
		for (int i = 0; i < nbCards; i++){
			if( i == 0 && !showFirstCard)
				System.out.println("  [HIDDEN]");
			else{
				System.out.printf(this.hand[i].toString());
				System.out.println();
			}
		}
	}
}
