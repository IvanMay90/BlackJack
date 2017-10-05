
public class Card {

	private Suit mySuit;
	private int myNumber;
	
	public Card(Suit aSuit, int aNumber){
		this.mySuit = aSuit;
		if( aNumber > 0 && aNumber <= 14)
			this.myNumber = aNumber;
		else{
			System.err.println(aNumber + " n'est pas valide");
			System.exit(1);
		}	
	}
	
	public int getNumber(){
		return myNumber;
	}
	
	public String toString(){
		
		String str;
		switch(this.myNumber){
			case 1 : str = "As";break;
			case 2 : str = "Deux";break;
			case 3 : str = "Trois";break;
			case 4 : str = "Quatre";break;
			case 5 : str = "Cinq";break;
			case 6 : str = "Six";break;
			case 7 : str = "Sept";break;
			case 8 : str = "Huit";break;
			case 9 : str = "Neuf";break;
			case 10 : str = "Dix";break;
			case 11 : str = "Valet";break;
			case 12 : str = "Dame";break;
			case 13 : str = "Roi";break;
			default : str = "Bad value";break;
		}
		return "  " + str + " de " + mySuit.toString();
	}
}
