import java.util.*;
public class GameRunner {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck(1, true);
		
		Player me = new Player("Clement");
		Player dealer = new Player("Dealer");

		me.addCard(theDeck.dealNextCard());
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		me.printHand(true);
		dealer.printHand(false);
		
		boolean meDone = false;
		boolean dealerDone = false;
		String answer;
		
		while(!meDone && !dealerDone){
			while(!meDone){
				System.out.println("\nHit (H) or stay (S) ?\n");
				answer = sc.next();
				System.out.println();
				if (answer.compareToIgnoreCase("H") == 0){
					dealer.printHand(false);
					meDone = !me.addCard(theDeck.dealNextCard());
					System.out.println();
					me.printHand(true);
				}
				else
					meDone = true;
			}
			if(!dealerDone){
				dealer.printHand(true);
				while(dealer.getSumHand() < 17){
					System.out.println(dealer.getSumHand() + ", Dealer hits");
					dealerDone = !dealer.addCard(theDeck.dealNextCard());
					System.out.println();
				}
			if (dealer.getSumHand() > 21)
				System.out.println(dealer.getSumHand() +", Dealer busts\n");
			else
				System.out.println(dealer.getSumHand() +", Dealer stays\n");
			}
		}
		
		System.out.println();
		sc.close();
		me.printHand(true);
		dealer.printHand(true);
		System.out.println();
		
		int mySum = me.getSumHand();
		int dealerSum = dealer.getSumHand();
		if(mySum <= 21 && mySum > dealerSum || dealerSum > 21)
			System.out.println("Tu gagnes deux fois ta mise avec " + mySum + "\n");
		else
			System.out.println("Tu perds ta mise avec " + mySum + "\n");
		System.out.println("Le croupier fait " + dealerSum);
	}

}
